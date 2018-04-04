package com.wy.npo.entity;

import java.util.Date;

import com.wy.npo.constants.enums.RoleStatusEnums;
import com.wy.npo.utils.annotation.ExcelAttribute;
import com.wy.npo.utils.annotation.FieldComment;

public class SysRole extends BaseEntityVO{

	private static final long serialVersionUID = -2174810465983795928L;

	private Integer id;

	@ExcelAttribute(name="角色编码")
	@FieldComment(value = "角色编码")
    private String code;

	@ExcelAttribute(name="角色名称")
	@FieldComment(value = "角色名称")
    private String name;

	@ExcelAttribute(name="角色状态",fommat = RoleStatusEnums.class)
	@FieldComment(value = "角色状态")
    private Byte status;

	@ExcelAttribute(name="角色描述")
	@FieldComment(value = "角色描述")
    private String rmk;

    private Integer creatorId;

    @ExcelAttribute(name="创建时间")
    private Date createTime;

    private Integer updatorId;

    private Date updateTime;
    
    private String createName;
    
    private String updateName;
    
    private Integer orgId;
    
    private String orgName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
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

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", code=" + code + ", name=" + name + ", status=" + status + ", rmk=" + rmk
				+ ", creatorId=" + creatorId + ", createTime=" + createTime + ", updatorId=" + updatorId
				+ ", updateTime=" + updateTime + ", createName=" + createName + ", updateName=" + updateName + "]";
	}
	
	
}