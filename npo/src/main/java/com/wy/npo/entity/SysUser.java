package com.wy.npo.entity;

import java.util.Date;
import java.util.List;

import com.wy.npo.constants.enums.UserStatusEnums;
import com.wy.npo.utils.annotation.ExcelAttribute;
import com.wy.npo.utils.annotation.FieldComment;

public class SysUser extends BaseEntityVO{

	private static final long serialVersionUID = 5657712831399379474L;

	private Integer id;

	@ExcelAttribute(name="用户编码",width = 4230, column="B")
	@FieldComment(value = "用户编码")
    private String code;

	@ExcelAttribute(name="用户账户",isMark = true, column="A")
	@FieldComment(value = "用户账户")
    private String account;

	@ExcelAttribute(name="用户名称")
	@FieldComment(value = "用户名称")
    private String name;

	@ExcelAttribute(name="手机号码")
	@FieldComment(value = "手机号码")
    private String mobile;

	@ExcelAttribute(name="联系电话")
	@FieldComment(value = "联系电话")
    private String tel;

	@FieldComment(value = "用户类型")
    private String type;

	@ExcelAttribute(name="邮箱" ,width = 5230)
	@FieldComment(value = "邮箱")
    private String email;

	
    private String password;

    @ExcelAttribute(name="用户状态",fommat = UserStatusEnums.class)
    private Integer status;

    @ExcelAttribute(name="用户描述")
	@FieldComment(value = "用户描述")
    private String rmk;
    
    @ExcelAttribute(name="注册时间")
    private Date regTime;

    private Date updateTime;

    private Integer updatorId;

    private Integer creatorId;

    private Integer isDelete;

    private Date createTime;
    
    private String sysName;
    
    private String pSysName;
    
    private String createName;
    
    private String roleIds;
    
    private String roleNames;
    
    private String rememberMe;
    
    private List<SysRole> sysRoles;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getPSysName() {
		return pSysName;
	}

	public void setPSysName(String pSysName) {
		this.pSysName = pSysName;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public List<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public boolean isRememberMe() {
		return "Y".equals(rememberMe)?true:false;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", code=" + code + ", account=" + account + ", name=" + name + ", mobile=" + mobile
				+ ", tel=" + tel + ", type=" + type + ", email=" + email + ", password=" + password + ", status="
				+ status + ", rmk=" + rmk + ", regTime=" + regTime + ", updateTime=" + updateTime + ", updatorId="
				+ updatorId + ", creatorId=" + creatorId + ", isDelete=" + isDelete + ", createTime=" + createTime
				+ ", sysName=" + sysName + ", pSysName=" + pSysName + ", createName=" + createName + "]";
	}

	
}