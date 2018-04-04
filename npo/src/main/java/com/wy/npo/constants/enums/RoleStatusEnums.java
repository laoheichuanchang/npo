package com.wy.npo.constants.enums;

/**
 * 角色状态枚举类
 * @author wangy
 */
public enum RoleStatusEnums implements CustomEnum{
   
    VALID(1,"有效"),INVALID(2,"无效");
	
	private Integer code;
	
	private String desc;
	
	private RoleStatusEnums(Integer code,String desc){
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

	@Override
	public String value(String value) {
		for(RoleStatusEnums enums:values()){
			if(enums.getCode().intValue() == Integer.valueOf(value).intValue()){
				return enums.getDesc();
			}
		}
		return null;
	}
}
