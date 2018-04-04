<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;width:100%;height:100%;">
		<table id="roleDatagrid" class="easyui-datagrid" 
			    fit="true"
				url="../role/list" 
				toolbar="#toolbar" 
				pagination="true"
				fitColumns="true"
				singleSelect="true" 
				checkOnSelect="false"
				selectOnCheck="false"
				scrollbarSize="0"
				rownumbers="true"
				striped="true"
				border="false" 
				nowrap="false">
				<thead>
					<tr>
					    <th data-options="field:'id',checkbox:true">编号</th>
						<th field="name" width="100">角色名称</th>
					</tr>
				</thead>
		</table>
		<!-- 按钮 -->
		<div id="toolbar">
			<form id="roleForm" method="post">
			  <span style="padding-left:10px;">角色名称:</span>
			  <input name="name" id="name" value=""  />
			  <a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    </form>
		</div>
		
	</div>
</body>
</html>
