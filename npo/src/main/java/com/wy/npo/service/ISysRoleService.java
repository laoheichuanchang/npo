package com.wy.npo.service;

import java.util.List;

import com.wy.npo.entity.SysRole;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.vo.RoleVO;

/**
 * 角色管理
 * @author wangy
 */
public interface ISysRoleService extends IBaseService<SysRole>{

	  /**
	   * 查询角色列表
	   * @param role
	   * @param page
	   * @return
	   */
	  List<SysRole> queryListByBean(SysRole role,PageHelper page);
	  
	  /**
	   * 查询角色列表数据
	   * @param role
	   * @return
	   */
	  Long queryCountByBean(SysRole role);
	  
	  /**
	   * 新增角色
	   * @param vo
	   */
	  void addRole(RoleVO vo);
}
