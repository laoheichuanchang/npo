package com.wy.npo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wy.npo.entity.SysOperationLog;
import com.wy.npo.utils.PageHelper;

public interface SysOperationLogMapper extends BaseMapper<SysOperationLog>{
	  
	/**
	 * 查询操作日志列表
	 * @param page
	 * @param record
	 * @return
	 */
	List<SysOperationLog> selectByBean(@Param("page")PageHelper page,@Param("record") SysOperationLog record);
	
	/**
	 * 操作日志列表数量
	 * @param record
	 * @return
	 */
	Long selectCountByBean(SysOperationLog record);
}