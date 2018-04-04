package com.wy.npo.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.npo.entity.SysOperationLog;
import com.wy.npo.service.ISysOperationLogService;
import com.wy.npo.utils.PageHelper;
import com.wy.npo.utils.easyui.DataGrid;

@Controller
@RequestMapping("/opeLog")
public class OperationLogController {


	 private static final Logger logger = LoggerFactory.getLogger(OperationLogController.class);
	 
	 @Autowired
	 private ISysOperationLogService sysOperationLogService;
	 
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	 @RequiresPermissions("operationLog.view.list")
	 public String list(Model model){
		 return "/opeLog/list";
	 }
	
	 @RequestMapping(value = "/list",method = RequestMethod.POST)
	 @ResponseBody
	 public DataGrid dataGrid(PageHelper page,SysOperationLog sysOperationLog){
		 logger.info("查询操作日志请求参数：{}",sysOperationLog);
		 DataGrid dg = new DataGrid();
		 dg.setRows(sysOperationLogService.queryListByBean(page, sysOperationLog));
		 dg.setTotal(sysOperationLogService.queryCountByBean(sysOperationLog));
		 return dg;
	 }
	 
}
