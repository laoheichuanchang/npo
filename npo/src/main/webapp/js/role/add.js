//页面加载  
$().ready(function(){  
     loadGrid();
     $("#orgName").textbox('textbox').bind("click", function () { 
    	 orgSelect();
      });
}); 


function orgSelect(){
	$('#dlg').dialog({
		title: '组织选择',
		width: 750,
		height: 550,
		closable:true,
		resizable:true,
		closed:false,
		loadingMessage: '正在加载...',
		href:path+"/org/org_select",
		modal:true
	});
	$('#dlg').window('center');
}

function selected(){
	var row = $('#orgTreegrid').datagrid('getSelected');
	if (row){
		$("#orgId").val(row.id);
		$("#orgName").textbox('setValue',row.name);
		$('#dlg').dialog('close');
	}else{
		$.messager.alert('提示', '请选择对应的业务记录！', 'error');
	}
}


//加载表格datagrid  
function loadGrid()  
{  
    //加载数据  
    $('#datagrid').treegrid({   
        url:path+'/resource/menuList',
        loadMsg:'数据加载中请稍后……',
        queryParams: { 'id': _roleId },
        nowrap:false,
        fitColumns:true,
        rownumbers:true,
        scrollbarSize:0,
        idField:'id',
        treeField:'name',
        columns:[[
            {field:'name',title: '资源名称',align: 'center',width:'280'},
            {field:'sysPermissions',title: '权限配置',align: 'center',width:'800',formatter:formatPermissions}
        ]]  
    });
}

function formatPermissions(value,row,index) {
	  if(null != value){
		 var _permissions = "";
		 $.each(value,function(n,data){
			 if(data.checked){
				 _permissions += '<input type="checkbox"  name="permissions" '+ readonly +' checked="checked" value="'+data.id+'-'+data.resId+'">'+data.name+'</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
			 }else{
			     _permissions += '<input type="checkbox"  name="permissions" '+ readonly +' value="'+data.id+'-'+data.resId+'">'+data.name+'</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
			 }
	     });
		 return _permissions;
	  }
}

//新增
function save(){
	if($('#form').form('validate')){
		var form = serializeObject($("#form").form());
		var permissions = $('input:checkbox[name=permissions]:checked').map(function(){return this.value}).get().join(',');
		form["permissions"] = permissions;
		$.ajax({
			type: "POST",
	        url: path+"/role/edit",
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
					window.location.href=path+"/role/list"; 
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