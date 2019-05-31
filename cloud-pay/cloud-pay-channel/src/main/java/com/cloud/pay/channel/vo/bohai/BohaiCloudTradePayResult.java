package com.cloud.pay.channel.vo.bohai;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cloud.pay.common.contants.ChannelContants;

/**
 * 渤海单笔实时代付响应结果
 * @author wangy
 */
@XmlRootElement(name = ChannelContants.CHANNEL_BOHAI_RES_HEADER_SCS)
@XmlAccessorType(XmlAccessType.FIELD)
public class BohaiCloudTradePayResult extends BohaiCloudTradeErrorResult {

	private static final long serialVersionUID = 5026232140980716389L;
   
	@XmlElement
	private String actDat;//银行会计日期
	
	public BohaiCloudTradePayResult() {
		
	}
	
	public BohaiCloudTradePayResult(String rspCode) {
		this.rspCode = rspCode;
	}
	
	public BohaiCloudTradePayResult(String rspCode,String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}
  
	public BohaiCloudTradePayResult(String rspCode,String errorCode,String errorMessage) {
		this.rspCode = rspCode;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getActDat() {
		return actDat;
	}

	public void setActDat(String actDat) {
		this.actDat = actDat;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	
	
}
