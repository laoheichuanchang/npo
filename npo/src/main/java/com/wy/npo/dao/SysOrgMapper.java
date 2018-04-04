package com.wy.npo.dao;

import java.util.List;

import com.wy.npo.entity.SysOrg;
import com.wy.npo.utils.PageHelper;

public interface SysOrgMapper extends BaseMapper<SysOrg>{
    
    List<SysOrg> getAll(PageHelper page);
}