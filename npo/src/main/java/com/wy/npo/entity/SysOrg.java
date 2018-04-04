package com.wy.npo.entity;

import java.util.Date;
import java.util.List;

import com.wy.npo.utils.annotation.FieldComment;

public class SysOrg extends BaseEntityVO{

	private static final long serialVersionUID = -6678056136282260049L;

	private Integer id;
    
	@FieldComment(value = "机构编码")
    private String code;
   
    @FieldComment(value = "机构名称")
    private String name;
    
    @FieldComment(value = "机构状态")
    private Byte status;

    @FieldComment(value = "描述信息")
    private String rmk;

    @FieldComment(value = "所属机构")
    private Integer pid;

    private Integer creatorId;

    private Date createTime;

    private Integer updatorId;

    private Date updateTime;
    
    private Integer countChildrens;
    
    private List<SysOrg> children;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

	public Integer getCountChildrens() {
		return countChildrens;
	}

	public void setCountChildrens(Integer countChildrens) {
		this.countChildrens = countChildrens;
	}

	public List<SysOrg> getChildren() {
		return children;
	}

	public void setChildren(List<SysOrg> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SysOrg [id=" + id + ", code=" + code + ", name=" + name + ", status=" + status + ", rmk=" + rmk
				+ ", pid=" + pid + ", creatorId=" + creatorId + ", createTime=" + createTime + ", updatorId="
				+ updatorId + ", updateTime=" + updateTime + ", countChildrens=" + countChildrens + ", children="
				+ children + "]";
	}
    
}