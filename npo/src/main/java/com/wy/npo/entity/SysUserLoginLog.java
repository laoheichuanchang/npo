package com.wy.npo.entity;

import java.util.Date;

import com.wy.npo.utils.annotation.ExcelAttribute;

public class SysUserLoginLog extends BaseEntityVO{
 
	private static final long serialVersionUID = 8737190544299621288L;

	private Integer id;

    private Integer userId;
    
    @ExcelAttribute(name="登录IP",column="C")
    private String loginIp;

    @ExcelAttribute(name="登录时间",column="D")
    private Date loginTime;

    private String loginUa;
    
    @ExcelAttribute(name="用户名称",column="B")
    private String userName;
    
    @ExcelAttribute(name="用户账号",column="A",width=5530)
    private String account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginUa() {
        return loginUa;
    }

    public void setLoginUa(String loginUa) {
        this.loginUa = loginUa == null ? null : loginUa.trim();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "SysUserLoginLog [id=" + id + ", userId=" + userId + ", loginIp=" + loginIp + ", loginTime=" + loginTime
				+ ", loginUa=" + loginUa + ", userName=" + userName + ", account=" + account + "]";
	}
    
    
}