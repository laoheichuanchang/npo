package com.wy.npo.entity;

public class SysRolePermRel {
    private Integer roleId;

    private Integer permId;

    private Integer resId;

    private Integer recordId;

    private Integer status;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "SysRolePermRel [roleId=" + roleId + ", permId=" + permId + ", resId=" + resId + ", recordId=" + recordId
				+ ", status=" + status + "]";
	}
    
    
}