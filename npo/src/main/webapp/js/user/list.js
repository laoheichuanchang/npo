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
            {field:'code',title: '用户编码',align: 'center',width:'150'},  
            {field:'account',title: '账号',align: 'center',width:'150'},  
            {field:'name',title: '姓名',align: 'center',width:'100'},
            {field:'mobile',title: '手机号码',align: 'center',width:'150'},
            {field:'tel',title: '电话',align: 'center',width:'150'},
            {field:'email',title: '邮箱地址',align: 'center',width:'200'},
            {field:'regTime',title: '注册时间',align: 'center',width:'180',sortable:true,formatter: fmtDatebox},
            {field:'createName',title: '创建人',align: 'center',width:'120'},
            {field:'createTime',title: '创建时间',align: 'center',width:'180',sortable:true,formatter:formatDatebox}
        ]],
        onDblClickRow: function (index, row) {  
        	window.location.href=path+"/user/toDetail?id="+row.id; 
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
function editUser(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		var id = row.id;
        window.location.href=path+"/user/toEdit?id="+id; 
	}else{
		$.messager.alert('提示', '请选择要编辑的记录！', 'error');
	}
}

function deleteUser(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		var id = row.id;
		$.messager.confirm("操作提示", "确定要删除该记录吗?", function (data) { 
			if (data) {  
				$.ajax({
                    url: path+"/user/delete",
                    data: {id:id},
                    type: "post",
                    async: true,
                    beforeSend : function(){
                    	MaskUtil.mask();
                    },
                    success: function(result){
                    	MaskUtil.unmask(); 
        				var result = eval('('+result+')');
        				var mesTitle = "操作成功";
        				if (result.success){
        					$('#datagrid').datagrid('reload'); 
        				} else {
        					mesTitle = '操作失败';
        				}
        				$.messager.show({ 
        					 title: mesTitle,
        					 msg: result.msg
        				});
        			}
                });
			}
		});
	}else{
		$.messager.alert('提示', '请选择要删除的记录！', 'error');
	}
}

function exportExcel(){
	
	window.location.href= path +  "/user/export"
//	$.ajax({
//        url: path+"/user/export",
//        type: "post",
//        async: true,
//        beforeSend : function(){
//        	MaskUtil.mask();
//        },
//        success: function(result){
//        	MaskUtil.unmask(); 
//        	window.open(path + result);
//		}
//    });
}

function resetPwd(){
	var row = $('#datagrid').datagrid('getSelected');
	if (row){
		var id = row.id;
		$.messager.confirm("操作提示", "确定要重置该记录的密码吗?", function (data) { 
			if (data) {  
				$.ajax({
                    url: path+"/user/resetPassword",
                    data: {id:id},
                    type: "post",
                    async: true,
                    beforeSend : function(){
                    	MaskUtil.mask();
                    },
                    success: function(result){
                    	MaskUtil.unmask(); 
                    	if (result.indexOf("DOCTYPE")>=0) {
        					$(document).find("html").html(result);
        				}
        				var result = eval('('+result+')');
        				var mesTitle = "操作成功";
        				
        				if (result.success){
        					$('#datagrid').datagrid('reload'); 
        				} else {
        					 
        					mesTitle = '操作失败';
        				}
        				$.messager.show({ 
        					 title: mesTitle,
        					 msg: result.msg
        				});
        			}
                });
			}
		});
	}else{
		$.messager.alert('提示', '请选择要重置密码的记录！', 'error');
	}
}