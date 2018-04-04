<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script src="${path}/js/role/role.js" type="text/javascript"></script> 

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="padding-left:15px;padding-right:15px;">

		<!-- 按钮 -->
		<div id="toolbar" style="padding-bottom:5px;">
		  <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" id="reload">刷新</a>
			<shiro:hasPermission name="role.view.add">		  
				<a href="${path}/role/toAdd" class="easyui-linkbutton"
					iconCls="icon-add" plain="true">新增</a> 
			</shiro:hasPermission>
			<shiro:hasPermission name="role.view.update">	
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editRole();">编辑</a> 
			</shiro:hasPermission>
			<shiro:hasPermission name="role.view.delete">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="deleteRole();">删除</a>
			</shiro:hasPermission>
			</br>
			<!-- 查询条件 -->
			<form id="form" method="post">
			  	<span>角色编号:</span>
			  	<input name="code" id="code" value="" class="easyui-textbox" />
			  	<span>角色名称:</span>
			  	<input name="name" id="name" value="" class="easyui-textbox" />
  			  	<a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    </form>
		</div>
        <!-- 列表数据渲染 -->
        <table id="datagrid"></table>
	</div>
</body>
</html>
