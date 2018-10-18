$().ready(function() {

	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
		callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		save(1);
	}
});
function save(status) {
	$("#status").val(status);
	var productContent_sn = $("#productContent").summernote('code');
	$("#productContent").val(productContent_sn);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/urcs/wkf/product/save",
		data : $('#productUpForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg(r.msg);
				parent.reLoad();
				$("#cid").val(r.pid);

			} else {
				parent.layer.alert(r.msg)
			}
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            productKindId : "required",
            productName : "required",
            productPrice : "required",
            productContent : "required"
		},
		messages : {
            productKindId : "请填写商品类别",
            productName : "请填写商品名称",
            productPrice : "请填写商品价格",
            productContent1 : "请填写商品介绍"
		}
	});
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}