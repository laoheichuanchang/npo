package com.cloud.pay.recon.mapper;

import com.cloud.pay.recon.entity.ReconChannelBohai;
import com.cloud.pay.recon.entity.ReconChannelBohaiExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReconChannelBohaiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int countByExample(ReconChannelBohaiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int deleteByExample(ReconChannelBohaiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int insert(ReconChannelBohai record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int insertSelective(ReconChannelBohai record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    List<ReconChannelBohai> selectByExample(ReconChannelBohaiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    ReconChannelBohai selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") ReconChannelBohai record, @Param("example") ReconChannelBohaiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int updateByExample(@Param("record") ReconChannelBohai record, @Param("example") ReconChannelBohaiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int updateByPrimaryKeySelective(ReconChannelBohai record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recon_channel_bohai
     *
     * @mbggenerated Sun Sep 02 12:55:14 CST 2018
     */
    int updateByPrimaryKey(ReconChannelBohai record);
    
    /**
     * 批量插入
     * @param list
     * @return
     */
    int batchInsert(List<ReconChannelBohai> list);
    
    /**
     * 删除所有数据
     * @return
     */
    int deleleAll();
    
    /**
     * 更新平帐记录（上游对账文件里面没有记账日期，所以这里暂时不考虑时间参数）
     * @return
     */
    int updateReconStatusFlat(String reconDate);
    
    /**
      * 更新短款记录为不平帐
     * @param reconDate
     * @return
     */
    int updateShortUnflat(String reconDate);
}