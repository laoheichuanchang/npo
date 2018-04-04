<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<script type="text/javascript">
    var path = "${path}";
</script>

<!-- 引用Jquery的Js文件 -->
<%-- <script src="${path}/assets/js/jquery/jquery-1.11.1.min.js" type="text/javascript" ></script> --%>
<script src="${path}/js/jquery/jquery-1.11.1.min.js" type="text/javascript"></script> 
<script src="${path}/js/jquery/jquery.portal.js" type="text/javascript" ></script>
<script src="${path}/js/jquery/jquery.cookie.js" type="text/javascript" ></script>
<script src="${path}/js/jquery/ajaxfileupload.js" type="text/javascript" ></script>
<!-- jquery选择框 -->
<link id="jboxcss" href="${path}/js/jquery-jbox/Skins/Bootstrap/jbox.css" rel="stylesheet" />
<script src="${path}/js/jquery-jbox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="${path}/js/jquery-jbox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>

<!-- 引用Easy UI 修订过的Js文件 -->
<script src="${path}/js/easyui/jquery.easyui.min.core.js" type="text/javascript"></script>
<!-- 引用EasyUI的国际化文件,让它显示中文 -->
<script src="${path}/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<!-- 引入easyui扩展 -->
<script src="${path}/js/easyui/extEasyUI.js" type="text/javascript"></script>
<!-- 扩展jQuery -->
<script src="${path}/js/easyui/extJquery.js" type="text/javascript"></script>
<!-- 引入自己的js -->
<script src="${path}/js/main.js" type="text/javascript"></script>
<script src="${path}/js/easyui/jeasyui.common.js"  type="text/javascript" ></script>
<SCRIPT src="${path}/js/index/Clock.js" type=text/javascript></SCRIPT>

<!-- 导入Easy UI的主题Css文件 -->
<link id="easyuiTheme" href="${path}/js/easyui/themes/default/easyui.core.css" rel="stylesheet" type="text/css" />

<!-- 导入Easy UI的图标Css文件 -->
<link href="${path}/js/easyui/themes/icon.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${path}/css/portal.css">
<link rel="stylesheet" type="text/css" href="${path}/css/common.css">
<link rel="stylesheet" type="text/css" href="${path}/css/skin.css">
<link rel="stylesheet" type="text/css" href="${path}/css/goujiu.css"/>
<!-- 对话框的样式 -->
<link href="${path}/css/list.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
jQuery.browser={};(function(){jQuery.browser.msie=false; jQuery.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();
</script>

