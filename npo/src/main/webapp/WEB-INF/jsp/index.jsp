<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>机构合作部内部管理系统</title>

<STYLE>
.main_header{width:100%;height:64px;margin:0px;background:url("${path}/img/login_bg.jpg") repeat-x;overflow: hidden;}
.header_left{float:left;width:259px;height:50;margin:5px 0px 0px 10px;background:url("${path}/img/logo2.png");}
</STYLE>

<script type="text/javascript">
	window.onload = function () {  
	    if (window.parent.window != window) {  
	        window.top.location = "<%=path%>/login";  
	    }  
	}  
   
	$(function() {
		$('#mainMenu').tree({
			url : path+'/resource/getMenu',
			parentField : 'pid',
			onClick : function(node) {
				if (node.attributes.url) {
					var src = path + node.attributes.url;
					if (!$.startWith(node.attributes.url, '/')) {	//不是本项目的url，例如www.baidu.com
						src = node.attributes.url;
					}
					var tabs = $('#mainTabs');
					var opts = {
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						content : $.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:99.80%;height:99%;padding-left:2px;" frameBorder="0"></iframe>', src),
						border : false,
						fit : true
					};
					if (tabs.tabs('exists', opts.title)) {
						tabs.tabs('select', opts.title);
					} else {
						tabs.tabs('add', opts);
					}
				}
			}
		});
	})
	
	//点击用户信息按钮
	function userInfoFun2(){
		$('#dlg').dialog('open').dialog('setTitle','用户信息');
	}
	function updatePassword(){
		var password = $('#password').val();
		var confPassword = $('#confPassword').val();
		var reg = new RegExp("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,30}");
		if (!reg.test(password)){
			$.messager.show({ 
				 title: "提示",
				 msg: '密码中必须包含字母、数字、特称字符，至少8个字符，最多30个字符！'
			});
			return;
		}else if(password != confPassword){
			$.messager.show({ 
				 title: "提示",
				 msg: '两次输入的密码不一致！'
			});
			return;
		}
		$('#userForm').form('submit',{
		 	url: path+"/user/updatePassword",
		 	onSubmit: function(){
		 		return $(this).form('validate');
		 	},
			success: function(result){
				var result = eval('('+result+')');
				if (result.success){
					$('#userForm').form('clear');
				 	$('#dlg').dialog('close'); 
				} else {
					 mesTitle = '更改密码失败';
				}
				$.messager.show({ 
					 title: "更改密码成功",
					 msg: result.msg
				});
			}
		});
	}
</script>
</head>
    <body class="easyui-layout">  
        <!-- 正上方panel -->  
        <div data-options="region:'north',border:false" style="height:60px;background:#FFFFFF;padding:0px">
        <!-- <div class="main_header" region="north" style="height:70px;padding:5px;" > -->
			<div class="header_left"></div>
			
	        <div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
	            <strong>${user.name}</SPAN></strong>&nbsp;欢迎你！
	            <SPAN id=clock ></SPAN>
				<SCRIPT type=text/javascript> 
				    var clock = new Clock();
				    clock.display(document.getElementById("clock"));
				</SCRIPT>
	        </div>
	        <div style="position: absolute; right: 0px; bottom: 0px; ">
	            <!--  <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>-->
	            <a href="javascript:void(0);" class="easyui-menubutton"  data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a> 
	            <a href="javascript:void(0);" class="easyui-menubutton"  data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
	        </div>
				
	        <!--  <div id="layout_north_pfMenu" style="width: 120px; display: none;">
	            <div onclick="changeTheme('default');">默认</div>
	        </div>-->
	        <div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	            <div onclick="userInfoFun2();">个人信息</div>
	        </div>
	        <div id="layout_north_zxMenu" style="width: 100px; display: none;">
	            <!-- <div onclick="logout();">重新登录</div>
	            <div class="menu-sep"></div> -->
	            <div onclick="logoutClose(true);">退出系统</div>
	        </div>
	        
        </div>  
	    	
	    <!-- 个人信息对话框 -->
		<div id="dlg" class="easyui-dialog" style="width:400px;height:285px;padding:30px 20px" closed="true" buttons="#dlg-buttons">
			<form id="userForm" method="post" novalidate>
				<input type="hidden" name="userId" value="${user.id}"/>
				<div class="fitem">
					<label>账&nbsp;&nbsp;&nbsp;&nbsp;号：</label><span style="padding-left:10px;">${user.account}</span>
				</div>
				<div class="fitem">
					<label>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label><span style="padding-left:10px;">${user.name}</span>
				</div>
				<div class="fitem">
					<label>手机号：</label> <span style="padding-left:5px;">${user.mobile}</span>
				</div>
				<div class="fitem">
					<label>新密码：</label> <input name="password" id="password" class="easyui-textbox" type="password" required="true">
				</div>
				<div class="fitem">
					<label>确认密码：</label> <input name="confPassword" id="confPassword" class="easyui-textbox" type="password" required="true">
				</div>
				<div class="fitem"><span style="font-size:13px;color:red;">【密码中必须包含字母、数字、特称字符，至少8个字符，最多30个字符！】</span></div>
				<strong id="tip"></strong>
			</form>
		</div>
		<!-- 对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-edit" onclick="updatePassword()" style="width:90px">修改密码</a> 
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a> -->
		</div>
	    	
		<!-- 左侧菜单 -->
        <div data-options="region:'west',href:''" title="导航菜单" style="width: 200px; padding: 0px;">
			<ul id="mainMenu"></ul>
			
		</div>
		
        <!-- 正中间panel -->  
        <!-- <div region="center" title="功能区" >   -->
        <div region="center">  
            <div class="easyui-tabs" id="mainTabs" fit="true" border="false">  
                <div title="欢迎使用" style="padding:20px;">   
                    <div style="margin-top:20px; float:left;min-width:600px;widht: 600px; height: 90%; ">  
                        <h1 style="font-size:24px;">机构合作部内部管理系统</h1>
                    </div>  
                </div>  
            </div>  
        </div>  
        
        <!-- 正下方panel -->  
        <div region="south" style="height:24px;line-height:22px;background-color:#c7000b;font" align="center">  
            <label style="font-size:11px;color:#FFF">机构合作部内部管理系统&nbsp;&nbsp;&nbsp;</label>  
        </div>   
    </body>
</html>
