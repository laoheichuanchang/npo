package com.wy.npo.entity;

import java.util.Date;
import java.util.List;

import com.wy.npo.utils.annotation.FieldComment;

public class SysResource extends BaseEntityVO{

	private static final long serialVersionUID = -3741560615036116343L;

	private Integer id;

	@FieldComment(value = "资源名称")
    private String name;

	@FieldComment(value = "上级资源ID")
    private Integer pid;

	@FieldComment(value = "资源访问地址")
    private String url;

	@FieldComment(value = "请求方法")
    private String method;

	@FieldComment(value = "排序")
    private Integer orderNum;

	@FieldComment(value = "资源状态")
    private Byte status;

	@FieldComment(value = "资源描述")
    private String rmk;

    private Date updateTime;

    private Date createTime;

    private Integer updatorId;

    private Integer creatorId;
    
    private Integer countChildrens;
    
    private List<SysResource> children;
    
    private List<SysPermissions> sysPermissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

	public Integer getCountChildrens() {
		return countChildrens;
	}

	public void setCountChildrens(Integer countChildrens) {
		this.countChildrens = countChildrens;
	}

	public List<SysResource> getChildren() {
		return children;
	}

	public void setChildren(List<SysResource> children) {
		this.children = children;
	}

	public List<SysPermissions> getSysPermissions() {
		return sysPermissions;
	}

	public void setSysPermissions(List<SysPermissions> sysPermissions) {
		this.sysPermissions = sysPermissions;
	}

	@Override
	public String toString() {
		return "SysResource [id=" + id + ", name=" + name + ", pid=" + pid + ", url=" + url + ", method=" + method
				+ ", orderNum=" + orderNum + ", status=" + status + ", rmk=" + rmk + ", updateTime=" + updateTime
				+ ", createTime=" + createTime + ", updatorId=" + updatorId + ", creatorId=" + creatorId
				+ ", countChildrens=" + countChildrens + ", children=" + children + ", sysPermissions=" + sysPermissions
				+ "]";
	}
	
	
}