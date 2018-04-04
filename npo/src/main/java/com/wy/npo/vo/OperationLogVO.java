package com.wy.npo.vo;

/**
 * 操作日志
 * @author wangy
 */
public class OperationLogVO {
    
	/**
	 * 操作日志类型：新增、修改、删除、审核、驳回
	 */
	private Integer operationType;
	
	/**
	 * 操作日志名称：用户管理、机构管理等
	 */
	private String operationName;
	

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	@Override
	public String toString() {
		return "OperationLogVO [operationType=" + operationType + ", operationName=" + operationName + "]";
	}
}
