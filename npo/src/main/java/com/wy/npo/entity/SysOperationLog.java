package com.wy.npo.entity;

import java.util.Date;

public class SysOperationLog extends BaseEntityVO{

	private static final long serialVersionUID = -541370244034447978L;

	private Integer id;

    private String operationName;

    private String operationType;

    private Integer operator;

    private Date operationTime;

    private String requestParams;
    
    private String operatorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Override
	public String toString() {
		return "SysOperationLog [id=" + id + ", operationName=" + operationName + ", operationType=" + operationType
				+ ", operator=" + operator + ", operationTime=" + operationTime + ", requestParams=" + requestParams
				+ ", operatorName=" + operatorName + "]";
	}
    
    
}