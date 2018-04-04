<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script type="text/javascript">
    var readonly = "${readonly}";
</script>
<script src="${path}/js/user/edit.js" type="text/javascript"></script> 
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="padding-left:15px;padding-right:15px;">
         <div class="datagrid-toolbar">基本信息 
	          <c:if test="${not empty readonly}">
		            <a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-back"  plain="true" onclick="javascript:history.go(-1);">返回</a>
			  </c:if>
		 </div>   
		 <form id="form" method="post" novalidate>
		        <input name="id" id="id" type="hidden" value="${record.id}"/>
		        <div class="fitem">
		            <table   style="border-collapse:separate; border-spacing:0px 10px;width:100%">
		                <tr>
		                    <td width="10%" align="right">账号：</td>
		                    <td width="90%">
		                        <input name="account" id="account" value="${record.account}" ${readonly} class="easyui-textbox" required="true">
		                    </td>
		                </tr>
		                <c:if test="${empty record.id}">
			                <tr>
			                    <td width="10%" align="right">密码：</td>
			                    <td width="90%">
			                        <input name="password" id="password"  type="password" value="${record.password}" ${readonly} class="easyui-textbox" required="true">
			                    </td>
			                </tr>
		                </c:if>
		                <tr>
		                     <td align="right">姓名：</td>
		                     <td>
		                         <input name="name" id="name" value="${record.name}" ${readonly} class="easyui-textbox" required="true">
		                     </td>
		                </tr>
		                <tr>
		                     <td align="right">手机号码：</td>
		                     <td>
		                        <input name="mobile" id="mobile" value="${record.mobile}" ${readonly} class="easyui-textbox">
		                     </td>
		                </tr>
		                <tr>
		                     <td align="right">电话：</td>
		                     <td>
		                        <input name="tel" id="tel" value="${record.tel}" ${readonly} class="easyui-textbox">
		                     </td>
		                </tr>
		                <tr>
		                     <td align="right">邮箱地址：</td>
		                     <td>
		                        <input name="email" id="email" value="${record.email}" ${readonly} validType="email"  class="easyui-textbox">
		                     </td>
		                </tr>
		                <tr>
		                     <td align="right">入职时间：</td>
		                     <td>
		                        <input name="regTime" id="regTime" value="${record.regTime}" ${readonly} class="easyui-datebox">
		                     </td>
		                </tr>
		                <tr>
		                     <td align="right">角色：</td>
		                     <td>
		                          <input id="roleId"  name="roleId" type="hidden" value="${record.roleIds}"/>
		                          <c:choose>
		                             <c:when test="${not empty readonly}">
		                                <input name="roleName" id="roleName" value="${record.roleNames}" disabled class="easyui-textbox" required="true">
		                             </c:when>
		                             <c:otherwise>
		                                <input name="roleName" id="roleName" value="${record.roleNames}" class="easyui-textbox" required="true">
		                             </c:otherwise>
		                          </c:choose>
		                     </td>
		                </tr>
		            </table>
		        </div>
		        <c:if test="${empty readonly}">
			        <div style="padding-left:100px;margin-top:10px;" align="left">
						<a href="javascript:void(0)" class="easyui-linkbutton c6"
								iconCls="icon-ok" onclick="save()" style="width:90px">提交</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"
								iconCls="icon-cancel" onclick="javascript:history.go(-1);"
								style="width:90px">取消</a>
				    </div>
			    </c:if>
		 </form>
		<div id="dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
        </div>
        <!-- 添加/修改对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="selected()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>
