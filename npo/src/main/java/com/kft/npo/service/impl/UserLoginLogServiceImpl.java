package com.kft.npo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kft.npo.dao.SysUserLoginLogMapper;
import com.kft.npo.entity.SysUserLoginLog;
import com.kft.npo.service.IUserLoginLogService;
import com.kft.npo.utils.PageHelper;

@Service("userLoginLogService")
public class UserLoginLogServiceImpl implements IUserLoginLogService {
   
	@Autowired
	private SysUserLoginLogMapper sysUserLoginLogMapper;
	
	@Override
	public void insert(Integer userId, String loginIp) {
		SysUserLoginLog record =  new SysUserLoginLog();
		record.setUserId(userId);
		record.setLoginIp(loginIp);
		sysUserLoginLogMapper.insertSelective(record);
	}

	@Override
	public List<SysUserLoginLog> selectListByBean(PageHelper page, SysUserLoginLog sysUserLoginLog) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysUserLoginLogMapper.selectListByBean(page, sysUserLoginLog);
	}

	@Override
	public Long selectCountByBean(SysUserLoginLog sysUserLoginLog) {
	
		return sysUserLoginLogMapper.selectCountByBean(sysUserLoginLog);
	}

	@Override
	public List<SysUserLoginLog> selectListByBean(SysUserLoginLog sysUserLoginLog) {
		return sysUserLoginLogMapper.selectList(sysUserLoginLog);
	}

}
