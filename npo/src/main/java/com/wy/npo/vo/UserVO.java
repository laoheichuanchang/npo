package com.wy.npo.vo;

import java.util.Date;

import com.wy.npo.entity.BaseEntityVO;
import com.wy.npo.utils.annotation.FieldComment;

/**
 * 用户请求类(这里为了偷懒和数据库POJO类继承同一个基类，实际项目中，建议单独给form表单的实体写一个基类)
 * @author wangy
 */
public class UserVO extends BaseEntityVO{
	
	private Integer id;
	
	@FieldComment(value = "用户账号")
	private String account;
	
	private String password;
	
	@FieldComment(value = "用户名称")
	private String name;
	
	@FieldComment(value = "手机号码")
	private String mobile;
	
	@FieldComment(value = "联系电话")
	private String tel;
	
	@FieldComment(value = "邮箱")
	private String email;
	
	@FieldComment(value = "入职时间")
	private Date regTime;
	
	@FieldComment(value = "角色ID")
	private String roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", mobile="
				+ mobile + ", tel=" + tel + ", email=" + email + ", regTime=" + regTime + ", roleId=" + roleId + "]";
	}
}
