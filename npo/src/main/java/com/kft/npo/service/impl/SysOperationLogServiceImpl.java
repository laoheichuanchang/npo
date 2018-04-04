package com.kft.npo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kft.npo.dao.SysOperationLogMapper;
import com.kft.npo.entity.SysOperationLog;
import com.kft.npo.service.ISysOperationLogService;
import com.kft.npo.utils.PageHelper;

@Service("sysOperationLogService")
public class SysOperationLogServiceImpl implements ISysOperationLogService{
	
	@Autowired
	private SysOperationLogMapper sysOperationLogMapper;

	@Override
	public List<SysOperationLog> queryListByBean(PageHelper page, SysOperationLog record) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysOperationLogMapper.selectByBean(page, record);
	}

	@Override
	public Long queryCountByBean(SysOperationLog record) {
		
		return sysOperationLogMapper.selectCountByBean(record);
	}

}
