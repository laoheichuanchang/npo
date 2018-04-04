package com.wy.npo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wy.npo.entity.SysUser;
import com.wy.npo.utils.PageHelper;

public interface SysUserMapper extends BaseMapper<SysUser>{

    /**
     * 根据提示查询用户信息
     * @param record
     * @return
     */
    List<SysUser> selectByBean(SysUser record);
    
    /**
     * 根据组织结构ID查询下属所有的用户信息(返回数量)
     * @param sysid
     * @return
     */
	Long getDatagridTotal(Integer sysid);
    
	/**
	 * 根据组织结构ID查询下属所有的用户信息
	 * @param page
	 * @param sysid
	 * @return
	 */
	List<SysUser> datagridUser(@Param("page")PageHelper page,@Param("csysid")Integer sysid);
	
	/**
	 * 查询列表数量
	 * @param sysUser
	 * @return
	 */
	Long queryCountByBean(SysUser sysUser);
	
	/**
	 * 查询列表
	 * @param page
	 * @param sysUser
	 * @return
	 */
	List<SysUser> queryListByBean(@Param("page")PageHelper page,@Param("user")SysUser sysUser);
	
	/**
	 * 根据主键查询用户信息
	 * @param id
	 * @return
	 */
	SysUser selectBeanByKey(Integer id);
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int updateDeleteByKey(Integer id);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param password
	 * @param updatorId
	 */
    void updatePassword(@Param("userId")int userId,@Param("password")String password,
    		@Param("updatorId")Integer updatorId);
}