package com.wy.npo.entity;

import com.wy.npo.utils.annotation.FieldComment;

public class SysPermissions extends BaseEntityVO{
	
	private static final long serialVersionUID = -6608946010814766324L;

	private Integer id;

	@FieldComment(value = "权限编码")
    private String code;

	@FieldComment(value = "权限名称")
    private String name;

	@FieldComment(value = "资源ID")
    private Integer resId;

	@FieldComment(value = "权限状态")
    private Integer status;

	@FieldComment(value = "权限描述")
    private String rmk;
    
    private boolean isChecked;

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

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "SysPermissions [id=" + id + ", code=" + code + ", name=" + name + ", resId=" + resId + ", status="
				+ status + ", rmk=" + rmk + ", isChecked=" + isChecked + "]";
	}
}