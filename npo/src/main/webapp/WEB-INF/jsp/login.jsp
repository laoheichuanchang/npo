<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构合作部内部管理系统</title>

<link rel="stylesheet" type="text/css" href="css/login.css">

<script src="js/easyui/jquery.min.js" type="text/javascript"></script> 
</head>
<div style="width:100%;height:90%;position: absolute;top:50%;left:50%;margin-top:-320px;margin-left:-50%;">
	<div class="header">欢迎使用</div>
	<div class="center">
		<div class="login_right">
			<div style="width:100%;height:auto;margin-top:150px;">
			<span id="msg" style="color:#F00;font-size:12px;margin-left: 35px;">${msg}</span>
			<form action="login" method="post" name="loginForm" id="loginForm" class="loginForm">
				<div class="login_info">
					<label>用户名：</label>
					<input type="text" name="account" id="account" class="login_input" value="${account }"/>
					&nbsp;<span id="nameerr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<label>密　码：</label>
					<input type="password" name="password" id="password" class="login_input" value="${password }"/>
					&nbsp;<span id="pwderr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<label>验证码：</label>
					<input type="text" name="validateCode" id="validateCode" class="login_input"/>
					&nbsp;<span id="codeerr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<label>　　　　</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img id="validateCodeImg" src="<%=basePath%>/validateCode" />&nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a>
					<!-- <img id="codeImg" alt="点击更换" title="点击更换" src=""/> -->
				</div>
				<p>
				<div class="login_info">
					<input type="button" name="loginBtn" id="loginBtn" style="color: #FFFFFF;" value="登录" class="btn" onclick="login()"/>
					<label>　　　</label>
					<input type="reset" name="cancelBtn" id="cancelBtn" style="color: #FFFFFF;" value="取消" class="btn"/>
				</div>
				<div class="login_info">
					<input type="checkbox" id="autologin" name="autologin" class="autologin" value="" 
					style="margin: 0px; vertical-align: middle; padding: 0px; 
					width: 16px; height: 16px; font-size: 20px;" />&nbsp;一周内自动登录
					<input type="hidden" id="rememberMe" name="rememberMe"  class="autologinch" value=""/>
				</div>
			</form>
			</div>
		</div>
		<div class="login_left">
			<div style="width:100%;height:auto;margin-top:150px;">
				<div class="logo"></div>
				<div class="left_txt">
				
				</div>
			</div>
		</div>
	</div>
	<div class="bottom">
		Copyright &copy; 2015 xxx
	</div>
</div>
	<script type="text/javascript">
		window.onload = function () {  
	        if (window.parent.window != window) {  
	            window.top.location = "<%=path%>/login";  
	        }  
	    }  
		var errInfo = "${errInfo}";
		$(document).ready(function(){
			
		});
	
		function reloadValidateCode(){
		        $("#validateCodeImg").attr("src","<%=basePath%>/validateCode?data=" + new Date() + Math.floor(Math.random()*24));
		}
		
		function resetErr(){
			$("#nameerr").hide();
			$("#nameerr").html("");
			$("#pwderr").hide();
			$("#pwderr").html("");
			$("#codeerr").hide();
			$("#codeerr").html("");
		}
		
		function check(){
			resetErr();
			if($("#account").val()==""){
				$("#nameerr").show();
				$("#nameerr").html("用户名不得为空！");
				$("#account").focus();
				return false;
			}
			if($("#password").val()==""){
				$("#pwderr").show();
				$("#pwderr").html("密码不得为空！");
				$("#password").focus();
				return false;
			}
			if($("#validateCode").val()==""){
				$("#codeerr").show();
				$("#codeerr").html("验证码不得为空！");
				$("#validateCode").focus();
				return false;
			}
			if($(".autologin").is(":checked")){
		    	$(".autologinch").val("Y");
		    }
			return true;
		}
		
		//回车键提交
		document.onkeydown = function (e) {
            if (!e) e = window.event;
            if ((e.keyCode || e.which) == 13) {
                login();
            }
        }
		
		function login(){
			check();
	    	document.loginForm.submit();
		}    	
		
		
	</script>
</body>
</html>