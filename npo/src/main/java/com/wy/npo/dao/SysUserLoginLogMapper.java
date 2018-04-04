package com.wy.npo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wy.npo.entity.SysUserLoginLog;
import com.wy.npo.utils.PageHelper;

public interface SysUserLoginLogMapper extends BaseMapper<SysUserLoginLog>{
	
	/**
	 * 查询列表
	 * @param page
	 * @param record
	 * @return
	 */
	List<SysUserLoginLog> selectListByBean(@Param("page")PageHelper page,@Param("record") SysUserLoginLog record);
	
	/**
	 * 查询列表数量
	 * @param sysUserLoginLog
	 * @return
	 */
	Long selectCountByBean(SysUserLoginLog sysUserLoginLog);
	
	/**
	 * 查询列表
	 * @param sysUserLoginLog
	 * @return
	 */
	List<SysUserLoginLog> selectList(SysUserLoginLog sysUserLoginLog);
}