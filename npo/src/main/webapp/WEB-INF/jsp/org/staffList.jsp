<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>组织机构管理</title>
<%@include file="/WEB-INF/jsp/include/easyui.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script src="../js/org/staffList.js" type="text/javascript"></script> 
</head>
<body class="easyui-layout" fit="true" >
		<!-- 左半部-组织机构 -->
		<div id="div_organizeTree" region="west" iconCls="icon-chart_organisation" split="true" title="组织机构" 
				style="width:200px;padding: 2px" collapsible="false"> 
			<ul id="organizeTree"></ul>  
		</div> 
		<!-- 右半部-员工列表-->
		<div id="div_staffGird" region="center" iconCls="icon-users" style="overflow: hidden"> 
			<div id="toolbar">
			    <!-- 按钮 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="addUser();">新增</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="deleteUser();">删除</a>-->
				<span>用户名:</span><input name="search_username" id="search_username" value="" size=10 /> 
	  			<a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				
			</div>
			<!-- 员工列表 -->
			<table id="staffGird" toolbar="#toolbar"></table>  
		</div>   
</body>