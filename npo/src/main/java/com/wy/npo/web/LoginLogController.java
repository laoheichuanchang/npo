package com.wy.npo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wy.npo.entity.SysUserLoginLog;
import com.wy.npo.service.IUserLoginLogService;
import com.wy.npo.utils.ExcelView;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.easyui.DataGrid;

@Controller
@RequestMapping("/loginLog")
public class LoginLogController {

	 final static Logger logger = LoggerFactory.getLogger(LoginLogController.class);
	 
	 @Autowired
	 private IUserLoginLogService  userLoginLogService;
	 
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	 @RequiresPermissions("loginLog.view.list")
	 public String list(Model model){
		 return "/loginLog/list";
	 }
	
	 @RequestMapping(value = "/list",method = RequestMethod.POST)
	 @ResponseBody
	 public DataGrid dataGrid(PageHelper page,SysUserLoginLog sysUserLoginLog){
		 logger.info("查询登录日志请求参数：{}",sysUserLoginLog);
		 DataGrid dg = new DataGrid();
		 dg.setRows(userLoginLogService.selectListByBean(page, sysUserLoginLog));
		 dg.setTotal(userLoginLogService.selectCountByBean(sysUserLoginLog));
		 return dg;
	 }
	 
	 @RequestMapping(value = "/export",method = RequestMethod.GET)
	 public ModelAndView exportExcel(HttpServletRequest request,HttpServletResponse response, SysUserLoginLog sysUserLoginLog){
		  List<SysUserLoginLog> list = userLoginLogService.selectListByBean(sysUserLoginLog);
		  
		  //将list放入Map类型的对象中，即可
	      Map<String, Object> map = new HashMap<>();
	      map.put("list",list);
	      return new ModelAndView(new ExcelView("登录日志","登录日志"),map);
	 }
}
