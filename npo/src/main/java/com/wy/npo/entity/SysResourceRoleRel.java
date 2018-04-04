package com.wy.npo.entity;

import java.util.Date;

public class SysResourceRoleRel {
    private Integer sourceId;

    private Integer roleId;

    private Integer creatorId;

    private Date createTime;

    private Integer updatorId;

    private Date updateTime;

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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

    public Integer getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Integer updatorId) {
        this.updatorId = updatorId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "SysResourceRoleRel [sourceId=" + sourceId + ", roleId=" + roleId + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", updatorId=" + updatorId + ", updateTime=" + updateTime + "]";
	}
    
	@Override
	public int hashCode() {
		return super.hashCode();
	}
    
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SysResourceRoleRel){
			SysResourceRoleRel bean = (SysResourceRoleRel)obj;
			return this.roleId.intValue() == bean.roleId.intValue() 
					&& this.sourceId.intValue() == bean.sourceId.intValue();
		}
		return super.equals(obj);
	}
}