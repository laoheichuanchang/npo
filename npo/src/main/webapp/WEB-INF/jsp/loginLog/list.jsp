<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录日志</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script src="${path}/js/loginLog/list.js" type="text/javascript"></script> 

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="padding-left:15px;padding-right:15px;">

		<!-- 按钮 -->
		<div id="toolbar" style="padding-bottom:5px;">
		  <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" id="reload">刷新</a>
		  <a href="javascript:void(0);" id="exportBtn" class="easyui-linkbutton"
			 iconCls="icon-redo" plain="true" onclick="exportExcel();">导出</a>
			</br>
			<!-- 查询条件 -->
			<form id="form" method="post">
			  	<span>用户名称:</span>
			  	<input name="userName" id="userName" value="" class="easyui-textbox" />
			  	<span>用户账号:</span>
			  	<input name="account" id="account" value="" class="easyui-textbox" />
  			  	<a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    </form>
		</div>
        <!-- 列表数据渲染 -->
        <table id="datagrid"></table>
	</div>
</body>
</html>
