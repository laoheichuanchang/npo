package com.kft.npo.dao;

import java.util.List;

import com.kft.npo.entity.SysRolePermRel;

public interface SysRolePermRelMapper {
    int insert(SysRolePermRel record);

    int insertSelective(SysRolePermRel record);
    
    /**
     * 批量插入
     * @param record
     * @return
     */
    int batchInsertSelective(List<SysRolePermRel> record);
    
    /**
     * 删除
     * @param list
     * @return
     */
    int deleteByRoleId(Integer roleId);
}