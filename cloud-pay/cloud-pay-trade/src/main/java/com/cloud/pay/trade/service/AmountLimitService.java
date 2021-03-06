package com.cloud.pay.trade.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.pay.trade.constant.AmountLimitConstant;
import com.cloud.pay.trade.dto.AmountLimitDTO;
import com.cloud.pay.trade.entity.AmountLimit;
import com.cloud.pay.trade.exception.AmountLimitException;
import com.cloud.pay.trade.mapper.AmountLimitMapper;

@Service
public class AmountLimitService {

	private Logger log = LoggerFactory.getLogger(AmountLimitService.class);

	@Autowired
	private AmountLimitMapper amountLimitMapper;

	@Transactional
	public int update(AmountLimit amountLimit) {
		log.info("查询已存在的限额信息，类型：{}，商户ID：{}", amountLimit.getType(), amountLimit.getMerchantId());
		List<AmountLimit> limits = amountLimitMapper.selectExist(amountLimit.getType(), amountLimit.getMerchantId());
		if(limits != null && limits.size() > 1) {
			buildExMessage(amountLimit.getType(), amountLimit.getMerchantId());
		} else if(limits != null && limits.size() == 1) {
			if(!Objects.equals(amountLimit.getId(), limits.get(0).getId())) {
				buildExMessage(amountLimit.getType(), amountLimit.getMerchantId());
			}
		} 
		log.info("修改AmountLimit信息：{}", amountLimit);
		return amountLimitMapper.updateByPrimaryKeySelective(amountLimit);
	}

	@Transactional
	public int save(AmountLimit amountLimit) {
		log.info("查询已存在的限额信息，类型：{}，商户ID：{}", amountLimit.getType(), amountLimit.getMerchantId());
		List<AmountLimit> limits = amountLimitMapper.selectExist(amountLimit.getType(), amountLimit.getMerchantId());
		if(limits != null && limits.size() > 0) {
			buildExMessage(amountLimit.getType(), amountLimit.getMerchantId());
		}
		log.info("新增AmountLimit信息：{}", amountLimit);
		return amountLimitMapper.insert(amountLimit);
	}

	/**
	 * 构造异常信息
	 * @param type
	 * @param merchantId
	 */
	private void buildExMessage(Integer type, Integer merchantId) {
		if(AmountLimitConstant.PER_LIMIT == type) {
			log.warn("单笔限额已存在");
			throw new AmountLimitException("单笔限额已存在", null);
		} else if(AmountLimitConstant.MERCHNAT_LIMIT == type) {
			log.warn("商户{}限额已存在", merchantId);
			throw new AmountLimitException("商户限额已存在", null);
		} else if(AmountLimitConstant.ORG_LIMIT == type) {
			log.warn("机构{}限额已存在", merchantId);
			throw new AmountLimitException("机构限额已存在", null);
		} 
	}
	
	@Transactional
	public int del(Integer id) {
		log.info("根据AmountLimitID[{}]删除：{}", id);
		return amountLimitMapper.deleteByPrimaryKey(id);
	}

	public List<AmountLimitDTO> getAmountLimitList(Integer type, String orgName, String merchantName, Date startTime,
			Date endTime, Integer userMerchantId, String userMerchantType) {
		List<AmountLimitDTO> dtos =  amountLimitMapper.getAmountLimitList(type, orgName, merchantName, 
				startTime, endTime, userMerchantId, userMerchantType);
		for(AmountLimitDTO dto : dtos) {
			if(dto.getType() == 3) {
				dto.setOrgName(dto.getMerchantName());
				dto.setOrgName("");
			}
		}
		return dtos;
	}
}
