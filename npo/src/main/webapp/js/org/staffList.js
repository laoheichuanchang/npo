//页面加载  
$().ready(function(){  
	//加载组织机构树列表
	$('#organizeTree').tree({  
		lines: true,  
		url: 'staffList',  
		idField: 'id',
		parentField : 'pid',
		onClick: function(node) {  
			$('#staffGird').datagrid('reload', path+"/user/datagrid?sysid="+node.id);  
		}  
	});
	
    
	$('#staffGird').datagrid({  
		fit: true,
	    url: path+"/user/datagrid",  
	    title: "员工（职员）列表",  
	    loadMsg: "正在加载员工（职员）数据，请稍等...",  
	    idField: 'id',  
	    scrollbarSize : 0,
	    pagination: true,
	    border: false,
	    nowrap: false,
	    fitColumns: true,
	    singleSelect: true,  
	    striped: true,  
	    rownumbers: true,  
	    columns: [[  
	            { title: '编号', field: 'code', align: "center",width: 90 },  
	            { title: '姓名', field: 'name', align: "center",width: 80 },  
	            { title: '所在部门', field: 'sysName', align: "center",width: 100 },  
	            { title: '上级部门', field: 'pSysName',align: "center", width: 100 },  
	            { title: '入职时间', field: 'regTime', align: "center", width: 100,sortable:true,formatter: fmtDatebox},  
	            { title: '手机号码', field: 'mobile',align: "center", width: 90,}, 
	            { title: '联系电话', field: 'tel',align: "center", width: 90,}, 
	            { title: '邮箱地址', field: 'email', align: "center", width: 90 }
	        ]],
	    onLoadSuccess: function (data) {  
	        if (data.rows.length > 0) {  
	            $('#staffGird').datagrid("selectRow", 0);  
	        }  
	    }  
	}); 
});  