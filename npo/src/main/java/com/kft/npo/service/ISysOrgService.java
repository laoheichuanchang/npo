package com.kft.npo.service;

import java.util.List;

import com.kft.npo.entity.SysOrg;
import com.kft.npo.utils.PageHelper;

/**
 * 组织机构管理
 * @author wangy
 */
public interface ISysOrgService  extends IBaseService<SysOrg>{

	/**
	 * 获取所有的组织结构信息
	 * @param page
	 * @return
	 */
	List<SysOrg> getAll(PageHelper page);
	
	/**
	 * 新增组织机构
	 * @param sysOrg
	 * @param pid
	 */
	void addOrg(SysOrg sysOrg,Integer pid);
	
	/**
	 * 编辑组织机构
	 * @param sysOrg
	 */
	void updateOrg(SysOrg sysOrg);
	
	/**
	 * 删除组织机构
	 * @param id
	 */
	void deleteOrg(Integer id);
}
