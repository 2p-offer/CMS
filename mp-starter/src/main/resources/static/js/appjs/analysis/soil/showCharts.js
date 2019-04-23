var prefix = "/analysis/soil"
var xData = [];
var dataName = [];
var data=[];
var data1=[];
var valData=[];
var str=[];
$(function () {
    getdata ();
});

function getdata(){
    $.ajax({
        url: prefix + "/showChartsData",
        type:"GET",
        success:function (res) {

            var dataFirst=res[0]
            //得到legend的数组
            for(var key in dataFirst){
                dataName.push(key)
            }
            //去掉最后一个日期属性
            dataName.pop()

            //创建每条数据的data数组
            for(var k=0;k<dataName.length;k++){
                str[k]=new Array();
                str.push(str[k])
            }
//               console.log(dataName)
            //得到x轴数据
            for(var i=0;i<res.length;i++){
                xData.push(res[i].uptime)
            }
            //判断同一属性的数据，并将其放入数组中
            for(var i=0;i<res.length-1;i++){
                if(i!=res.length-2){
                    objValEqu(res[i],res[i+1])
                }
                else {
                    objValEqus(res[i],res[i+1]);
                }
            }
            console.log(xData)
            var theStr;
            for(var i=0;i<dataName.length;i++){
                theStr='{"name":'+'"'+dataName[i]+'"'+","+'"type":"line",'+'"data":'+"["+str[i]+"]}";
                console.log(theStr)
                data.push(JSON.parse(theStr))
                console.log(data)
            }
            var mychart=echarts.init(document.getElementById("charts"));
            mychart.setOption(option,xData,dataName,data);
        }
    })

}

function show() {
    var option = {
        title: {
            text: '未来一周气温变化',
            subtext: '纯属虚构'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['湿地植物', '浮游植物', '浮游动物', '底栖生物', '鱼类']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    formatter: '{value} °C'
                }
            }
        ],
        series: [
            {
                name: '最高气温',
                type: 'line',
                data: [11, 11, 15, 13, 12, 13, 10],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '最低气温',
                type: 'line',
                data: [1, -2, 2, 5, 3, 2, 0],
                markPoint: {
                    data: [
                        {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }
        ]
    };

    var container= echarts.init(document.getElementById('charts'));
    container.setOption(option);
}






function objValEqu(a,b) {
//得到两个对象的属性名,结果为数组
    var aprop=Object.getOwnPropertyNames(a);
    aprop.pop();
    var bprop=Object.getOwnPropertyNames(b);
    bprop.pop()
    if(aprop.length!=bprop.length){
        return false;
    }
    //将属性名相同的属性值放入同一数组
    for(var i=0;i<aprop.length;i++){
        if(aprop[i]==bprop[i]){
//             str[i]=new Array();
            str[i].push(a[aprop[i]]);
        }

    }
}
//比较最后两个对象的属性
function objValEqus(a,b) {
    var aprop=Object.getOwnPropertyNames(a);
    aprop.pop();
    var bprop=Object.getOwnPropertyNames(b);
    bprop.pop()
    if(aprop.length!=bprop.length){
        return false;
    }
    //将属性名相同的属性值放入同一数组
    for(var i=0;i<aprop.length;i++){
        if(aprop[i]==bprop[i]){
            str[i].push(a[aprop[i]],b[bprop[i]]);
        }

    }
}


var option = {
    title: {
        text: '图表展示'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:dataName
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: xData
    },
    yAxis: {
        type: 'value'
    },
    series:data
};