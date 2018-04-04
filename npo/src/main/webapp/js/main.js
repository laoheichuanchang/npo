//tip是提示信息，type:'success'是成功信息，'danger'是失败信息,'info'是普通信息,'warning'是警告信息
function showTip(tip, type) {
    var $tip = $('#tip');
    $tip.stop(true).prop('class', 'alert alert-' + type).text(tip).css('margin-left', - $tip.outerWidth() / 2).fadeIn(500).delay(2000).fadeOut(500);

};

/**
 * 判断开始字符是否是XX
 * @author zh
 */
$.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};

function serializeJson(form){
    var jsonData1 = {};
    var serializeArray = form.serializeArray();
    $(serializeArray).each(function () {
        if (jsonData1[this.name]) {
            if ($.isArray(jsonData1[this.name])) {
                jsonData1[this.name].push(this.value);
            } else {
                jsonData1[this.name] = [jsonData1[this.name], this.value];
            }
        } else {
            jsonData1[this.name] = this.value;
        }
    });
    // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
    var vCount = 0;
    // 计算json内部的数组最大长度
    for(var item in jsonData1){
        var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
        vCount = (tmp > vCount) ? tmp : vCount;
    }

    if(vCount > 1) {
        var jsonData2 = new Array();
        for(var i = 0; i < vCount; i++){
            var jsonObj = {};
            for(var item in jsonData1) {
                jsonObj[item] = jsonData1[item][i];
            }
            jsonData2.push(jsonObj);
        }
        return JSON.stringify(jsonData2);
    }else{
        return "[" + JSON.stringify(jsonData1) + "]";
    }
};
//将表单序列化
function serializeObject(form){
    var o={};
    var serializeArray = form.serializeArray();
    $(serializeArray).each(function () {
        if (o[this.name]) {
            if ($.isArray(o[this.name])) {
                o[this.name].push(this.value);
            } else {
                o[this.name] = o[this.name] , this.value;
            }
        } else {
            o[this.name] = this.value;
        }
    });
//    $.each(form.serializeArray(),function(index){
//              if(o[this['name'] ]){
//                   o[this['name'] ] = o[this['name'] ] + "," + this['value'];
//               }else{
//                  o[this['name'] ]=this['value'];
//               }
//     });
     return o;
} 

var MaskUtil = (function(){  
    
    var $mask,$maskMsg;  
       
    var defMsg = '正在处理，请稍待。。。';  
       
    function init(){  
        if(!$mask){  
            $mask = $("<div class=\"datagrid-mask mymask\"></div>").appendTo("body");  
        }  
        if(!$maskMsg){  
            $maskMsg = $("<div class=\"datagrid-mask-msg mymask\">"+defMsg+"</div>")  
                .appendTo("body").css({'font-size':'12px'});  
        }  
           
        $mask.css({width:"100%",height:$(document).height()});  
           
        var scrollTop = $(document.body).scrollTop();  
           
        $maskMsg.css({  
            left:( $(document.body).outerWidth(true) - 190 ) / 2  
            ,top:( ($(window).height() - 45) / 2 ) + scrollTop  
        });   
                   
    }  
       
    return {  
        mask:function(msg){  
            init();  
            $mask.show();  
            $maskMsg.html(msg||defMsg).show();  
        }  
        ,unmask:function(){  
            $mask.hide();  
            $maskMsg.hide();  
        }  
    }  
       
}());

//获取当前浏览器类型
function myBrowser(){
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isOpera = userAgent.indexOf("Opera") > -1;
    if (isOpera) {
        return "Opera"; //判断是否Opera浏览器
    }; 
    if (userAgent.indexOf("Firefox") > -1) {
        return "FF"; //判断是否Firefox浏览器
    } 
    if (userAgent.indexOf("Chrome") > -1){
    	return "Chrome";  //判断是否google浏览器
    }
    if (userAgent.indexOf("Safari") > -1) {
        return "Safari"; //判断是否Safari浏览器
    } 
    if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
        return "IE"; //判断是否IE浏览器
    }; 
}

/***文件上传***/
function ajaxFileUpload(fileId,hiddenName) {
	var max_size= 2 * 1024 * 1024 * 25 * 4; //20MB
	var obj_file = document.getElementById(fileId);
	var filesize = 0;
	fileSize = obj_file.files[0].size;
	if(fileSize>max_size){
	    $.messager.alert('提示', '图片不能超过20MB!', 'info');  
	    $("#"+fileId+"").val="";
    }else{
	    $.ajaxFileUpload({
	    	url: path+"/common/fileUpload?fileId="+fileId, //fileId参数对应控件file的ID名称
			//用于文件上传的服务器端请求地址
			secureuri : false, //一般设置为false
			fileElementId : fileId, //文件上传空间的id属性  <input type="file" id="id_file" name="file" />
			type : 'post',
			dataType : 'json', //返回值类型 一般设置为json HTML
			success : function(data, status) //服务器成功响应处理函数
			{
				var mesTitle = "文件上传成功";
				if (data.success){
					var filePatch = data.obj;
					$("#"+hiddenName+"").val(filePatch);//设置hidden文件路径，提交form用
					//针对谷歌浏览器，未显示文件名称bug处理
					var mb = myBrowser();
					if ("Chrome" == mb) {
//					    var fileName = filePatch.split("\\")[1];
						var fileName = data.msg
						$("#"+fileId+"_fileName").html("(文件名："+fileName+")");
					}
					//显示上传后是图片
					var fileViewPath = $("#fileViewPath").val();
					$("#"+hiddenName+"_img").attr('src',fileViewPath+filePatch); 
					$("#"+hiddenName+"_img").css("height", 200);
					$("#"+hiddenName+"_img").css("width", 200);
				} else {
					mesTitle = '文件上传失败';
				}
				$.messager.show({ 
					 title: mesTitle,
					 msg: "文件已上传成功"
				});
			},
			error : function(data, status,e)//服务器响应失败处理函数
			{
				$.messager.alert('提示', e, 'error');  
			}
		})
		return false;
    }
}


/**
 * 选择银行
 * 
 * @param obj
 */
function showSelectBank(obj){
	obj = $.extend(true,{
		//竖线或逗号隔开
		selectedBanks:'',
		selected: function(array){
			return true;
		},
		closed: function(){
			return true;
		},
		chkStyle: 'checkbox',
		includeHeadquarters: false
	},obj);
	var url = path+"/common/bank-openpage?includeHeadquarters="+obj.includeHeadquarters+"&chkStyle="+obj.chkStyle+"&existIncludeBanks="+obj.selectedBanks;
	//top.$.jBox("iframe:"+path+"/common/bank-openpage?includeHeadquarters="+obj.includeHeadquarters+"&chkStyle="+obj.chkStyle+"&existIncludeBanks="+obj.selectedBanks, 
	top.$.jBox("iframe:"+url,
			{
			    title: "银行选择",
			    width: 750,
			    height: 550,
			    buttons: {
			    	'确定': 1,
			    	'关闭': 0
			    },
			    /* 点击状态按钮后的回调函数，返回true时表示关闭窗口，参数有三个，v表示所点的按钮的返回值，h表示窗口内容的jQuery对象，f表示窗口内容里的form表单键值 */
			    submit: function (v, h, f) {
			    	if(v == 0){
			    		return true;
			    	}
			    	var doc = h.find("iframe")[0].contentWindow.document;
					var banks = $('input[name="selbank"]:checked', doc);
					var array = new Array();
					banks.each(function(){
						var bank = {bankCode: this.value, bankName: $(this).attr("whname")}
						array.push(bank);
					});
					
					var selected = obj.selected;
			    	if(typeof(selected) == 'function'){
			    		var result = selected(array);
			    		if(typeof(result) == 'undefined'){
			    			return true;
			    		}
			    		else if(typeof(result) == 'boolean'){
			    			return result;
			    		}
			    		else if(typeof(result) == 'number'){
			    			return result > 0;
			    		}
			    	}
			    	return true;
			    },
			    closed : function () {
					if(typeof(closed) == 'function'){
						closed();
					}
				}
			}
	);
};

/*
 * 图片弹出DIV层
*/
function showDiv(Idiv,mou_head)
{
	var Idiv = document.getElementById(Idiv);
	var mou_head = document.getElementById(mou_head);
	Idiv.style.display = "block";
	//以下部分要将弹出层居中显示
	Idiv.style.left=(document.documentElement.clientWidth-Idiv.clientWidth)/2+document.documentElement.scrollLeft+"px";
	Idiv.style.top =(document.documentElement.clientHeight-Idiv.clientHeight)/2+document.documentElement.scrollTop-50+"px";
	 
	//以下部分使整个页面至灰不可点击
	var procbg = document.createElement("div"); //首先创建一个div
	procbg.setAttribute("id","mybg"); //定义该div的id
	procbg.style.background = "#000000";
	procbg.style.width = "100%";
	procbg.style.height = "100%";
	procbg.style.position = "fixed";
	procbg.style.top = "0";
	procbg.style.left = "0";
	procbg.style.zIndex = "500";
	procbg.style.opacity = "0.6";
	procbg.style.filter = "Alpha(opacity=70)";
	//背景层加入页面
	document.body.appendChild(procbg);
	document.body.style.overflow = "hidden"; //取消滚动条
 
	//以下部分实现弹出层的拖拽效果
	var posX;
	var posY;
	mou_head.onmousedown=function(e)
	{
		if(!e) e = window.event; //IE
		posX = e.clientX - parseInt(Idiv.style.left);
		posY = e.clientY - parseInt(Idiv.style.top);
		document.onmousemove = mousemove;
	}
	document.onmouseup = function()
	{
		document.onmousemove = null;
	}
	function mousemove(ev)
	{
		if(ev==null) ev = window.event;//IE
		Idiv.style.left = (ev.clientX - posX) + "px";
		Idiv.style.top = (ev.clientY - posY) + "px";
	}
}
//关闭图片弹出层
function closeDiv(Idiv) 
{
	var Idiv=document.getElementById(Idiv);
	Idiv.style.display="none";
	document.body.style.overflow = "auto"; //恢复页面滚动条
	var body = document.getElementsByTagName("body");
	var mybg = document.getElementById("mybg");
	body[0].removeChild(mybg);
}

/*** 代理商info选择 start***/
function agentSelect(){
	$('#dlgAgent').dialog({
		title: '代理商选择',
		width: 750,
		height: 550,
		closable:true,
		resizable:true,
		closed:false,
		loadingMessage: '正在加载...',
		href:path+"/common/agent_select",
		modal:true
	});
	$('#dlgAgent').window('center');
}
function selectedAgent(){
	var row = $('#agentInfoDatagrid').datagrid('getSelected');
	if (row){
		$("#agentCode").val(row.agentNo);
		$("#agentId").val(row.id);
		$("#agentName").textbox('setValue',row.agentName);
		$('#dlgAgent').dialog('close');
	}else{
		$.messager.alert('提示', '请选择对应的代理商信息！', 'error');
	}
}
/*** 代理商选择 end***/

/*** 商户info选择 start***/
function merchantSelect(){
	$('#dlgMerchant').dialog({
		title: '商户选择',
		width: 750,
		height: 550,
		closable:true,
		resizable:true,
		closed:false,
		loadingMessage: '正在加载...',
		href:path+"/common/merchant_select",
		modal:true
	});
	$('#dlgMerchant').window('center');
}
function selectedMerchant(){
	var row = $('#merchantInfoDatagrid').datagrid('getSelected');
	if (row){
		$("#subjectCode").val(row.merchantNo);
		$("#subjectId").val(row.id);
		if($("#balance") != undefined){
			if(undefined==row.balance || null==row.balance || ""==row.balance){
				$("#balance").textbox("setValue", '0.00');
			}else{
				$("#balance").textbox("setValue", parseFloat(row.balance).toFixed(2));	
			}
		}
		$("#merchantName").textbox('setValue',row.merchantName);
		$('#dlgMerchant').dialog('close');
	}else{
		$.messager.alert('提示', '请选择对应的商户信息！', 'error');
	}
}
/*** 商户选择 end***/