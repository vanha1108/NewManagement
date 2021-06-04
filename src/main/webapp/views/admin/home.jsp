<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value="/admin-home"/>">Trang chủ</a></li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <h1 style="color: #4ebc30; font-family: 'Segoe UI';">Biểu đồ tổng quan</h1>
                <canvas id="myCanvas" width="1000" height="500" style="display: block;"/>
                <script type="text/javascript">
                    $(document).ready(function () {
                        createChart();
                    });
                    function createChart() {
                        var myChart = document.getElementById("myCanvas").getContext('2d');
                        var lables = [];
                        var colors = [];
                        var values = [];
                        lables.push("Danh mục");
                        lables.push("Bài viết");
                        lables.push("Người dùng");
                        colors.push("rgba(255, 99, 132, 0.2)");
                        colors.push("rgba(75, 192, 192, 0.2)");
                        colors.push("rgba(255, 159, 64, 0.2)");
                        values.push(10);
                        values.push(25);
                        values.push(3);
                        var chart = new Chart(myChart, {
                            type: 'horizontalBar',
                            data: {
                                datasets: [{
                                    data: values,
                                    backgroundColor: colors,
                                    borderWidth: 1,
                                    borderColor: '#333'
                                }],
                                labels: lables
                            },
                            options: {
                                tooltips: {
                                    enabled: false,
                                    mode: 'nearest',
                                    intersect: true,
                                    events: ['click'],
                                    custom: function (tooltipModel) {
                                        var tooltipEl = document.getElementById('chartjs-tooltip');

                                        if (!tooltipEl) {
                                            tooltipEl = document.createElement('div');
                                            tooltipEl.id = 'chartjs-tooltip';
                                            tooltipEl.innerHTML = '<table style="background-color: #e8e1f5; border: 2px solid #a1a0a0"></table>';
                                            document.body.appendChild(tooltipEl);
                                        }

                                        if (tooltipModel.opacity === 0) {
                                            tooltipEl.style.opacity = 0;
                                            return;
                                        }

                                        tooltipEl.classList.remove('above', 'below', 'no-transform');
                                        if (tooltipModel.yAlign) {
                                            tooltipEl.classList.add(tooltipModel.yAlign);
                                        } else {
                                            tooltipEl.classList.add('no-transform');
                                        }

                                        function getBody(bodyItem) {
                                            return bodyItem.lines;
                                        }

                                        if (tooltipModel.body) {
                                            var titleLines = tooltipModel.title || [];
                                            var bodyLines = tooltipModel.body.map(getBody);

                                            var innerHtml = '<thead>';
                                            var uri = "/admin-new?type=list&page=1&maxPageItem=2&sortName=title&sortBy=DESC";

                                            titleLines.forEach(function (title) {
                                                // innerHtml += '<tr><th style="float: left">' + title + '</th></tr>';
                                                var span = '<a href="' + uri + '" style="float: left' + '">' + title + '</a>';
                                                innerHtml += span;
                                                console.log("TTT: " + title);
                                                if (title == "Danh mục") {
                                                    uri = "/admin-category?type=list";
                                                } else if (title == "Người dùng") {
                                                    uri = "/admin-user?type=list";
                                                } else {
                                                    uri = "/admin-new?type=list&page=1&maxPageItem=2&sortName=title&sortBy=DESC";
                                                }
                                            });
                                            innerHtml += '</thead><tbody>';
                                            var name;
                                            var idProduct;
                                            bodyLines.forEach(function (body, i) {
                                                var colors = tooltipModel.labelColors[i];
                                                var style = 'background: transparent';
                                                style += '; border-color:' + colors.borderColor;
                                                style += '; border-width: 2px';
                                                var span = '<a href="' + uri + '" style="' + style + '; float: left' + '">' + name + '</a>';
                                                // innerHtml += '<tr><td>' + span + '</td></tr>';
                                                innerHtml += '<tr><th style="float: left">' + 'Số lượng: ' + body + '</th></tr>';
                                            });
                                            innerHtml += '</tbody>';
                                            var tableRoot = tooltipEl.querySelector('table');
                                            tableRoot.innerHTML = innerHtml;
                                        }

                                        var position = this._chart.canvas.getBoundingClientRect();
                                        tooltipEl.style.opacity = 1;
                                        tooltipEl.style.position = 'absolute';
                                        tooltipEl.style.left = position.left + window.pageXOffset + tooltipModel.caretX + 'px';
                                        tooltipEl.style.top = position.top + window.pageYOffset + tooltipModel.caretY + 'px';
                                        tooltipEl.style.fontFamily = tooltipModel._bodyFontFamily;
                                        tooltipEl.style.fontSize = tooltipModel.bodyFontSize + 'px';
                                        tooltipEl.style.fontStyle = tooltipModel._bodyFontStyle;
                                        tooltipEl.style.padding = tooltipModel.yPadding + 'px ' + tooltipModel.xPadding + 'px';
                                    }
                                },
                                events: ["click", "mousemove"],
                                responsive: false,
                                maintainAspectRatio: false,
                                title: {
                                    display: true,
                                },
                                legend: {
                                    display: false,
                                },
                                scales: {
                                    yAxes: [{
                                        display: true,
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Tổng quan',
                                            fontStyle: 'bold',
                                            fontColor: '#FF0000'
                                        }
                                    }],
                                    xAxes: [{
                                        display: true,
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Số lượng',
                                            fontStyle: 'bold',
                                            fontColor: '#FF0000'
                                        }
                                    }]
                                }
                            }
                        });
                    }
                </script>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.2/Chart.bundle.js">

    function createChart() {
        console.log("RUN CHART");
        var myChart = document.getElementById("myCanvas").getContext('2d');
        var lables = [];
        var colors = [];
        var values = [];
        lables.push("Category");
        lables.push("New");
        lables.push("User");
        colors.push("rgba(22, 234, 11, 0.6)");
        colors.push("rgba(22, 234, 11, 0.8)");
        colors.push("rgba(22, 234, 13, 0.6)");
        values.push(10);
        values.push(25);
        values.push(3);
        var chart = new Chart(myChart, {
            type: 'bar',
            data: {
                datasets: [{
                    data: values,
                    backgroundColor: colors,
                    borderWidth: 1,
                    borderColor: '#333'
                }],
                labels: lables
            },
            options: {
                tooltips: {
                    enabled: false,
                    mode: 'nearest',
                    intersect: true,
                },
                responsive: true,
                maintainAspectRatio: false,
                title: {
                    display: true,
                },
                legend: {
                    display: false,
                }
            }
        });
    }
</script>
<!-- /.main-content -->
</body>
</html>