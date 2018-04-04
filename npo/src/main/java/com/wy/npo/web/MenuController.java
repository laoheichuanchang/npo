package com.wy.npo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.npo.entity.SysResource;
import com.wy.npo.entity.SysUser;
import com.wy.npo.realm.ShiroDbRealm;
import com.wy.npo.service.ISysResourceService;
import com.wy.npo.utils.easyui.Tree;


/**
 * 菜单资源
 * @author Administrator
 */
@Controller
public class MenuController {
	
	   private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
    	@Autowired
    	private ISysResourceService resourceService;
   
	    @ResponseBody
	    @RequestMapping(value="/resource/getMenu", method = RequestMethod.POST)
	    public List<Tree> getMenu(HttpSession session){  
	    	SysUser	user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	    	logger.info("当前用户:"+user.getAccount()+",获取菜单资源");
	    	List<SysResource> menuList= resourceService.queryMenu(user.getAccount());
	    	List<Tree> treeList = new ArrayList<Tree>();

	        for (SysResource menu : menuList) {
				Tree node = new Tree();
				
				node.setId(menu.getId());
				node.setPid(menu.getPid());
				node.setText(menu.getName());
				if(menu.getPid()!=0){	// 有父节点
					node.setPid(menu.getPid());
				}
				if(menu.getCountChildrens() > 0){	//有子节点
					node.setState("closed");
				}
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", menu.getUrl());
				node.setAttributes(attr);
				treeList.add(node);
	        }
	    	return treeList;
	    }
	    
	    
	    @ResponseBody
	    @RequestMapping(value="/resource/menuList", method = RequestMethod.POST)	    
	    public List<SysResource> menuTreeList(Model model,@RequestParam Integer id){
	    	logger.info("加载所有的菜单资源信息和权限信息，是否传入roleId:{}",id);
	    	List<SysResource> menuList= resourceService.queryResourceRelPermByRoleId(id);
	    	List<SysResource> treeList = new ArrayList<SysResource>();
	    	for(SysResource resource : menuList){
	    		 if(resource.getPid() == 0){ //有父节点
	    	    	SysResource sysResource = recursionTree(menuList,resource);
	    	    	sysResource.setSysPermissions(null);
	    	    	treeList.add(sysResource);
	    		 }
	    	}
	    	return treeList;
	    }
	    
		 /**
		  * 递归构建响应的树形数据
		  * @param list
		  * @param currentNode
		  * @return
		  */
		 private SysResource recursionTree(List<SysResource> list,SysResource currentNode){
			    List<SysResource> childList = new ArrayList<SysResource>();
			    for(SysResource newNode:list){
			    	if((newNode.getPid() !=0) && (newNode.getPid().compareTo(currentNode.getId()) == 0)){
			    		SysResource sysResource = recursionTree(list,newNode);
			    		 childList.add(sysResource);
			    	}
			    }
			    if(childList.size() > 0){
			    	currentNode.setChildren(childList);
			    }
			    return currentNode;
		 }
}
