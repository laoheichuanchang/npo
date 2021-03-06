package com.cloud.pay.merchant.mapper;

import org.apache.ibatis.annotations.Param;

import com.cloud.pay.merchant.entity.MerchantBankInfo;

public interface MerchantBankInfoMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant_bank_info
     *
     * @mbggenerated Sun Sep 02 09:06:42 CST 2018
     */
    int insert(MerchantBankInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant_bank_info
     *
     * @mbggenerated Sun Sep 02 09:06:42 CST 2018
     */
    int insertSelective(MerchantBankInfo record);

    MerchantBankInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantBankInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant_bank_info
     *
     * @mbggenerated Sun Sep 02 09:06:42 CST 2018
     */
    int updateByPrimaryKey(MerchantBankInfo record);
    
    MerchantBankInfo selectByMerchantId(@Param("merchantId")Integer merchantId);
}
