//页面加载  
$().ready(function(){  
     loadGrid(); 
     //刷新
     $("#reload").click(function(){
    	 loadGrid(); 
     });
     
     var operationTypeData;
     operationTypeData = [];
     operationTypeData.push({ "text": "修改/新增", "value": 1 },{ "text": "删除", "value": 2},
    		 {"text":"重置密码","value":3},{"text":"修改密码","value":4});
     $("#operationType").combobox("loadData", operationTypeData);
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
        sortName:'operationTime',
        sortOrder:'desc',
        columns:[[  
            {field:'id',title: 'ID',align: 'center',width:'80'},  
            {field:'operationName',title: '业务模块',align: 'center',width:'150'},  
            {field:'operationType',title: '操作类型',align: 'center',width:'100',formatter: function (value, row, index){
            	if(value==1){
            		return "修改/新增";
            	}else if(value == 2){
            		return "删除";
            	}else if(value ==3){
            		return "重置密码";
            	}else{
            		return "修改密码";
            	}
            }},
            {field:'requestParams',title: '请求参数',align: 'center',width:'850'},
            {field:'operatorName',title: '操作人',align: 'center',width:'150'},
            {field:'operationTime',title: '操作时间',align: 'center',width:'180',sortable:true,formatter:formatDatebox}
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
