package com.wy.npo.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.dao.SysPermissionsMapper;
import com.wy.npo.entity.SysPermissions;
import com.wy.npo.service.ISysPermissionsService;

/**
 * 功能权限实现类
 * @author wangy
 */
@Service("sysPermissionsService")
@Transactional
public class SysPermissionsServiceImpl extends BaseServiceImpl<SysPermissions> implements ISysPermissionsService {

	final static Logger logger = LoggerFactory.getLogger(SysPermissionsServiceImpl.class);
	
	@Autowired
	private SysPermissionsMapper sysPermissionsMapper;
	
	@Override
	public Set<String> queryPermissionsByAccount(String account) {
		return sysPermissionsMapper.queryPermissionsByAccount(account);
	}

}
