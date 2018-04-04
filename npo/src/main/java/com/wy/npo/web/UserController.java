package com.wy.npo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
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
import com.wy.npo.service.IUserService;
import com.wy.npo.utils.ExcelView;
import com.wy.npo.utils.Json;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.annotation.OperationLog;
import com.wy.npo.utils.easyui.DataGrid;
import com.wy.npo.vo.UserVO;

/**
 * 用户管理
 * @author wangy
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	 @Autowired
	 private IUserService userService;
	 
	 /**
	  * 根据组织机构查询下属所有的用户信息
	  * @param page
	  * @param user
	  * @param sysid
	  * @return
	  */
     @ResponseBody
	 @RequestMapping(value="/datagrid", method = RequestMethod.POST)
     public DataGrid datagrid(PageHelper page,SysUser user,Integer sysid) {
    	 DataGrid dg = new DataGrid();
    	 dg.setRows(userService.datagridUser(page, sysid));
    	 dg.setTotal(userService.getDatagridTotal(sysid));
    	 return dg;
     }
     
     /**
      * 进入用户列表页面
      * @param model
      * @return
      */
     @RequestMapping(value="/list",method = RequestMethod.GET)
     @RequiresPermissions("user.view.list")
     public String list(Model model){
    	 
    	 return "/user/list";
     }
     
     /**
      * 加载列表页数据
      * @param page
      * @param user
      * @return
      */
     @ResponseBody
     @RequestMapping(value="/list",method = RequestMethod.POST)
     public DataGrid list(PageHelper page,SysUser user){
    	 DataGrid dg = new DataGrid();
    	 dg.setRows(userService.queryListByBean(page, user));
    	 dg.setTotal(userService.queryCountByBean(user));
    	 return dg;
     }
     
     
	 /**
	  * 跳转编辑页面
	  * @param model
	  * @return
	  */
	 @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
	 @RequiresPermissions("user.view.add")
	 public String toAdd(Model model) {
		 return "/user/edit";
	 }
	 
	 /**
	  * 新增用户
	  * @param model
	  * @param vo
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "/edit",method = RequestMethod.POST)
	 @RequiresPermissions(value={"user.view.add","user.view.update"},logical=Logical.OR)
	 @OperationLog(operationType=OperationTypeEnum.OPERATION_UPDATE,operationName="用户管理")
	 public Json edit(Model model,@RequestBody UserVO vo){
		 logger.info("编辑用户请求信息：{}",vo);
		 Json j = new Json();
		 try{
			 userService.edit(vo);
			 j.setSuccess(true);
	         j.setMsg("新增/修改用户成功！");
	         j.setObj(vo);
		 }catch(Exception e){
			 j.setMsg(e.getMessage());
			 e.printStackTrace();
		 }
		 return j;
	 }
	 
	 @RequestMapping(value = "/toEdit",method = RequestMethod.GET)
	 @RequiresPermissions("user.view.update")
	 public String toEdit(Model model,@RequestParam Integer id){
		 logger.info("进入用户修改页面，用户编号：{}",id);
		 SysUser sysUser = userService.selectBeamByKey(id);
		 List<SysRole> sysRoles = sysUser.getSysRoles();
		 String roleIds = "";
		 String roleNames = "";
		 for(SysRole sysRole:sysRoles){
			 roleIds += sysRole.getId() + ",";
			 roleNames += sysRole.getName() + ",";
		 }
		 sysUser.setRoleIds(roleIds);
		 sysUser.setRoleNames(roleNames);
		 model.addAttribute("record", sysUser);
		 return "/user/edit";
	 }
	 
	 @RequestMapping(value = "/toDetail",method = RequestMethod.GET)
	 public String detail(Model model,@RequestParam Integer id){
		 logger.info("进入用户详情页面，用户编号：{}",id);
		 SysUser sysUser = userService.selectBeamByKey(id);
		 List<SysRole> sysRoles = sysUser.getSysRoles();
		 String roleIds = "";
		 String roleNames = "";
		 for(SysRole sysRole:sysRoles){
			 roleIds += sysRole.getId() + ",";
			 roleNames += sysRole.getName() + ",";
		 }
		 sysUser.setRoleIds(roleIds);
		 sysUser.setRoleNames(roleNames);
		 model.addAttribute("record", sysUser);
		 model.addAttribute("readonly", "readonly");
		 return "/user/edit";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value = "/delete",method = RequestMethod.POST)
	 @OperationLog(operationType=OperationTypeEnum.OPERATION_DELETE,operationName="用户管理")
	 @RequiresPermissions("user.view.delete")
	 public Json delete(Model model,@RequestParam Integer id){
		  logger.info("发起用户删除操作:{}",id);
		  Json j = new Json();
		  try{
			  userService.deleteByPrimaryKey(id);
			  j.setSuccess(true);
		      j.setMsg("删除用户成功！");
		  }catch(Exception e){
			  j.setMsg(e.getMessage());
			 e.printStackTrace();
		  }
		  return j;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
	 @OperationLog(operationType=OperationTypeEnum.OPERATION_UPDATE_PWD,operationName="用户管理")
	 public Json updatePassword(HttpServletRequest request, HttpServletResponse response,int userId,String password,String confPassword){
		    Json j = new Json();
			try {
				SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
				if(StringUtils.isBlank(password) || StringUtils.isBlank(confPassword)){
					j.setSuccess(false);
				    j.setMsg("密码为空！");
				}else if(!password.equals(confPassword)){
					j.setSuccess(false);
				    j.setMsg("两次输入的密码不一致！");
				}else{
					userService.updatePassword(loginUser.getId(), password, loginUser.getId());
				    j.setSuccess(true);
				    j.setMsg("修改密码成功！");
				    j.setObj(loginUser);
				}
			} catch (Exception e) {
				e.printStackTrace();
			    j.setMsg(e.getMessage());
			}
			return j;
	  }
	  
	  
	  @ResponseBody
	  @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
	  @OperationLog(operationType=OperationTypeEnum.OPERATION_RESET_PWD,operationName="用户管理")
	  @RequiresPermissions("user.view.resetPwd")
	  public Json resetPassword(int id) {
	        Json j = new Json();
	        logger.debug("重置密码，传过来的用户ID为："+id);
	        try {
	            userService.resetPassword(id);
	            j.setSuccess(true);
	            j.setMsg("用户密码重置成功！");
	        } catch (Exception e) {
	            j.setMsg(e.getMessage());
	        }
	        return j;
	  }
	  
	  @RequestMapping(value = "/export",method = RequestMethod.GET)
	  public ModelAndView exportExcel(){
		  //这只是个测试案例，所以没有新写个方法去查询数据
		  PageHelper page = new PageHelper();
		  page.setPage(1);
		  page.setRows(1000);
		  List<SysUser>  list = userService.queryListByBean(page, new SysUser());
		  //将list放入Map类型的对象中，即可
	      Map<String, Object> map = new HashMap<>();
	      map.put("list",list);
	      return new ModelAndView(new ExcelView("用户列表","用户列表"),map);
	  }
}
