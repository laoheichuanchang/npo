package com.wy.npo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.dao.SysResourceMapper;
import com.wy.npo.entity.SysResource;
import com.wy.npo.service.ISysResourceService;

/**
 * 菜单资源管理
 * @author wangy
 */
@Service("sysResourceService")
@Transactional
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements ISysResourceService {
	

	final static Logger logger = LoggerFactory.getLogger(SysResourceServiceImpl.class);

	@Autowired
	private SysResourceMapper sysResourceMapper;
	
	/**
	 * 菜单资源管理
	 */
	@Override
	public List<SysResource> queryMenu(String account) {
		return sysResourceMapper.queryResourceByAccount(account);
	}

	@Override
	public List<SysResource> queryResourceRelPermByRoleId(Integer roleId) {
		return sysResourceMapper.queryResourceRelPermByRoleId(roleId);
	}
	
	
    
}
