<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script src="${path}/js/role/add.js" type="text/javascript"></script> 
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;padding-top:5px;">
         <div class="datagrid-toolbar">基本信息 
	          <c:if test="${not empty readonly}">
		            <a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-back"  plain="true" onclick="javascript:history.go(-1);">返回</a>
			  </c:if>
		 </div>   
		 <form id="form" method="post" novalidate>
		        <div class="fitem">
		            <table   style="border-collapse:separate; border-spacing:0px 10px;width:100%">
		                <tr>
		                    <td width="10%" align="right">所属业务：</td>
		                    <td width="90%">
		                        <input name="name" id="name" value="${record.name}" ${readonly} class="easyui-textbox" >
		                    </td>
		                </tr>
		                <tr>
		                     <td align="right">角色描述：</td>
		                     <td>
		                        <input class="easyui-textbox" name="rmk" data-options="multiline:true" ${readonly} value="${record.rmk}" style="width:300px;height:100px">
		                     </td>
		                </tr>
		            </table>
		        </div>
		        <div class="datagrid-toolbar">权限信息</div>
		        <table id="datagrid"></table> 
		 </form>
	</div>
</body>
</html>
