$(function() {
	//获取Url中的studentId参数
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null){  
		return unescape(r[2]);
		}else{
			return null;
		}
	};

	function isContains(str, substr) {
	    return new RegExp(substr).test(str);
	};
	//init
	$(function(){
		var totalPage ;
		var totalRecords ;
		//获取当前的请求链接
		var url = window.location.href;
		var uri ;
		
		var checkStatus = getParameter('checkStauts');
		//获取uri
		if(url.indexOf("Status")>0){
			if(url.indexOf("&")>0){
				uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("&"));
			}else{
				uri = url.substring(url.lastIndexOf("/")+1);
			}	
		}else{
			if(url.indexOf("?")>0)
			{
			  uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("?"));
			}else{
			  uri = url.substring(url.lastIndexOf("/")+1);	
			}
		}
		$(document).ready(function() {		
			var studentId = $("#activity_studentId").val();
			$.ajax({
				url : "/society_server/student/activity_apply/listTotalPageByStudentId?studentId="+studentId,
				type : "get",
				success : function(result) {
					totalPage = result.resultData.totalPage;
					totalRecords = result.resultData.totalRecords;
				},
				error : function(error) {
					alert(error.resultData);
				},
				async : false
			});
			var pageNo = getParameter('pNo');
			if(!pageNo){
				pageNo = 1;
			}	
			//生成分页
			//有些参数是可选的，比如lang，若不传有默认值
			kkpager.generPageHtml({
				pno : pageNo,
				//总页码
				total : totalPage,
				//总数据条数
				totalRecords : totalRecords,
				//链接前部
				hrefFormer : uri,
				//链接尾部
				//hrefLatter : '.html',
				getLink : function(n){
					if(uri.indexOf("studentId")>0)
					{
						return this.hrefFormer + this.hrefLatter + "&pNo="+n
					}else{
						return this.hrefFormer + this.hrefLatter + "?pNo="+n;
					}
				}
			});
	});
});
	//根据审核状态查询  里面配上ajax请求
	$('#checkStatus').change(function(){ 
		//alert($(this).children('option:selected').val()); 
		//var p1=$(this).children('option:selected').val();//这就是selected的值 
		//var p2=$('#param2').val();//获取本页面其他标签的值 
		//window.location.href="xx.php?param1="+p1+"¶m2="+p2+"";//页面跳转并传参 
		}); 
	$('#addsocietyTypeForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			societyTypeName : {
				validators : {
					notEmpty : {
						message : '社团类别名称不能为空'
					},
				}
			}
		}
	});
	
	$('#updatesocietyType').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			societyTypeName : {
				validators : {
					notEmpty : {
						message : '社团类别名称不能为空'
					},
				}
			}
		}
	});
	
	$('#societyApplyFrom').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			feedBack : {
				validators : {
					notEmpty : {
						message : '反馈不能为空'
					},
				}
			}
		}
	});
	$("button.addBtn").click(function() {
		$("#addsocietyTypeModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});
	
	$("button.deleteBtn").click(function() {
		if (confirm('确定要删除此信息吗？')) {
			var id = $(this).parents("tr").find("td").eq(0).html();
			$.ajax({
				url : "/society_server/admin/societyType/deleteById?typeId=" + id,
				type : "post",
				success : function(result) {
					if (result.resultCode == 0) {
						alert("删除成功！");
						window.location.href=window.location.href; 
						window.location.reload; 
					} else {
						alert("非常抱歉 ," + result.resultData);
					}
				},
				error : function(error) {
					alert(error.resultData);
				},
				async : false
			});
			return true;
		} else {
			return false;
		}
	});
	
	//获取社团申请信息详情
	$("button.queryBtn").click(function() {
		var activityId = $(this).parents("tr").find("td").eq(0).html();
		window.location.href="/society_server/student/activity_apply/getDetail?activityId="+activityId; 
	});
	
	//反馈审核信息
	$("#submitBtn").click(function() {
		var Validator = $('#societyApplyFrom').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "/society_server/admin/society_apply/passApply",
			type : "post",
			data:  $('#societyApplyFrom').serialize(),
			success : function(data) {
				alert("审核成功!");
				window.location.href=window.location.href; 
				window.location.reload; 
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		}); 
	});
	
	//反馈审核信息
	$("#notPassBtn").click(function() {
		var Validator = $('#societyApplyFrom').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "/society_server/admin/society_apply/notPassApply",
			type : "post",
			data:  $('#societyApplyFrom').serialize(),
			success : function(data) {
				alert("审核成功!");
				window.location.href=window.location.href; 
				window.location.reload; 
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		}); 
	});
	
	// 时间
	 $(".form_datetime").datetimepicker({
		 language: 'zh-CN',
        autoclose: 1,
        todayBtn: 1,
        pickerPosition: "bottom-left",
        minuteStep: 5,
        format: 'yyyy-mm-dd',
        minView: 'month'    //日期时间选择器所能够提供的最精确的时间选择视图。
	    });
});