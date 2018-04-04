package com.wy.npo.vo;

import com.wy.npo.entity.BaseEntityVO;
import com.wy.npo.utils.annotation.FieldComment;

/**
 * 权限操作实体
 * @author wangy
 */
public class RoleVO extends BaseEntityVO {
	
	private Integer id;
    
	@FieldComment(value = "角色名称")
	private String name;
	
	@FieldComment(value = "角色描述")
	private String rmk;
	
	@FieldComment(value = "所属机构ID")
	private Integer orgId;
	
	@FieldComment(value = "关联权限")
	private String permissions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Override
	public String toString() {
		return "RoleVO [id=" + id + ", name=" + name + ", rmk=" + rmk + ", orgId=" + orgId + ", permissions="
				+ permissions + "]";
	}
	
}
