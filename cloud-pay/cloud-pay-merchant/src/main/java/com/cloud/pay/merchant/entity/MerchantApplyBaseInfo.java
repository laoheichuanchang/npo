package com.cloud.pay.merchant.entity;

import java.util.Date;

public class MerchantApplyBaseInfo {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.version
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Integer version;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.org_id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Integer orgId;

	private String code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.short_name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String shortName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.type
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Integer type;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.industry_category
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String industryCategory;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.legal
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String legal;

	private Integer provincial;
	
	private Integer city;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.address
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String address;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.email
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String email;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.mobile
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String mobile;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.status
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Integer status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.creator
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String creator;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.create_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Date createTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.modifer
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private String modifer;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column t_merchant_apply_base_info.modify_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	private Date modifyTime;
	
	private String businessLicence;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.id
	 *
	 * @return the value of t_merchant_apply_base_info.id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.id
	 *
	 * @param id
	 *            the value for t_merchant_apply_base_info.id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.version
	 *
	 * @return the value of t_merchant_apply_base_info.version
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.version
	 *
	 * @param version
	 *            the value for t_merchant_apply_base_info.version
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.org_id
	 *
	 * @return the value of t_merchant_apply_base_info.org_id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.org_id
	 *
	 * @param orgId
	 *            the value for t_merchant_apply_base_info.org_id
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.name
	 *
	 * @return the value of t_merchant_apply_base_info.name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.name
	 *
	 * @param name
	 *            the value for t_merchant_apply_base_info.name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.short_name
	 *
	 * @return the value of t_merchant_apply_base_info.short_name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.short_name
	 *
	 * @param shortName
	 *            the value for t_merchant_apply_base_info.short_name
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName == null ? null : shortName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.type
	 *
	 * @return the value of t_merchant_apply_base_info.type
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.type
	 *
	 * @param type
	 *            the value for t_merchant_apply_base_info.type
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.industry_category
	 *
	 * @return the value of t_merchant_apply_base_info.industry_category
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getIndustryCategory() {
		return industryCategory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.industry_category
	 *
	 * @param industryCategory
	 *            the value for t_merchant_apply_base_info.industry_category
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory == null ? null : industryCategory.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.legal
	 *
	 * @return the value of t_merchant_apply_base_info.legal
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getLegal() {
		return legal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.legal
	 *
	 * @param legal
	 *            the value for t_merchant_apply_base_info.legal
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setLegal(String legal) {
		this.legal = legal == null ? null : legal.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.city
	 *
	 * @return the value of t_merchant_apply_base_info.city
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getCity() {
		return city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.city
	 *
	 * @param city
	 *            the value for t_merchant_apply_base_info.city
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	
	

	public Integer getProvincial() {
		return provincial;
	}

	public void setProvincial(Integer provincial) {
		this.provincial = provincial;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.address
	 *
	 * @return the value of t_merchant_apply_base_info.address
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.address
	 *
	 * @param address
	 *            the value for t_merchant_apply_base_info.address
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.email
	 *
	 * @return the value of t_merchant_apply_base_info.email
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.email
	 *
	 * @param email
	 *            the value for t_merchant_apply_base_info.email
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.mobile
	 *
	 * @return the value of t_merchant_apply_base_info.mobile
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.mobile
	 *
	 * @param mobile
	 *            the value for t_merchant_apply_base_info.mobile
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.status
	 *
	 * @return the value of t_merchant_apply_base_info.status
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.status
	 *
	 * @param status
	 *            the value for t_merchant_apply_base_info.status
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.creator
	 *
	 * @return the value of t_merchant_apply_base_info.creator
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.creator
	 *
	 * @param creator
	 *            the value for t_merchant_apply_base_info.creator
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setCreator(String creator) {
		this.creator = creator == null ? null : creator.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.create_time
	 *
	 * @return the value of t_merchant_apply_base_info.create_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.create_time
	 *
	 * @param createTime
	 *            the value for t_merchant_apply_base_info.create_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.modifer
	 *
	 * @return the value of t_merchant_apply_base_info.modifer
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public String getModifer() {
		return modifer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.modifer
	 *
	 * @param modifer
	 *            the value for t_merchant_apply_base_info.modifer
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setModifer(String modifer) {
		this.modifer = modifer == null ? null : modifer.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column t_merchant_apply_base_info.modify_time
	 *
	 * @return the value of t_merchant_apply_base_info.modify_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column t_merchant_apply_base_info.modify_time
	 *
	 * @param modifyTime
	 *            the value for t_merchant_apply_base_info.modify_time
	 *
	 * @mbggenerated Sun Sep 02 09:06:42 CST 2018
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String auditOptinion;

	public String getAuditOptinion() {
		return auditOptinion;
	}

	public void setAuditOptinion(String auditOptinion) {
		this.auditOptinion = auditOptinion;
	}
	
	public String getBusinessLicence() {
		return businessLicence;
	}

	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerchantApplyBaseInfo [id=");
		builder.append(id);
		builder.append(", version=");
		builder.append(version);
		builder.append(", orgId=");
		builder.append(orgId);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", shortName=");
		builder.append(shortName);
		builder.append(", type=");
		builder.append(type);
		builder.append(", industryCategory=");
		builder.append(industryCategory);
		builder.append(", legal=");
		builder.append(legal);
		builder.append(", provincial=");
		builder.append(provincial);
		builder.append(", city=");
		builder.append(city);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", modifer=");
		builder.append(modifer);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append(", businessLicence=");
		builder.append(businessLicence);
		builder.append(", auditOptinion=");
		builder.append(auditOptinion);
		builder.append("]");
		return builder.toString();
	}

}