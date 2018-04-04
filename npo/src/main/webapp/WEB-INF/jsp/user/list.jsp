<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script src="${path}/js/user/list.js" type="text/javascript"></script> 

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="padding-left:15px;padding-right:15px;">

		<!-- 按钮 -->
		<div id="toolbar" style="padding-bottom:5px;">
		  <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" id="reload">刷新</a>
			<shiro:hasPermission name="user.view.add">		  
				<a href="${path}/user/toAdd" class="easyui-linkbutton"
					iconCls="icon-add" plain="true">新增</a> 
			</shiro:hasPermission>
			<shiro:hasPermission name="user.view.update">	
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a> 
			</shiro:hasPermission>
			<shiro:hasPermission name="user.view.delete">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="deleteUser();">删除</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="user.view.resetPwd">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-redo" plain="true" onclick="resetPwd();">重置密码</a>
			</shiro:hasPermission>
			<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-redo" plain="true" onclick="exportExcel();">导出</a>
			</br>
			<!-- 查询条件 -->
			<form id="form" method="post">
			  	<span>用户编号:</span>
			  	<input name="code" id="code" value="" class="easyui-textbox" />
			  	<span>用户姓名:</span>
			  	<input name="name" id="name" value="" class="easyui-textbox" />
			    <span>手机号码:</span>
			  	<input name="mobile" id="mobile" value="" class="easyui-textbox" />
			  	<span>电话:</span>
			  	<input name="tel" id="tel" value="" class="easyui-textbox" />
			  	<span>邮箱:</span>
			  	<input name="email" id="email" value="" class="easyui-textbox" />
  			  	<a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    </form>
		</div>
        <!-- 列表数据渲染 -->
        <table id="datagrid"></table>
	</div>
</body>
</html>
