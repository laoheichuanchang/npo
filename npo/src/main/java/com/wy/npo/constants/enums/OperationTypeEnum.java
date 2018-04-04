package com.wy.npo.constants.enums;

public enum OperationTypeEnum {
      
	OPERATION_UPDATE(1,"修改/新增"),OPERATION_DELETE(2,"删除"),OPERATION_RESET_PWD(3,"重置密码"),OPERATION_UPDATE_PWD(4,"修改密码");
	
	private Integer code;
	
	private String desc;
	
	private OperationTypeEnum(Integer code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
