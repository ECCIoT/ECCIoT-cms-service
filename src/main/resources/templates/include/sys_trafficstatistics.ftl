<script src="../echarts/echarts.min.js"></script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>流量统计</legend>
</fieldset>

<div id="main" style="float:left;width:${charts_width!'800'}px;height:${charts_height!'350'}px;margin-left: 30px">
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        //                    // 指定图表的配置项和数据
        //                    // Schema:
        //                    // date,AQIindex,PM2.5,PM10,CO,NO2,SO2
        //                    var app1 = [
        //                        [1,0.6,0.4,0.7,0.3,0.2,0.8]
        //                    ];
        //
        //                    var lineStyle = {
        //                        normal: {
        //                            width: 1,
        //                            opacity: 0.5
        //                        }
        //                    };
        //
        //                    option = {
        //                        backgroundColor: '#FFFFFFFF',
        //                        title: {
        //                            text: '应用通信比率雷达图',
        //                            left: 'center',
        //                            textStyle: {
        //                                color: '#000000'
        //                            }
        //                        },
        //                        legend: {
        //                            bottom: 5,
        //                            data: ['APP01'],
        //                            itemGap: 20,
        //                            textStyle: {
        //                                color: '#202020',
        //                                fontSize: 14
        //                            },
        //                            selectedMode: 'single'
        //                        },
        //                        radar: {
        //                            indicator: [
        //                                {name: 'CLOUD', max: 1},
        //                                {name: 'DTR', max: 1},
        //                                {name: 'DRR', max: 1},
        //                                {name: 'CTR', max: 1},
        //                                {name: 'CRR', max: 1},
        //                                {name: 'STR', max: 1},
        //                                {name: 'SRR', max: 1}
        //                            ],
        //                            shape: 'circle',
        //                            splitNumber: 5,
        //                            name: {
        //                                textStyle: {
        //                                    color: 'rgb(50, 40, 20)'
        //                                }
        //                            },
        //                            splitLine: {
        //                                lineStyle: {
        //                                    color: [
        //                                        'rgba(60, 30, 20, 0.1)',
        //                                        'rgba(60, 30, 20, 0.2)',
        //                                        'rgba(60, 30, 20, 0.4)',
        //                                        'rgba(60, 30, 20, 0.6)',
        //                                        'rgba(60, 30, 20, 0.8)',
        //                                        'rgba(60, 30, 20, 1)'
        //                                    ].reverse()
        //                                }
        //                            },
        //                            splitArea: {
        //                                show: false
        //                            },
        //                            axisLine: {
        //                                lineStyle: {
        //                                    color: 'rgba(238, 197, 102, 0.5)'
        //                                }
        //                            }
        //                        },
        //                        series: [
        //                            {
        //                                name: 'APP01',
        //                                type: 'radar',
        //                                lineStyle: lineStyle,
        //                                data: app1,
        //                                symbol: 'none',
        //                                itemStyle: {
        //                                    normal: {
        //                                        color: '#FF6060'
        //                                    }
        //                                },
        //                                areaStyle: {
        //                                    normal: {
        //                                        opacity: 0.25
        //                                    }
        //                                }
        //                            }
        //                        ]
        //                    };

        option = {
            title: {
                text: 'ECC - 流量统计',
                subtext: '数据虚构'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            toolbox: {
                show: true,
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis:  {
                type: 'category',
                boundaryGap: false,
                data: ['00:00', '01:15', '02:30', '03:45', '05:00', '06:15', '07:30', '08:45', '10:00', '11:15', '12:30', '13:45', '15:00', '16:15', '17:30', '18:45', '20:00', '21:15', '22:30', '23:45']
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value}'
                },
                axisPointer: {
                    snap: true
                }
            },
            visualMap: {
                show: false,
                dimension: 0,
                pieces: [{
                    lte: 6,
                    color: 'green'
                }, {
                    gt: 6,
                    lte: 8,
                    color: 'red'
                }, {
                    gt: 8,
                    lte: 14,
                    color: 'green'
                }, {
                    gt: 14,
                    lte: 17,
                    color: 'red'
                }, {
                    gt: 17,
                    color: 'green'
                }]
            },
            series: [
                {
                    name:'通信次数',
                    type:'line',
                    smooth: true,
                    data: [300, 280, 250, 260, 270, 300, 550, 500, 400, 390, 380, 390, 400, 500, 600, 750, 800, 700, 600, 400],
                    markArea: {
                        data: [ [{
                            name: '高峰期A',
                            xAxis: '07:30'
                        }, {
                            xAxis: '10:00'
                        }], [{
                            name: '高峰期B',
                            xAxis: '17:30'
                        }, {
                            xAxis: '21:15'
                        }] ]
                    }
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</div>