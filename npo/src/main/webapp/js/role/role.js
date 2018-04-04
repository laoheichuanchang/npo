//页面加载  
$().ready(function(){  
     loadGrid(); 
     //刷新
     $("#reload").click(function(){
    	 loadGrid(); 
     });
});  

//加载表格datagrid  
function loadGrid()  
{  
    //加载数据  
    $('#datagrid').datagrid({   
        fitColumns:true,
        striped: true,  
        singleSelect : true,
        scrollbarSize : 0,
        url:'list',  
        queryParams:serializeObject($("#form")),  
        loadMsg:'数据加载中请稍后……',  
        pagination: true,  
        rownumbers: true,     
        sortName:'createTime',
        sortOrder:'desc',
        columns:[[  
            {field:'code',title: '角色编码',align: 'center',width:'150'},  
            {field:'name',title: '角色名称',align: 'center',width:'150'},  
            {field:'rmk',title: '角色描述',align: 'center',width:'200'},
            {field:'createName',title: '创建人',align: 'center',width:'80'},
            {field:'createTime',title: '创建时间',align: 'center',width:'140',sortable:true,formatter:formatDatebox},  
            {field:'updateName',title: '修改人',align: 'center',width:'80'},
            {field:'updateTime',title: '修改时间',align: 'center',width:'140',sortable:true,formatter:formatDatebox}
        ]],
        onDblClickRow: function (index, row) {  
        	window.location.href=path+"/role/toDetail?id="+row.id; 
        }  
    });
}  


//刷新
function reload(){
	$('#datagrid').datagrid('reload'); 
}

//快速查询
function FindData(){
	//easyui带参数向后台发送请求  
	 loadGrid();  
}
//编辑
function editRole(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		var id = row.id;
        window.location.href=path+"/role/toEdit?id="+id; 
	}else{
		$.messager.alert('提示', '请选择要编辑的记录！', 'error');
	}
}

function exportExcel(){
	window.location.href= path +  "/role/export"
}
