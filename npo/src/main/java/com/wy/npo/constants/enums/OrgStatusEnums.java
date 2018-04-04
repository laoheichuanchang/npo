package com.wy.npo.constants.enums;

public enum OrgStatusEnums {
    VALID(1,"有效"),INVALID(2,"无效");
	
	private Integer code;
	
	private String desc;
	
	private OrgStatusEnums(Integer code,String desc){
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
