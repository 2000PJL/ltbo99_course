layui.use('table', function () {
    let $ = layui.jquery,
        table = layui.table,
        form = layui.form

    table.render({
        elem: '#dataList',
        id: 'dataList',
        url: '/data/list', //数据接口
        toolbar: "#toolbar",
        limit: 15,
        initSort: {
            field: 'id',
            type: 'desc'
        },
        skin: 'line',
        page: {
            // layout: ['prev', 'page', 'next', 'count', 'limit', 'refresh', 'skip'],
            limits: [5, 10, 15, 20],
        },
        where: {
            // sno: '',
            // sip: '',
            // type: '',
            // success: ''
        },
        cols: [[//表头
            // {
            //     checkbox: true,
            //     fixed: 'left'
            // },
            {
                field: 'id',
                title: '编号',
                minWidth: 10
            },
            {
                field: 'temp',
                title: '温度',
                templet: function (d) {
                    return d.temp + "℃";
                }
            },
            {
                field: 'hum',
                title: '湿度',
                templet: function (d) {
                    return d.hum + "%";
                }
            },
            {
                field: 'light',
                title: '光照',
                templet: function (d) {
                    return d.light + "mV";
                }
            },
            {
                field: 'soil',
                title: '土壤',
                templet: function (d) {
                    return d.soil + "mV";
                }
            },
            {
                field: 'sound',
                title: '声音',
                templet: function (d) {
                    return d.sound + "mV";
                }
            },
            {
                field: 'area',
                title: '区域',
                minWidth: 180
            },
            {
                field: 'ip',
                title: 'IP地址',
            },
            {
                field: 'collTime',
                title: '采集时间',
            }
        ]]
    });


    /*监听搜索按钮*/
    form.on('submit(searchBtn)', function (data) {
        table.reload('dataList', {
            url: '/data/list',
            where: {
            },
            curr: 1
        });
        return false;
    });
    /*监听重置按钮*/
    form.on('submit(clearBtn)', function () {
        table.reload('dataList', {
            url: '/data/list',
            where: {
            },
            page: {
                curr: 1
            }
        });
    });

    setInterval(function () {
        $("#reset").click();
    }, 5000);

});

