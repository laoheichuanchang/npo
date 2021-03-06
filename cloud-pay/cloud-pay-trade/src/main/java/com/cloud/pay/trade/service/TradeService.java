package com.cloud.pay.trade.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.pay.channel.vo.PayTradeQueryResVO;
import com.cloud.pay.channel.vo.PayTradeResVO;
import com.cloud.pay.trade.constant.TradeConstant;
import com.cloud.pay.trade.dto.FeeStatDTO;
import com.cloud.pay.trade.dto.PayResponseDTO;
import com.cloud.pay.trade.dto.TradeDTO;
import com.cloud.pay.trade.dto.TradeRecordDTO;
import com.cloud.pay.trade.dto.TradeStatDTO;
import com.cloud.pay.trade.entity.Trade;
import com.cloud.pay.trade.exception.TradeException;
import com.cloud.pay.trade.mapper.TradeMapper;

@Service
public class TradeService {

	private Logger log = LoggerFactory.getLogger(TradeService.class);
	
	@Autowired
	private TradeMapper tradeMapper;

	@Autowired
	private PayHandler payHandler;

	public List<Trade> selectByBatchNo(String batchNo) {
		return tradeMapper.selectByBatchNo(batchNo);
	}
	
	/**
	 * 单笔代付
	 * @param trade
	 * @return
	 */
	public PayResponseDTO pay(Trade trade) {
		PayResponseDTO resDTO = new PayResponseDTO();
		resDTO.setOrderNo(trade.getOrderNo());
		try {
			payHandler.singlePay(trade);
			payHandler.freezeMerchantFee(trade);
			PayTradeResVO resVO = payHandler.invokePay(trade);
			payHandler.updateTradeStatus(trade, resVO);
			resDTO.setStatus(trade.getStatus());
			resDTO.setReturnInfo(trade.getReturnInfo());
			resDTO.setReturnCode(trade.getReturnCode());
		} catch(TradeException e) {
			resDTO.setStatus(TradeConstant.STATUS_PROCESSING);
			resDTO.setReturnInfo(e.getMessage());
			resDTO.setReturnCode(e.getExCode());
			trade.setStatus(TradeConstant.STATUS_PROCESSING); 
			trade.setReturnCode(e.getExCode());
			trade.setReturnInfo(e.getMessage());
			trade.setTradeConfirmTime(new Date());
			tradeMapper.updateStatus(trade);
		} catch(Exception e) {
			log.error("单笔代付异常：{}", e);
			resDTO.setStatus(TradeConstant.STATUS_PROCESSING);
			resDTO.setReturnInfo("系统内部异常");
			resDTO.setReturnCode(TradeConstant.SYS_EXCEPTION);
			trade.setStatus(TradeConstant.STATUS_PROCESSING); 
			trade.setReturnCode(TradeConstant.SYS_EXCEPTION);
			trade.setReturnInfo(e.getMessage());
			trade.setTradeConfirmTime(new Date());
//			tradeMapper.updateStatus(trade);
		}
		return resDTO;
	}
	
	/**
	 * 交易统计
	 * @param merchantId
	 * @param orgId
	 * @param startTime
	 * @param endTime
	 * @param userMerchantId
	 * @param userMerchantType
	 * @return
	 */
	public TradeStatDTO tradeStat(Integer merchantId, Integer orgId, Date startTime, Date endTime,
			Integer userMerchantId, String userMerchantType) {
		return tradeMapper.tradeStat(merchantId, orgId, startTime, endTime, userMerchantId, userMerchantType);
	}
	
	/**
	 * 垫资交易统计
	 * @param merchantId
	 * @param orgId
	 * @param startTime
	 * @param endTime
	 * @param userMerchantId
	 * @param userMerchantType
	 * @return
	 */
	public TradeStatDTO loanTradeStat(Integer merchantId, Integer orgId, Date startTime, Date endTime,
			Integer userMerchantId, String userMerchantType) {
		return tradeMapper.loanTradeStat(merchantId, orgId, startTime, endTime, userMerchantId, userMerchantType);
	}
	
	/**
	 * 交易列表查询
	 * @author dbnaxlc
	 * @date 2018年9月14日 上午11:07:14
	 * @param merchantId
	 * @param orgId
	 * @param orderNo
	 * @param batchNo
	 * @param loaning
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<TradeRecordDTO> selectTradeList(Integer merchantId, Integer orgId,
		 String orderNo, String batchNo, Integer loaning,
			Date startTime, Date endTime, Integer userMerchantId, String userMerchantType) {
		return tradeMapper.selectTradeList(merchantId, orgId, orderNo, batchNo, loaning, 
				startTime, endTime, userMerchantId, userMerchantType);
	}
	
	/**
	 * 商户手续费统计
	 * @author dbnaxlc
	 * @date 2018年9月14日 下午3:12:42
	 * @param merchantId
	 * @param orgId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<FeeStatDTO> selectMerchantFeeStats(Integer merchantId, Integer orgId,
			Date startTime, Date endTime, Integer userMerchantId, String userMerchantType) {
		return tradeMapper.selectMerchantFeeStats(merchantId, orgId, startTime, endTime, userMerchantId, userMerchantType);
	}
	
	public List<FeeStatDTO> selectOrgFeeStats(Integer orgId,
			Date startTime, Date endTime, Integer userMerchantId, String userMerchantType) {
		List<FeeStatDTO> orgStats = tradeMapper.selectOrgTradeFeeStats(orgId, startTime, endTime, userMerchantId, userMerchantType);
		log.info("机构交易手续费统计记录：{}", orgStats);
		List<FeeStatDTO> merchantStats = tradeMapper.selectMerchantFeeByOrg(orgId, startTime, endTime);
		log.info("机构下商户交易分润统计记录：{}", merchantStats);
		log.info("合并机构交易手续费");
		Map<String, FeeStatDTO> feeMap = new HashMap<String, FeeStatDTO>();
		for(FeeStatDTO stat : orgStats) {
			feeMap.put(stat.getStatDate() + stat.getMerchantCode(), stat);
		}
		for(FeeStatDTO stat : merchantStats) {
			if(feeMap.get(stat.getStatDate() + stat.getMerchantCode()) == null) {
				stat.setOrgBenefit(stat.getFeeAmount());
				stat.setFeeAmount(BigDecimal.ZERO);
				feeMap.put(stat.getStatDate() + stat.getMerchantCode(), stat);
			} else {
				FeeStatDTO orgStat = feeMap.get(stat.getStatDate() + stat.getMerchantCode());
				orgStat.setOrgBenefit(stat.getFeeAmount());
			}
		}
		return new ArrayList<>(feeMap.values());
	}
	
	/**
	 * 根据商户和订单号查询代付信息
	 * @param merchantId
	 * @param orderNo
	 * @return
	 */
	public TradeDTO selectTradeByMerIdAndOrderNo(Integer merchantId,String orderNo) {
		TradeDTO tradeDTO = tradeMapper.selectTradeByMerIdAndOrderNo(merchantId, orderNo);
		log.info("商户ID[{}],订单号[{}]查询结果为：{}", merchantId, orderNo, tradeDTO);
		if(null == tradeDTO) {
			log.info("订单号{}不存在",orderNo);
			return null;
		}
		if(TradeConstant.STATUS_SUCCESS == tradeDTO.getStatus()
			||TradeConstant.STATUS_FAIL == tradeDTO.getStatus()) {
			return tradeDTO;
		} else {
			//查询渠道
			Trade trade = new Trade();
			trade.setMerchantId(merchantId);
			trade.setOrderNo(orderNo);
			trade.setPlatOrderNo(tradeDTO.getPlatOrderNo());
			trade.setChannelId(tradeDTO.getChannelId());
			trade.setTradeTime(tradeDTO.getTradeTime());
			trade.setTradeAmount(tradeDTO.getTradeAmount());
			PayTradeQueryResVO resVO = payHandler.invokeQuery(trade);
			//TODO 添加channelID，或者在做交易时已经把channelID添加
			//最好查询。交易都返回同一个DTO
			PayTradeResVO payVO = new PayTradeResVO(resVO.getErrorCode(), resVO.getErrorMessage());
			payVO.setStatus(resVO.getStatus());
			payVO.setAccountDate(resVO.getAccountDate());
			payVO.setRespCode(resVO.getRespCode());
			payVO.setRespMsg(resVO.getRespMsg());
			payVO.setMerchantId(merchantId);
			payVO.setOrderNo(orderNo);
			try {
				payHandler.updateTradeStatus(trade, payVO);
				tradeDTO.setStatus(trade.getStatus());
				tradeDTO.setReturnInfo(trade.getReturnInfo());
				tradeDTO.setReturnCode(trade.getReturnCode());
			} catch (Exception e) {
				log.warn("商户ID[{}],订单号[{}]查询异常", merchantId, orderNo, e);
				tradeDTO.setStatus(TradeConstant.STATUS_PROCESSING); 
				tradeDTO.setReturnCode(TradeConstant.SYS_EXCEPTION);
				tradeDTO.setReturnInfo(e.getMessage());
			}
			return tradeDTO;
		}
	}
	
	/**
	 * 交易调账
	 * @param trade
	 * @throws Exception 
	 */
	public void reconAdjustTrade(Trade trade) throws Exception {
		log.info("处理调账交易开始，{}", trade);
		if(Objects.equals(TradeConstant.STATUS_SUCCESS, trade.getReconStatus())
				&& Objects.equals(TradeConstant.STATUS_PROCESSING, trade.getStatus())) {
			log.info("原交易[{}]处理中，对账后成功，继续处理账户", trade.getId());
			payHandler.saveJournal(trade);
		} else if(Objects.equals(TradeConstant.STATUS_SUCCESS, trade.getReconStatus())
				&& Objects.equals(TradeConstant.STATUS_FAIL, trade.getStatus())) {
			log.info("原交易[{}]失败，对账后成功，调减账户", trade.getId());
			//先冻结商户资金
			payHandler.freezeMerchantFee(trade);
			//处理资金
			payHandler.saveJournal(trade);
		}
	}
}
