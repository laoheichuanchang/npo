package com.wy.npo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wy.npo.constants.enums.OperationTypeEnum;
import com.wy.npo.entity.SysRole;
import com.wy.npo.entity.SysUser;
import com.wy.npo.service.ISysRoleService;
import com.wy.npo.utils.ExcelView;
import com.wy.npo.utils.Json;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.annotation.OperationLog;
import com.wy.npo.utils.easyui.DataGrid;
import com.wy.npo.vo.RoleVO;

/**
 * 角色管理
 * @author wangy
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    
	 private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	 
	 @Autowired
	 private ISysRoleService sysRoleService;
	 
	 /**
	  * 进入角色管理列表页面
	  * @param model
	  * @return
	  */
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	 @RequiresPermissions("role.view.list")
	 public String list(Model model){
		 return "/role/list";
	 }
	 
	 /**
	  * 
	  * @param model
	  * @return
	  */
     @RequestMapping(value = "/role_select" ,method = RequestMethod.GET)
	 public String queryRole(Model model){
		  return "/role/role_select";
	 }
	 
	 /**
	  * 加载角色管理列表页数据
	  * @param page
	  * @param role
	  * @return
	  */
	 @RequestMapping(value = "/list",method = RequestMethod.POST)
	 @ResponseBody
	 public DataGrid list(PageHelper page,SysRole role){
		 DataGrid dg = new DataGrid();
		 dg.setRows(sysRoleService.queryListByBean(role, page));
		 dg.setTotal(sysRoleService.queryCountByBean(role));
		 return dg;
	 }
	 
	 /**
	  * 跳转编辑页面
	  * @param model
	  * @return
	  */
	 @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
	 @RequiresPermissions("role.view.add")
	 public String toAdd(Model model) {
		 return "/role/edit";
	 }
	 
	 /**
	  * 编辑角色信息
	  * @param model
	  * @param vo
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/edit",method = RequestMethod.POST)
	 @OperationLog(operationType=OperationTypeEnum.OPERATION_UPDATE,operationName="角色管理")
	 @RequiresPermissions(value={"role.view.add","role.view.update"},logical=Logical.OR)  //符合条件之一即可
	 public Json edit(Model model,@RequestBody RoleVO vo){
		 logger.info("编辑角色请求信息：{}",vo);
		 Json j = new Json();
		 try{
			 sysRoleService.addRole(vo);
			 j.setSuccess(true);
	         j.setMsg("新增/修改角色成功！");
	         j.setObj(vo);
		 }catch(Exception e){
			 j.setMsg(e.getMessage());
			 e.printStackTrace();
		 }
		 return j;
	 }
	 
	 /**
	  * 进入角色修改页面
	  * @param model
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "/toEdit",method = RequestMethod.GET)
	 @RequiresPermissions("role.view.update")
	 public String toEdit(Model model,@RequestParam Integer id){
		 logger.info("进入角色修改页面，角色编号：{}",id);
		 SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
		 logger.info("进入角色修改页面,获取到角色信息：{}",sysRole);
		 model.addAttribute("record", sysRole);
		 return "/role/edit";
	 }
	 
	 /**
	  * 进入角色详情查看页面
	  * @param model
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "/toDetail",method = RequestMethod.GET)
	 public String detail(Model model,@RequestParam Integer id){
		 logger.info("进入角色修改页面，角色编号：{}",id);
		 SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
		 logger.info("进入角色修改页面,获取到角色信息：{}",sysRole);
		 model.addAttribute("record", sysRole);
		 model.addAttribute("readonly", "readonly");
		 return "/role/edit";
	 }
	 
	  @RequestMapping(value = "/export",method = RequestMethod.GET)
	  public ModelAndView exportExcel(){
		  //这只是个测试案例，所以没有新写个方法去查询数据
		  PageHelper page = new PageHelper();
		  page.setPage(1);
		  page.setRows(1000);
		  List<SysRole>  list = sysRoleService.queryListByBean(new SysRole(),page);
		  //将list放入Map类型的对象中，即可
	      Map<String, Object> map = new HashMap<>();
	      map.put("list",list);
	      return new ModelAndView(new ExcelView("角色列表","角色列表"),map);
	  }
}
