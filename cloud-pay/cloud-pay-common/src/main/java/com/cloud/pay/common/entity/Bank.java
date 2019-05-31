package com.cloud.pay.common.entity;

import java.util.Date;

public class Bank {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bank.id
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bank.bank_code
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    private String bankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bank.bank_name
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bank.modifer
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    private String modifer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_bank.modify_time
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bank.id
     *
     * @return the value of t_bank.id
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bank.id
     *
     * @param id the value for t_bank.id
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bank.bank_code
     *
     * @return the value of t_bank.bank_code
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bank.bank_code
     *
     * @param bankCode the value for t_bank.bank_code
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bank.bank_name
     *
     * @return the value of t_bank.bank_name
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bank.bank_name
     *
     * @param bankName the value for t_bank.bank_name
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bank.modifer
     *
     * @return the value of t_bank.modifer
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public String getModifer() {
        return modifer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bank.modifer
     *
     * @param modifer the value for t_bank.modifer
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public void setModifer(String modifer) {
        this.modifer = modifer == null ? null : modifer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_bank.modify_time
     *
     * @return the value of t_bank.modify_time
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_bank.modify_time
     *
     * @param modifyTime the value for t_bank.modify_time
     *
     * @mbggenerated Sun Aug 26 21:07:44 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bank [id=");
		builder.append(id);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", modifer=");
		builder.append(modifer);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append("]");
		return builder.toString();
	}
    
    
}