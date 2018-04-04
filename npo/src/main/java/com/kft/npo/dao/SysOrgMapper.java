package com.kft.npo.dao;

import java.util.List;

import com.kft.npo.entity.SysOrg;
import com.kft.npo.utils.PageHelper;

public interface SysOrgMapper extends BaseMapper<SysOrg>{
    
    List<SysOrg> getAll(PageHelper page);
}