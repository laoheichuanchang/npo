<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script type="text/javascript">
    var _roleId = "${record.id}";
    var readonly = "${readonly}";
</script>
<script src="${path}/js/role/add.js" type="text/javascript"></script> 
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
		                    <td width="10%" align="right">角色名称：</td>
		                    <td width="90%">
		                        <input name="name" id="name" value="${record.name}" ${readonly} class="easyui-textbox" required="true">
		                    </td>
		                </tr>
		                <tr>
		                     <td align="right">所属组织：</td>
		                     <td>
		                         <input id="orgId"  name="orgId" type="hidden" value="${record.orgId}"/>
		                         <c:choose>
		                             <c:when test="${not empty readonly}">
		                                 <input name="orgName" id="orgName" value="${record.orgName}" disabled class="easyui-textbox" required="true">
		                             </c:when>
		                             <c:otherwise>
		                                 <input name="orgName" id="orgName" value="${record.orgName}" class="easyui-textbox" required="true">
		                             </c:otherwise>
		                         </c:choose>
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
		        <c:if test="${empty readonly}">
			        <div style="padding-left:20px;margin-top:10px;" align="center">
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
