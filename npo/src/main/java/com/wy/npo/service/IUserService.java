package com.wy.npo.service;

import java.util.List;

import com.wy.npo.entity.SysUser;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.vo.UserVO;

/**
 * 用户管理
 * @author wangy
 *
 */
public interface IUserService  extends IBaseService<SysUser>{
   
	SysUser getUserById(Integer id);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	SysUser doLogin(SysUser user);
	
	/**
	 * 根据组织结构ID查询下面的所有用户信息
	 * @param sysid
	 * @return
	 */
	Long getDatagridTotal(Integer sysid);
	
	/**
	 * 根据组织结构ID查询下面的所有的用户信息
	 * @param page
	 * @param sysid
	 * @return
	 */
	List<SysUser> datagridUser(PageHelper page,Integer sysid);
	
	/**
	 * 用户列表
	 * @param page
	 * @param sysUser
	 * @return
	 */
	List<SysUser> queryListByBean(PageHelper page,SysUser sysUser);
	
	/**
	 * 用户列表数量
	 * @param sysUser
	 * @return
	 */
	Long queryCountByBean(SysUser sysUser);
	
	/**
	 * 编辑用户信息
	 * @param vo
	 */
	void edit(UserVO vo);
	
	/**
	 * 根据ID主键查询用户数据
	 * @param id
	 * @return
	 */
	SysUser selectBeamByKey(Integer id);
	
	/**
     * 根据主键删除数据（非物理删除）
     * @param id
     */
     void deleteByPrimaryKey(Integer id);
     
     /**
      * 修改密码
      * @param userId
      * @param password
      * @param salt
      * @param updatorId
      */
     public void updatePassword(int userId,String password,int updatorId);
     
     /**
      * 重置密码
      * @param userId
      */
     public void resetPassword(int userId);
}
