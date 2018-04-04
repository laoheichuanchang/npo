<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>组织机构管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script type="text/javascript">
    var isEditOrgPermission = ${isEditOrgPermission};
    var isDeleteOrgPermission = ${isDeleteOrgPermission};
</script>
<script src="${path}/js/org/orgList.js" type="text/javascript" ></script>
</head>
<body class="easyui-layout" fit="true">
  <div region="center" border="false" style="overflow: hidden;">
      <!-- 信息列表 title="菜单管理" -->
	  <table id="treegrid" class="easyui-treegrid" 
			fit="true" nowrap="false"
			fitColumns="true" singleSelect="true" rownumbers="true"
			data-options="url:'${path}/org/orgList',
			idField:'id',
			scrollbarSize:0,
			treeField:'name',
			toolbar:'#toolbar',
			border:false">
			<thead>
				<tr>
					<th data-options="field:'id',width:40">编号</th>
					<th data-options="field:'code',align:'center',width:80">组织编码</th>
					<th data-options="field:'name',width:150">组织名称</th>
					<th data-options="field:'pid',width:40, align:'center',formatter:formatParentId">上级资源ID</th>
					<th data-options="field:'createTime',width:150, align:'center',formatter:formatDatebox">创建时间</th>
					<th data-options="field:'status',width:40,align:'center',formatter:formatState">状态</th>
					<th data-options="field:'action',width:120,formatter:formatAction">操作</th>
				</tr>
			</thead>
		</table>
		
		<!-- 按钮 -->
		<div id="toolbar">
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
			
			  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="onAdd()">增加</a>
		
		</div>
		
		<!-- 添加/修改对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:200px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<form id="form" method="post" novalidate>
			    <div class="fitem">
			       &nbsp;
			    </div>
				<div class="fitem">
					<label>组织名称:</label> <input name="name" class="easyui-textbox" required="true">
				</div>
			</form>
		</div>
		
		<!-- 添加/修改对话框-按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="onSave()" style="width:90px">保存</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
  </div>
</body>
</html>