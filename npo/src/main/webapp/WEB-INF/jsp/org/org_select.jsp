<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;width:100%;height:100%;">
		<table id="orgTreegrid" class="easyui-treegrid" 
			fit="true" nowrap="false"
			fitColumns="true" singleSelect="true" rownumbers="true"
			data-options="url:'../org/orgList',
			idField:'id',
			scrollbarSize:0,
			treeField:'name',
			border:false">
			<thead>
				<tr>
					<th data-options="field:'id',width:40">编号</th>
					<th data-options="field:'name',width:150">组织名称</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>
