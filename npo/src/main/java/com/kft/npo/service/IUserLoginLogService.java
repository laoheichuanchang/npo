package com.kft.npo.service;

import java.util.List;

import com.kft.npo.entity.SysUserLoginLog;
import com.kft.npo.utils.PageHelper;

public interface IUserLoginLogService {

	/**
	 * 新增登录日志
	 * @param userId
	 * @param loginIp
	 */
	public void insert(Integer userId,String loginIp);
	
	/**
	 * 查询列表
	 * @param page
	 * @param sysUserLoginLog
	 * @return
	 */
	public List<SysUserLoginLog> selectListByBean(PageHelper page,SysUserLoginLog sysUserLoginLog);
	
	/**
	 * 查询列表数量
	 * @param sysUserLoginLog
	 * @return
	 */
	public Long selectCountByBean(SysUserLoginLog sysUserLoginLog);
	
	/**
	 * 查询列表
	 * @param sysUserLoginLog
	 * @return
	 */
	public List<SysUserLoginLog> selectListByBean(SysUserLoginLog sysUserLoginLog);
}
