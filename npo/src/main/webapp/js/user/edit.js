//页面加载  
$().ready(function(){ 
     $("#roleName").textbox('textbox').bind("click", function () { 
    	 roleSelect();
      });
}); 


function roleSelect(){
	$('#dlg').dialog({
		title: '角色选择',
		width: 750,
		height: 550,
		closable:true,
		resizable:true,
		closed:false,
		loadingMessage: '正在加载...',
		href:path+"/role/role_select",
		modal:true
	});
	$('#dlg').window('center');
}

function selected(){
	var row = $('#roleDatagrid').datagrid('getChecked');  
	if (row){
		var _roleIds = "";
		var _roleNames = "";
		$.each(row, function(index, item){  
			_roleIds += item.id + ",";
			_roleNames += item.name + ",";
		});
		$("#roleId").val(_roleIds);
		$("#roleName").textbox('setValue',_roleNames);
		$('#dlg').dialog('close');
	}else{
		$.messager.alert('提示', '请选择对应的业务记录！', 'error');
	}
}

//新增
function save(){
	if($('#form').form('validate')){
		var form = serializeObject($("#form").form());
		$.ajax({
			type: "POST",
	        url: path+"/user/edit",
	        contentType: 'application/json',
	        data: JSON.stringify(form),
	        dataType:"json",
	        beforeSend : function(){
	        	MaskUtil.mask(); 
	        },
	        success: function(result){
	        	MaskUtil.unmask(); 
				var mesTitle = "操作成功";
				if (result.success){
					window.location.href=path+"/user/list"; 
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
}

function FindData(){
	$('#roleDatagrid').datagrid({   
		queryParams:serializeObject($("#roleForm"))
	});  
}