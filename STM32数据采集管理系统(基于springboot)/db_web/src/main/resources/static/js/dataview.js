/**基于准备好的dom，初始化echarts实例*/
var myChart = echarts.init(document.getElementById('main'));
var lightChart = echarts.init(document.getElementById('light'));



function test() {
    var data;
    $.ajax({
        url: '/getCollDataList',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            /**温度*/
            var temp = [];
            /**湿度*/
            var hum = [];
            /**采集时间*/
            var collTime = [];
            /**光照强度*/
            var light = [];
            /**获取温度打包为数组*/
            for (i in data)
                temp.push(data[i].temp);
            console.log(temp);

            /**获取温度打包为数组*/
            for (i in data)
                light.push(data[i].light);
            console.log(light);
            /**获取湿度打包为数组*/
            for (i in data)
                hum.push(data[i].hum);
            console.log(hum);

            for (i in data)
                collTime.push(data[i].collTime);
            console.log(collTime);

            /**指定图表的配置项和数据*/
            option = {
                title: {
                    text: '温湿度动态图',
                    subtext: '数据采集时间 ' + writeCurrentDate(),
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['温度', '湿度']
                },
                grid: {
                    left: '10%',
                    right: '10%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    data: collTime,
                    name: '采集时间'
                },
                yAxis: {
                    type: 'value',
                    name: '温湿度'
                },
                series: [
                    {
                        name: '温度',
                        type: 'line',
                        stack: '总量',
                        data: temp
                    },
                    {
                        name: '湿度',
                        type: 'line',
                        stack: '总量',
                        data: hum
                    }
                ]
            };

            /**使用刚指定的配置项和数据显示图表*/
            myChart.setOption(option);
        }})}
setInterval("test()",2000);

    function test1() {
        console.log(data);
        /**温度*/
        var temp = [];
        /**湿度*/
        var hum = [];
        /**采集时间*/
        var collTime = [];
        /**光照强度*/
        var light = [];
        /**获取温度打包为数组*/
        for (i in data)
            temp.push(data[i].temp);
        console.log(temp);

        /**获取温度打包为数组*/
        for (i in data)
            light.push(data[i].light);
        console.log(light);
        /**获取湿度打包为数组*/
        for (i in data)
            hum.push(data[i].hum);
        console.log(hum);

        for (i in data)
            collTime.push(data[i].collTime);
        console.log(collTime);

        var data;
        $.ajax({
            url: '/getCollDataList',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                option = {
                    color: ['#ff5500'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    legend: {
                        data: ['光照强度']
                    },
                    grid: {
                        left: '10%',
                        right: '10%',
                        bottom: '3%',
                        containLabel: true
                    },
                    title: {
                        text: '光照强度动态图',
                        subtext: '数据采集时间 ' + writeCurrentDate(),
                    },
                    xAxis: {
                        type: 'category',
                        data: collTime,
                        name: '序号'
                    },
                    yAxis: {
                        type: 'value',
                        name: '光照强度'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    series: [{
                        data: light,
                        type: 'bar',
                        smooth: true
                    }]
                };
                lightChart.setOption(option);
            }
        })
    }
setInterval("test1()",2000);

function writeCurrentDate() {
    var now = new Date();
    var year = now.getFullYear(); //得到年份
    var month = now.getMonth();//得到月份
    var date = now.getDate();//得到日期
    var day = now.getDay();//得到周几
    var hour = now.getHours();//得到小时
    var minu = now.getMinutes();//得到分钟
    var sec = now.getSeconds();//得到秒
    var MS = now.getMilliseconds();//获取毫秒
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    if (MS < 100) MS = "0" + MS;
    var arr_week = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;
    //当前日期赋值给当前日期输入框中（jQuery easyUI）
    return time;
}


