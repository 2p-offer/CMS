$(function () {

    $("#submitExcel").on("click", function () {
        $.ajax({
            cache: true,
            contentType:"multipart/form-data",
            type: "POST",
            url: "/analysis/test/uploadExcel",
            data: $('#excelFile').serialize(),// 你的formid
            async: false,
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    alert("上传成功");
                } else {

                    alert("上传失败");
                }

            }
        });
    });
});