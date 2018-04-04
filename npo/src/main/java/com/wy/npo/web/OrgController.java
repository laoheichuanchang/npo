package com.wy.npo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wy.npo.constants.enums.OperationTypeEnum;
import com.wy.npo.entity.SysOrg;
import com.wy.npo.entity.SysUser;
import com.wy.npo.realm.ShiroDbRealm;
import com.wy.npo.service.ISysOrgService;
import com.wy.npo.utils.Json;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.annotation.OperationLog;
import com.wy.npo.utils.easyui.Tree;


/**
 * 组织机构管理
 * @author wangy
 */
@Controller
@RequestMapping("/org")
public class OrgController {
	
	 private static final Logger logger = LoggerFactory.getLogger(OrgController.class);
	 
	 @Autowired
	 private ISysOrgService sysOrgService;
	 
	 /**
	  * 进入员工管理界面
	  * @param model
	  * @return
	  */
	 @RequestMapping(value = "/staffList",method = RequestMethod.GET)
	 @RequiresPermissions("org.staff.view.list")
	 public String staList(Model model) {
		    
	        return "/org/staffList";
	 }	
	 
	 /**
	  * 加载组织结构
	  * @param response
	  * @param page
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/staffList", method = RequestMethod.POST)
	 public List<Tree> treegrid(HttpServletResponse response,PageHelper page) {
		  List<Tree> treeList = new ArrayList<Tree>();
		  List<SysOrg> orgList = sysOrgService.getAll(page);
		  for(SysOrg sysOrg:orgList){
			  Tree node = new Tree();
				
			  node.setId(sysOrg.getId());
			  node.setPid(sysOrg.getPid());
			  node.setText(sysOrg.getName());
				
			  if(sysOrg.getPid()!=0){	// 有父节点
					node.setPid(sysOrg.getPid());
			  }
			  if(sysOrg.getCountChildrens() > 0){	//有子节点
					node.setState("closed");
			  }
			  treeList.add(node);
		  }
		  return treeList;
	 }
	 
	 /**
	  * 进入组织结构管理页面
	  * @param model
	  * @return
	  */
	 @RequestMapping(value = "/orgList",method = RequestMethod.GET)
	 @RequiresPermissions("org.view.list")
	 public String orgList(Model model) {
		  //检查权限
		  boolean isEditOrgPermission = false;
		  Subject subject = SecurityUtils.getSubject();
		  if(subject.isPermitted("org.view.update")){
			  isEditOrgPermission = true;
		  }
		  model.addAttribute("isEditOrgPermission", isEditOrgPermission);
		  
		  boolean isDeleteOrgPermission = false;
		  if(subject.isPermitted("org.view.delete")){
			  isDeleteOrgPermission = true;
		  }
		  model.addAttribute("isDeleteOrgPermission", isDeleteOrgPermission);
	      return "/org/orgList";
	 }
	 
	 /**
	  * 组织机构选择
	  * @param model
	  * @return
	  */
     @RequestMapping(value = "/org_select" ,method = RequestMethod.GET)
	 public String queryOrg(Model model){
		  return "/org/org_select";
	 }
	 
	 /**
	  * 加载组织结构管理页面树形菜单
	  * @param response
	  * @param page
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/orgList", method = RequestMethod.POST)
	 public List<SysOrg> orgTreegrid(HttpServletResponse response,PageHelper page,Model model) {
		  List<SysOrg> orgList = sysOrgService.getAll(page);
		  List<SysOrg> treeList = new ArrayList<SysOrg>();
		  for (SysOrg org : orgList) {
			  if(org.getPid() == 0){ //有父节点
				  SysOrg sysOrg = recursionTree(orgList,org);
				  treeList.add(sysOrg);
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
	 private SysOrg recursionTree(List<SysOrg> list,SysOrg currentNode){
		    List<SysOrg> childList = new ArrayList<SysOrg>();
		    for(SysOrg newNode:list){
		    	if((newNode.getPid() !=0) && (newNode.getPid().compareTo(currentNode.getId()) == 0)){
		    		 SysOrg sysOrg = recursionTree(list,newNode);
		    		 childList.add(sysOrg);
		    	}
		    }
		    if(childList.size() > 0){
		    	currentNode.setChildren(childList);
		    }
		    return currentNode;
	 }

	 /**
	  * 新增/修改组织结构
	  * @param sysOrg
	  * @param pid
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 @RequiresPermissions(value={"org.view.add","org.view.update"},logical=Logical.OR)  //符合条件之一即可
	 @OperationLog(operationType= OperationTypeEnum.OPERATION_UPDATE,operationName="组织机构")
	 public Json addOrg(SysOrg sysOrg,HttpServletRequest request){
		 Json j = new Json();
		 String pidStr = request.getParameter("pid");
		 String idStr = request.getParameter("id");
		 logger.info("新增/修改组织数据，组织所属上级组织的ID为：{},组织ID:{}",pidStr,idStr);
		 try{
			 if(StringUtils.isBlank(idStr)){
			     sysOrgService.addOrg(sysOrg, Integer.valueOf(pidStr));
			 }else{
				 sysOrg.setId(Integer.valueOf(idStr));
				 sysOrgService.updateOrg(sysOrg);
			 }
			 j.setSuccess(true);
	         j.setMsg("新增/修改组织成功！");
	         j.setObj(sysOrg);
		 }catch(Exception e){
			 e.printStackTrace();
	         j.setMsg(e.getMessage());
		 }
		 return j;
	 }
	 
	 /**
	  * 
	  * @param id
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	 @RequiresPermissions("org.view.delete")
	 @OperationLog(operationType=OperationTypeEnum.OPERATION_DELETE,operationName="组织机构")
	 public Json deleteOrg(@RequestParam Integer id){
		 Json j = new Json();
		 try{
			 sysOrgService.deleteOrg(id);
			 j.setSuccess(true);
	         j.setMsg("删除组织成功！");
		 }catch(Exception e){
			 e.printStackTrace();
	         j.setMsg(e.getMessage());			 
		 }
		 return j;
	 }
}
