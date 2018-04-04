package com.wy.npo.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.constants.enums.OrgStatusEnums;
import com.wy.npo.dao.SysOrgMapper;
import com.wy.npo.entity.SysOrg;
import com.wy.npo.entity.SysUser;
import com.wy.npo.service.ISysOrgService;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.TableCodeUtils;

/**
 * 组织机构管理
 * @author wangy
 */
@Service("sysOrgService")
@Transactional
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrg> implements ISysOrgService {
	
	
	final static Logger logger = LoggerFactory.getLogger(SysOrgServiceImpl.class);

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	
	@Override
	public List<SysOrg> getAll(PageHelper page) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getRows());
		return sysOrgMapper.getAll(page);
	}

	
	@Override
	public void addOrg(SysOrg sysOrg, Integer pid) {
		//获取当前登录用户
	    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    sysOrg.setCreatorId(user.getId());
	    sysOrg.setUpdatorId(user.getId());
	    sysOrg.setStatus((byte)OrgStatusEnums.VALID.getCode().intValue());
	    sysOrg.setPid(pid);
	    int result =  sysOrgMapper.insertSelective(sysOrg);
	    //更新订单号
	  	String code = TableCodeUtils.getCode(sysOrg.getId());
	  	sysOrg.setCode(code);
	    sysOrgMapper.updateByPrimaryKeySelective(sysOrg);
	}


	@Override
	public void updateOrg(SysOrg sysOrg) {
		//获取当前登录用户
	    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    sysOrg.setUpdatorId(user.getId());
	    sysOrg.setUpdateTime(new Date());
	    sysOrgMapper.updateByPrimaryKeySelective(sysOrg);
	}


	@Override
	public void deleteOrg(Integer id) throws RuntimeException{
		//获取当前登录用户
	    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    SysOrg sysOrg = sysOrgMapper.selectByPrimaryKey(id);
	    if(null == sysOrg){
	    	throw new RuntimeException("删除的记录不存在");
	    }
	    sysOrg.setUpdatorId(user.getId());
	    sysOrg.setUpdateTime(new Date());
	    sysOrg.setStatus((byte)OrgStatusEnums.INVALID.getCode().intValue());
	    sysOrgMapper.updateByPrimaryKeySelective(sysOrg);
	}

}
