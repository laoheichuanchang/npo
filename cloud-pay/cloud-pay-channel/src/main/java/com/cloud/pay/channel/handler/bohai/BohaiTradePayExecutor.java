package com.cloud.pay.channel.handler.bohai;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.cloud.pay.channel.handler.ITradePayExecutor;
import com.cloud.pay.channel.utils.JaxbUtil;
import com.cloud.pay.channel.vo.BaseTradeResVO;
import com.cloud.pay.channel.vo.PayTradeReqVO;
import com.cloud.pay.channel.vo.PayTradeResVO;
import com.cloud.pay.channel.vo.bohai.BohaiCloudTradeErrorResult;
import com.cloud.pay.channel.vo.bohai.BohaiCloudTradePayParam;
import com.cloud.pay.channel.vo.bohai.BohaiCloudTradePayResult;
import com.cloud.pay.channel.vo.bohai.BohaiCloudTradeQueryParam;
import com.cloud.pay.channel.vo.bohai.BohaiCloudTradeResult;
import com.cloud.pay.channel.vo.bohai.BohaiCloudUnionTradeResult;
import com.cloud.pay.common.contants.ChannelContants;
import com.cloud.pay.common.contants.ChannelErrorCode;
import com.cloud.pay.common.entity.SysConfig;
import com.cloud.pay.common.mapper.SysConfigMapper;

/**
 * 渤海代付接口（参数为泛型）
 * @author wangy
 */
@Service("bohaiTradePayExecutor")
public class BohaiTradePayExecutor extends BohaiTradeExecutor<BohaiCloudTradePayParam, BohaiCloudTradePayResult>
                      implements ITradePayExecutor<PayTradeReqVO,PayTradeResVO>{
   
	private Logger log = LoggerFactory.getLogger(BohaiTradePayExecutor.class);
    
	@Value("${cloud.bohai.pay.large.sub.value}")
	private BigDecimal largeSubValue;  //渤海代付大额值
	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	@Override
	public PayTradeResVO execute(PayTradeReqVO param) {
		PayTradeResVO resVO = null;
		try {
			 BohaiCloudTradePayParam payParam = createParam(param);
			 BohaiCloudTradePayResult result = request(payParam, param.getAmt().compareTo(largeSubValue) <= 0 ? 
					 ChannelContants.CHANNEL_BOHAI_REQ_HEADER_SCS:ChannelContants.CHANNEL_BOHAI_REQ_HEADER_SCHP);
			 if(!"0".equals(result.getRspCode())) {
				  resVO = new PayTradeResVO(param.getMerchantId(),param.getOrderNo(),result.getRspCode(),
						  StringUtils.isNotBlank(result.getErrorCode())?result.getErrorCode():ChannelErrorCode.ERROR_9001,
						  StringUtils.isNotBlank(result.getErrorMessage())?result.getErrorMessage():result.getRspMsg());
				  if("1002".equals(result.getErrorCode())) {
					  resVO.setStatus(ChannelContants.CHANNEL_RETURN_STATUS_UNKNOWN);
				  }else {
					  resVO.setStatus(ChannelContants.CHANNEL_RETURN_STATUS_FAIL);
				  }
				  resVO.setRespCode(ChannelContants.CHANNEL_RESP_CODE_SUCCESS);
				  log.info("渠道接口：代付处理结束，响应参数：{}",resVO);
				  return resVO;
			 }
			 resVO = new PayTradeResVO(param.getMerchantId(),param.getOrderNo(),"代付成功",result.getActDat());
			 resVO.setStatus(ChannelContants.CHANNEL_RETURN_STATUS_SUCCESS);
			 log.info("渠道接口：代付处理结束，响应参数：{}",resVO);
		}catch(Exception e) {
			log.error("渤海代付失败：{}",e);
			resVO = new PayTradeResVO(param.getMerchantId(),param.getOrderNo(),ChannelContants.CHANNEL_RESP_CODE_FAIL,ChannelErrorCode.ERROR_9000,"系统异常");
		}
		return resVO;
	}

	
	/**
       * 构建代付参数
     * @param reqVO
     * @return
	 * @throws Exception 
     */
	private BohaiCloudTradePayParam createParam(PayTradeReqVO reqVO) throws Exception {
		BohaiCloudTradePayParam payParam = new BohaiCloudTradePayParam();
		payParam.setDate(reqVO.getTradeDate());
		payParam.setSerialNo(reqVO.getOrderNo());
		
		SysConfig payerAccountConfig = sysConfigMapper.selectByPrimaryKey("BHPayerAccount");
		SysConfig payerNameConfig = sysConfigMapper.selectByPrimaryKey("BHPayerName");
		if(null == payerAccountConfig || null == payerNameConfig) {
			throw new Exception("系统错误:渠道系统参数未配置");
		}
		payParam.setPyrAct(payerAccountConfig.getSysValue());
		payParam.setPyrNam(payerNameConfig.getSysValue());
		if(StringUtils.isNotBlank(reqVO.getAccountNo())) {
		   payParam.setActNo(reqVO.getAccountNo());
		}
		if(StringUtils.isNotBlank(reqVO.getAccountName())) {
		   payParam.setActNam(reqVO.getAccountName());
		}
		payParam.setPyeAct(reqVO.getPayeeAccount());
		payParam.setPyeNam(reqVO.getPayeeName());
		payParam.setPyeBnk(reqVO.getPayeeBankCode());

		payParam.setAmt(reqVO.getAmt());
		payParam.setPostscript(reqVO.getPostscript());
		return payParam;
	}
	

	@Override
	protected BohaiCloudTradePayResult buildResult(String xmlRsp,String serialNo){
		BohaiCloudTradePayResult result = null;		
		try {
			Document document = DocumentHelper.parseText(xmlRsp);
			Element rootElt = document.getRootElement();
			//拿到根节点的名称
			Element message = (Element)rootElt.element("Message");
			Element error = (Element)message.element("Error");
			if(null != error){
				BohaiCloudTradeErrorResult errorResult = JaxbUtil.fromXml(error.asXML(), BohaiCloudTradeErrorResult.class);
				result = new BohaiCloudTradePayResult();
				BeanUtils.copyProperties(errorResult, result);
				result.setRspCode(ChannelContants.CHANNEL_RESP_CODE_FAIL);
				return result;
			}
			
			Element response = (Element)message.element(ChannelContants.CHANNEL_BOHAI_RES_HEADER_SCS);
			result =  JaxbUtil.fromXml(response.asXML(), BohaiCloudTradePayResult.class);
		} catch (DocumentException e) {
			log.error("代付，解析xml错误:{}",e);
		}
		return result;
	}
	
	
}
