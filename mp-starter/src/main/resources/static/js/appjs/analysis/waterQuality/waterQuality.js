var prefix = "/analysis/waterQuality";
$(function() {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                showRefresh : true,
                // showToggle : true,
                // showColumns : true,
                iconSize: 'outline',
                toolbar: '#toolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                showColumns: true, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者
                // "server"
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset
                    };
                },
                showExport: true,  //是否显示导出按钮
                buttonsAlign:"right",  //按钮位置
                exportTypes:['excel'],  //导出文件类型
                Icons:'glyphicon-export',
                exportOptions:{
                    ignoreColumn: [0,1],  //忽略某一列的索引
                    fileName: '水质指标',  //文件名称设置
                    worksheetName: 'sheet1',  //表格工作区名称
                    tableName: '水质指标',
                    excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                },
                columns : [
                    {
                        checkbox : true
                    },
                    {
                        field : 'id', // 列字段名
                        title : '序号' // 列标题
                    },
                    {
                        field : 'ph',
                        title : 'ph'
                    },
                    {
                        field : 'dissolvedoxygen',
                        title : '溶解氧'
                    },
                    {
                        field : 'conductivity',
                        title : '电导率'
                    },
                    {
                        field : 'turbidity',
                        title : '浊度'
                    },
                    {
                        field : 'temperature',
                        title : '温度'
                    },
                    {
                        field : 'salinity',
                        title : '盐度',
                        align : 'center'
                    },
                    {
                        field : 'ammonianitrogen',
                        title : '氨氮',
                        align : 'center'                    },
                    {
                        field : 'totalphosphorus',
                        title : '总磷',
                        align : 'center'

                    },
                    {
                        field : 'totalnitrogen',
                        title : '总氮 ',
                        align : 'center'

                    },
                    {
                        field : 'kmno4',
                        title : '高锰酸钾',
                        align : 'center'

                    },
                    {
                        field : 'k',
                        title : '钾离子'
                    },
                    {
                        field : 'ca',
                        title : '钙离子'
                    },
                    {
                        field : 'na',
                        title : '钠离子'
                    },
                    {
                        field : 'mg',
                        title : '镁离子'
                    },
                    {
                        field : 'cl',
                        title : '氯离子'
                    },
                    {
                        field : 'so4',
                        title : '硫酸根离子'
                    },
                    {
                        field : 'no3',
                        title : '硝酸根离子'
                    },
                    {
                        field : 'co3',
                        title : '碳酸根离子'
                    },
                    {
                        field : 'doc',
                        title : 'doc'
                    },
                    {
                        field : 'shen',
                        title : '砷'
                    },
                    {
                        field : 'ge2',
                        title : '镉'
                    },
                    {
                        field : 'tong',
                        title : '铜'
                    },
                    {
                        field : 'qian',
                        title : '铅'
                    },
                    {
                        field : 'xin',
                        title : '锌'
                    },
                    {
                        field : 'nie',
                        title : '镍'
                    },
                    {
                        field : 'ge4',
                        title : '铬'
                    },
                    {
                        field : 'gai',
                        title : '钙'
                    },
                    {
                        field : 'mei',
                        title : '镁'
                    },
                    {
                        field : 'tie',
                        title : '铁'
                    },
                    {
                        field : 'lv',
                        title : '铝'
                    },
                    {
                        field : 'quandan',
                        title : '全氮'
                    },
                    {
                        field : 'quanlin',
                        title : '全磷'
                    },
                    {
                        field : 'quanliu',
                        title : '全硫'
                    },
                    {
                        field : 'warning',
                        title : '预警值'
                    },
                    {
                        field : 'uptime',
                        title : '时间',
                        align : 'center'

                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {

                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';

                            return d;
                        }
                    } ]
            });
}

//转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}
function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['userId'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {});
}


function showCharts() {
    layer.open({
        title: '水质指标图表',
        type: 2,
        shade: false,
        area: ['800px', '550px'],
        shadeClose: false,
        //点击遮罩关闭
        content: prefix + "/showCharts"
    });
}