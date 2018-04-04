package com.wy.npo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.constants.enums.UserStatusEnums;
import com.wy.npo.dao.SysUserMapper;
import com.wy.npo.dao.SysUserRoleRelMapper;
import com.wy.npo.entity.SysUser;
import com.wy.npo.entity.SysUserRoleRel;
import com.wy.npo.service.IUserService;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.TableCodeUtils;
import com.wy.npo.utils.Utils;
import com.wy.npo.vo.UserVO;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<SysUser> implements IUserService {
	
	final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserRoleRelMapper sysUserRoleRelMapper;
	
	@Value("${wy.user.default.password}")  
	protected String userDefaultPassword;
	
	@Override
	public SysUser getUserById(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public SysUser doLogin(SysUser user) {
		List<SysUser> list = sysUserMapper.selectByBean(user);
		if(null == list || list.size() <= 0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public Long getDatagridTotal(Integer sysid) {
		
		return sysUserMapper.getDatagridTotal(sysid);
	}

	@Override
	public List<SysUser> datagridUser(PageHelper page, Integer sysid) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysUserMapper.datagridUser(page, sysid);
	}

	@Override
	public List<SysUser> queryListByBean(PageHelper page, SysUser sysUser) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysUserMapper.queryListByBean(page, sysUser);
	}

	@Override
	public Long queryCountByBean(SysUser sysUser) {
		
		return sysUserMapper.queryCountByBean(sysUser);
	}

	@Override
	public void edit(UserVO vo) throws RuntimeException{
		//获取当前登录用户
	    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    SysUser sysUser = null;
	    if(null == vo.getId()){
	    	logger.info("新增用户数据：{}",vo);
	    	//检查账户是否重复
	    	
	    	sysUser = new SysUser();
	    	sysUser.setAccount(vo.getAccount());
	    	List<SysUser> list = sysUserMapper.selectByBean(sysUser);
			if(null != list && list.size() > 0){
				logger.info("新增用户数据失败，用户账户：{}已经存在",vo.getAccount());
				throw new RuntimeException("用户账户："+vo.getAccount()+"已经存在");
			}
	    	sysUser.setCreatorId(user.getId());
	    	sysUser.setPassword(Utils.getEncodePwd(vo.getPassword()));
	    	sysUser.setName(vo.getName());
	    	sysUser.setMobile(vo.getMobile());
	    	sysUser.setTel(vo.getTel());
	    	sysUser.setEmail(vo.getEmail());
	    	sysUser.setRegTime(vo.getRegTime());
	    	sysUser.setUpdatorId(user.getId());
	    	sysUser.setStatus(UserStatusEnums.VALID.getCode());
	    	int result =sysUserMapper.insertSelective(sysUser);
	    	//更新订单号
		  	String code = TableCodeUtils.getCode(sysUser.getId());
		  	logger.info("设置新增用户编号：{}",code);
		  	sysUser.setCode(code);
		  	sysUserMapper.updateByPrimaryKeySelective(sysUser);
	    }else{
	    	logger.info("修改用户数据：{}",vo);
	    	sysUser = sysUserMapper.selectByPrimaryKey(vo.getId());
	    	sysUser.setUpdateTime(new Date());
	    	sysUser.setAccount(vo.getAccount());
	    	sysUser.setPassword(vo.getPassword());
	    	sysUser.setName(vo.getName());
	    	sysUser.setMobile(vo.getMobile());
	    	sysUser.setTel(vo.getTel());
	    	sysUser.setEmail(vo.getEmail());
	    	sysUser.setRegTime(vo.getRegTime());
	    	sysUser.setUpdatorId(user.getId());
	    	sysUserMapper.updateByPrimaryKeySelective(sysUser);
	    	//删除用户和角色的关联关系信息
	    	sysUserRoleRelMapper.deleteByUserId(vo.getId());
	    }
	    logger.info("用户：{},更新用户和角色的关联信息开始",sysUser.getAccount());
        String[] roleIds = vo.getRoleId().substring(0, vo.getRoleId().length() -1).split(",");
        List<SysUserRoleRel> sysUserRoleRels = new ArrayList<SysUserRoleRel>();
        for(String roleId:roleIds){
        	SysUserRoleRel sysUserRoleRel = new SysUserRoleRel();
        	sysUserRoleRel.setRoleId(Integer.parseInt(roleId));
        	sysUserRoleRel.setUserId(sysUser.getId());
        	sysUserRoleRel.setCreatorId(user.getId());
        	sysUserRoleRel.setCreateTime(new Date());
        	sysUserRoleRels.add(sysUserRoleRel);
        }
    	logger.info("用户：{},更新用户和角色的关联信息：{}",sysUser.getAccount(),sysUserRoleRels);
    	sysUserRoleRelMapper.batchInsertSelective(sysUserRoleRels);
	}

	@Override
	public SysUser selectBeamByKey(Integer id) {
		
		return sysUserMapper.selectBeanByKey(id);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		 sysUserMapper.updateDeleteByKey(id);
	}
   
	/**
	 * 修改密码
	 * @param userId
	 * @param password
	 * @param updatorId
	 */
	public void updatePassword(int userId,String password,int updatorId){
		String md5Pwd = Utils.getEncodePwd(password); //密码进行MD5加密
		sysUserMapper.updatePassword(userId, md5Pwd, updatorId);
	}
	
	/**
	 * 重置密码
	 * @param userId
	 */
	public void resetPassword(int userId){
		SysUser	loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		String md5Pwd = Utils.getEncodePwd(userDefaultPassword); //默认密码进行MD5加密
		sysUserMapper.updatePassword(userId, md5Pwd,  loginUser.getId());
	}
    
}
