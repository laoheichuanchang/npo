package com.wy.npo.entity;

import java.util.Date;

public class SysUserRoleRel {
    private Integer userId;

    private Integer roleId;

    private Integer creatorId;

    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "SysUserRoleRel [userId=" + userId + ", roleId=" + roleId + ", creatorId=" + creatorId + ", createTime="
				+ createTime + "]";
	}
    
}
