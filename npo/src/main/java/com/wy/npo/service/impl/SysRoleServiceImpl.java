package com.wy.npo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.constants.enums.RoleStatusEnums;
import com.wy.npo.dao.SysOrgRoleRelMapper;
import com.wy.npo.dao.SysResourceMapper;
import com.wy.npo.dao.SysResourceRoleRelMapper;
import com.wy.npo.dao.SysRoleMapper;
import com.wy.npo.dao.SysRolePermRelMapper;
import com.wy.npo.entity.SysOrgRoleRel;
import com.wy.npo.entity.SysResourceRoleRel;
import com.wy.npo.entity.SysRole;
import com.wy.npo.entity.SysRolePermRel;
import com.wy.npo.entity.SysUser;
import com.wy.npo.realm.ShiroDbRealm;
import com.wy.npo.service.ISysRoleService;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.TableCodeUtils;
import com.wy.npo.vo.RoleVO;

@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {
	
	final static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRolePermRelMapper sysRolePermRelMapper;
	
	@Autowired
	private SysResourceRoleRelMapper sysResourceRoleRelMapper;
	
	@Autowired
	private SysOrgRoleRelMapper sysOrgRoleRelMapper;
	
	@Autowired
	private SysResourceMapper sysResourceMapper;

	@Override
	public List<SysRole> queryListByBean(SysRole role, PageHelper page) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysRoleMapper.queryListByBean(role, page);
	}

	@Override
	public Long queryCountByBean(SysRole role) {
		return sysRoleMapper.queryCountByBean(role);
	}
  
	
	@Override
	public void addRole(RoleVO vo){
		logger.info("编辑角色信息");
		//获取当前登录用户
	    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    SysRole sysRole = null;
	    if(null == vo.getId()){
	    	 //新增
	    	sysRole = new SysRole();
		    sysRole.setName(vo.getName());
		    sysRole.setRmk(vo.getRmk());
		    sysRole.setStatus((byte)RoleStatusEnums.VALID.getCode().intValue());
		    sysRole.setCreatorId(user.getId());
		    sysRole.setUpdatorId(user.getId());
		    logger.info("新增角色信息：{}",sysRole);
		    int result = sysRoleMapper.insertSelective(sysRole);
		    //更新订单号
		  	String code = TableCodeUtils.getCode(sysRole.getId());
		  	logger.info("设置新增角色编号：{}",code);
		  	sysRole.setCode(code);
		  	sysRoleMapper.updateByPrimaryKeySelective(sysRole);   
	    }else{
	    	//修改
	    	sysRole = sysRoleMapper.selectByPrimaryKey(vo.getId());
	    	sysRole.setName(vo.getName());
	    	sysRole.setRmk(vo.getRmk());
	    	sysRole.setUpdatorId(user.getId());
	    	sysRole.setUpdateTime(new Date());
	    	logger.info("修改角色信息：{}",sysRole);
	    	sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	    	//删除旧的功能和菜单权限关联信息
	    	sysRolePermRelMapper.deleteByRoleId(vo.getId());
	    	sysResourceRoleRelMapper.deleteByRoleId(vo.getId());
	    	sysOrgRoleRelMapper.deleteByRoleId(vo.getId());
	    }
	  	logger.info("更新角色所对应的权限信息");
	  	String[] permissions = vo.getPermissions().split(",");
	  	//功能权限关联列表
	  	List<SysRolePermRel> sysRolePermRels = new ArrayList<SysRolePermRel>();
	  	//菜单权限关联列表
	  	List<SysResourceRoleRel> sysResourceRoleRels = new ArrayList<SysResourceRoleRel>();
	  	List<Integer> childIdList = new ArrayList<Integer>();
	  	for(String permission:permissions){
	  		//构建功能权限
	  		SysRolePermRel sysRolePermRel = new SysRolePermRel();
	  		sysRolePermRel.setPermId(Integer.parseInt(permission.split("-")[0]));
	  		sysRolePermRel.setResId(Integer.parseInt(permission.split("-")[1]));
	  		sysRolePermRel.setRoleId(sysRole.getId());
	  		sysRolePermRel.setStatus(RoleStatusEnums.VALID.getCode());
	  		sysRolePermRels.add(sysRolePermRel);
	  		//构建菜单资源权限
	  		
	  		SysResourceRoleRel sysResourceRoleRel = new SysResourceRoleRel();
	  		sysResourceRoleRel.setRoleId(sysRole.getId());
	  		sysResourceRoleRel.setSourceId(Integer.parseInt(permission.split("-")[1]));
	  		sysResourceRoleRel.setCreatorId(user.getId());
	  		sysResourceRoleRel.setUpdatorId(user.getId());
	  		if(!sysResourceRoleRels.contains(sysResourceRoleRel)){
	  		   sysResourceRoleRels.add(sysResourceRoleRel);
	  		}
	  		if(!childIdList.contains(Integer.parseInt(permission.split("-")[1]))){
	  			childIdList.add(Integer.parseInt(permission.split("-")[1]));
	  		}
	  	}
	  	logger.info("角色：{},添加子菜单权限：{}",sysRole.getName(),sysResourceRoleRels);
	    //获取父菜单，并构建父菜单资源权限
	  	List<Integer> pidList = sysResourceMapper.queryPidListByChildId(childIdList);
	  	for(Integer pid:pidList){
	  		SysResourceRoleRel sysResourceRoleRel = new SysResourceRoleRel();
	  		sysResourceRoleRel.setRoleId(sysRole.getId());
	  		sysResourceRoleRel.setSourceId(pid);
	  		sysResourceRoleRel.setCreatorId(user.getId());
	  		sysResourceRoleRel.setUpdatorId(user.getId());
	  		if(!sysResourceRoleRels.contains(sysResourceRoleRel)){
		  		   sysResourceRoleRels.add(sysResourceRoleRel);
		  	}
	  	}
	  	logger.info("角色：{}，新增权限：{}",sysRole.getName(),sysRolePermRels);
	  	sysRolePermRelMapper.batchInsertSelective(sysRolePermRels);
	  	logger.info("角色：{},新增菜单权限：{}",sysRole.getName(),sysResourceRoleRels);
	  	sysResourceRoleRelMapper.batchInsertSelective(sysResourceRoleRels);
	  	SysOrgRoleRel sysorgRoleRel = new SysOrgRoleRel();
	  	sysorgRoleRel.setOrgId(vo.getOrgId());
	  	sysorgRoleRel.setRoleId(sysRole.getId());
	  	sysorgRoleRel.setCreatorId(user.getId());
        logger.info("角色：{}，新增组织关联信息：{}",sysRole.getName(),sysorgRoleRel);
        sysOrgRoleRelMapper.insertSelective(sysorgRoleRel);
        
        RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();    
        ShiroDbRealm realm = (ShiroDbRealm)rsm.getRealms().iterator().next();  
        realm.clearCachedAuthorization();  
	}
}
