package com.cloud.pay.trade.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.order_no
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String orderNo;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.merchant_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer merchantId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.trade_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Date tradeTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.trade_amount
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private BigDecimal tradeAmount;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.channel_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer channelId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.return_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String returnCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.return_info
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String returnInfo;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.payer_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer payerId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.payee_name
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String payeeName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.payee_bank_card
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String payeeBankCard;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.payee_bank_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String payeeBankCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.trade_confirm_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Date tradeConfirmTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.remark
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private String remark;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.settle_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer settleStatus;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.recon_date
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Date reconDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_trade.recon_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	private Integer reconStatus;

	private String batchNo;
	
	//平台订单号
	private String platOrderNo;
	
	private Integer seqNo;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.id
	 *
	 * @return the value of t_trade.id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.id
	 *
	 * @param id
	 *            the value for t_trade.id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.order_no
	 *
	 * @return the value of t_trade.order_no
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.order_no
	 *
	 * @param orderNo
	 *            the value for t_trade.order_no
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.merchant_id
	 *
	 * @return the value of t_trade.merchant_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.merchant_id
	 *
	 * @param merchantId
	 *            the value for t_trade.merchant_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.trade_time
	 *
	 * @return the value of t_trade.trade_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Date getTradeTime() {
		return tradeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.trade_time
	 *
	 * @param tradeTime
	 *            the value for t_trade.trade_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.trade_amount
	 *
	 * @return the value of t_trade.trade_amount
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.trade_amount
	 *
	 * @param tradeAmount
	 *            the value for t_trade.trade_amount
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.status
	 *
	 * @return the value of t_trade.status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.status
	 *
	 * @param status
	 *            the value for t_trade.status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.channel_id
	 *
	 * @return the value of t_trade.channel_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.channel_id
	 *
	 * @param channelId
	 *            the value for t_trade.channel_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.return_code
	 *
	 * @return the value of t_trade.return_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.return_code
	 *
	 * @param returnCode
	 *            the value for t_trade.return_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode == null ? null : returnCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.return_info
	 *
	 * @return the value of t_trade.return_info
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getReturnInfo() {
		return returnInfo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.return_info
	 *
	 * @param returnInfo
	 *            the value for t_trade.return_info
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo == null ? null : returnInfo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.payer_id
	 *
	 * @return the value of t_trade.payer_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getPayerId() {
		return payerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.payer_id
	 *
	 * @param payerId
	 *            the value for t_trade.payer_id
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setPayerId(Integer payerId) {
		this.payerId = payerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.payee_name
	 *
	 * @return the value of t_trade.payee_name
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getPayeeName() {
		return payeeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.payee_name
	 *
	 * @param payeeName
	 *            the value for t_trade.payee_name
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName == null ? null : payeeName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.payee_bank_card
	 *
	 * @return the value of t_trade.payee_bank_card
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getPayeeBankCard() {
		return payeeBankCard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.payee_bank_card
	 *
	 * @param payeeBankCard
	 *            the value for t_trade.payee_bank_card
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setPayeeBankCard(String payeeBankCard) {
		this.payeeBankCard = payeeBankCard == null ? null : payeeBankCard.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.payee_bank_code
	 *
	 * @return the value of t_trade.payee_bank_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getPayeeBankCode() {
		return payeeBankCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.payee_bank_code
	 *
	 * @param payeeBankCode
	 *            the value for t_trade.payee_bank_code
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode == null ? null : payeeBankCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.trade_confirm_time
	 *
	 * @return the value of t_trade.trade_confirm_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Date getTradeConfirmTime() {
		return tradeConfirmTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.trade_confirm_time
	 *
	 * @param tradeConfirmTime
	 *            the value for t_trade.trade_confirm_time
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setTradeConfirmTime(Date tradeConfirmTime) {
		this.tradeConfirmTime = tradeConfirmTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.remark
	 *
	 * @return the value of t_trade.remark
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.remark
	 *
	 * @param remark
	 *            the value for t_trade.remark
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.settle_status
	 *
	 * @return the value of t_trade.settle_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getSettleStatus() {
		return settleStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.settle_status
	 *
	 * @param settleStatus
	 *            the value for t_trade.settle_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setSettleStatus(Integer settleStatus) {
		this.settleStatus = settleStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.recon_date
	 *
	 * @return the value of t_trade.recon_date
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Date getReconDate() {
		return reconDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.recon_date
	 *
	 * @param reconDate
	 *            the value for t_trade.recon_date
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setReconDate(Date reconDate) {
		this.reconDate = reconDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_trade.recon_status
	 *
	 * @return the value of t_trade.recon_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public Integer getReconStatus() {
		return reconStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_trade.recon_status
	 *
	 * @param reconStatus
	 *            the value for t_trade.recon_status
	 *
	 * @mbggenerated Sun Sep 09 10:52:02 CST 2018
	 */
	public void setReconStatus(Integer reconStatus) {
		this.reconStatus = reconStatus;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	private Integer loaning;

	private Integer payeeBankAcctType;

	private String payeeBankName;

	private BigDecimal merchantFeeAmount;

	private BigDecimal loanBenefit;

	private BigDecimal orgBenefit;

	public Integer getLoaning() {
		return loaning;
	}

	public void setLoaning(Integer loaning) {
		this.loaning = loaning;
	}

	public Integer getPayeeBankAcctType() {
		return payeeBankAcctType;
	}

	public void setPayeeBankAcctType(Integer payeeBankAcctType) {
		this.payeeBankAcctType = payeeBankAcctType;
	}

	public String getPayeeBankName() {
		return payeeBankName;
	}

	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
	}

	public BigDecimal getMerchantFeeAmount() {
		return merchantFeeAmount;
	}

	public void setMerchantFeeAmount(BigDecimal merchantFeeAmount) {
		this.merchantFeeAmount = merchantFeeAmount;
	}

	public BigDecimal getLoanBenefit() {
		return loanBenefit;
	}

	public void setLoanBenefit(BigDecimal loanBenefit) {
		this.loanBenefit = loanBenefit;
	}

	public BigDecimal getOrgBenefit() {
		return orgBenefit;
	}

	public void setOrgBenefit(BigDecimal orgBenefit) {
		this.orgBenefit = orgBenefit;
	}
	
	public String getPlatOrderNo() {
		return platOrderNo;
	}

	public void setPlatOrderNo(String platOrderNo) {
		this.platOrderNo = platOrderNo;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [id=");
		builder.append(id);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", merchantId=");
		builder.append(merchantId);
		builder.append(", tradeTime=");
		builder.append(tradeTime);
		builder.append(", tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", returnCode=");
		builder.append(returnCode);
		builder.append(", returnInfo=");
		builder.append(returnInfo);
		builder.append(", payerId=");
		builder.append(payerId);
		builder.append(", payeeName=");
		builder.append(payeeName);
		builder.append(", payeeBankCard=");
		builder.append(payeeBankCard);
		builder.append(", payeeBankCode=");
		builder.append(payeeBankCode);
		builder.append(", tradeConfirmTime=");
		builder.append(tradeConfirmTime);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", settleStatus=");
		builder.append(settleStatus);
		builder.append(", reconDate=");
		builder.append(reconDate);
		builder.append(", reconStatus=");
		builder.append(reconStatus);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", platOrderNo=");
		builder.append(platOrderNo);
		builder.append(", seqNo=");
		builder.append(seqNo);
		builder.append(", loaning=");
		builder.append(loaning);
		builder.append(", payeeBankAcctType=");
		builder.append(payeeBankAcctType);
		builder.append(", payeeBankName=");
		builder.append(payeeBankName);
		builder.append(", merchantFeeAmount=");
		builder.append(merchantFeeAmount);
		builder.append(", loanBenefit=");
		builder.append(loanBenefit);
		builder.append(", orgBenefit=");
		builder.append(orgBenefit);
		builder.append("]");
		return builder.toString();
	}
	
}