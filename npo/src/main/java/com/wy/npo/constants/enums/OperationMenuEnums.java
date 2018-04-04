package com.wy.npo.constants.enums;

public enum OperationMenuEnums {
    
	OPERATION_ORG(1,"组织机构");
	
    private Integer code;
    
    private String desc;
    
    private OperationMenuEnums(Integer code,String desc){
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
