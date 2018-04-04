package com.kft.npo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kft.npo.dao.BaseMapper;
import com.kft.npo.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T> {
    
	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	public T selectByPrimaryKey(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}

}
