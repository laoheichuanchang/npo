package com.wy.npo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.npo.dao.SysUserLoginLogMapper;
import com.wy.npo.entity.SysUserLoginLog;
import com.wy.npo.service.IUserLoginLogService;
import com.wy.npo.utils.PageHelper;

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
