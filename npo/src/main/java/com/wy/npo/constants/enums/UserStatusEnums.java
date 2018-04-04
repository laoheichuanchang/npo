package com.wy.npo.constants.enums;

public enum UserStatusEnums implements CustomEnum{
    VALID(1,"有效"),INVALID(2,"无效");
	
    private Integer code;
	
	private String desc;
	
	private UserStatusEnums(Integer code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public static String getDesc(Integer code){
		for(UserStatusEnums enums:values()){
			if(enums.getCode().intValue() == code.intValue()){
				return enums.getDesc();
			}
		}
		return null;
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

	@Override
	public String value(String value) {
		for(UserStatusEnums enums:values()){
			if(enums.getCode().intValue() == Integer.valueOf(value).intValue()){
				return enums.getDesc();
			}
		}
		return null;
	}
	
	
}
