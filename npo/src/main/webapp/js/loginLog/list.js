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
        sortName:'loginTime',
        sortOrder:'desc',
        columns:[[  
            {field:'id',title: 'ID',align: 'center',width:'100'},  
            {field:'account',title: '用户账号',align: 'center',width:'200'},
            {field:'userName',title: '用户名称',align: 'center',width:'200'},
            {field:'loginIp',title: '登录IP',align: 'center',width:'200'},
            {field:'loginTime',title: '登录时间',align: 'center',width:'200',sortable:true,formatter:formatDatebox}
        ]]
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

function exportExcel(){
	//$('#exportBtn').linkbutton('disable'); //按钮置灰
	var userName = $('#userName').textbox('getValue');
	var account = $('#account').textbox('getValue');
	var param = "userName="+userName+"&account="+account;
	window.location.href= path +  "/loginLog/export?"+param;
}
