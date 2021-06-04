<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
</head>
<body>
<div id="wrapper">
    <section class="section">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-wrapper">
                        <div class="blog-top clearfix">
                            <h4 class="pull-left">Tin mới đăng <a><i class="fa fa-rss"></i></a></h4>
                        </div>

                        <div class="blog-list clearfix">
                            <c:forEach var="item" items="${listNew}">
                                <div class="blog-box row">
                                    <div class="col-md-4">
                                        <div class="post-media">
                                            <a href='<c:url value="/chi-tiet?id=${item.id}"/>'>
                                                <img src="${item.thumbnail}" alt="" class="img-fluid">
                                                <div class="hovereffect"></div>
                                            </a>
                                        </div><!-- end media -->
                                    </div><!-- end col -->

                                    <div class="blog-meta big-meta col-md-8">
                                        <h4><a href='<c:url value="/chi-tiet?id=${item.id}"/>'>${item.title}</a></h4>
                                        <p>${item.shortDescription}</p>
                                        <small class="firstsmall"><a class="bg-orange" href='<c:url value="/danh-muc?type=list&id=${item.categoryId}"/>' title="">${item.categoryName}</a></small>
                                        <small><a href='<c:url value="/chi-tiet?id=${item.id}"/>'>${item.disCreateDate}</a></small>
                                        <small><a href='<c:url value="/chi-tiet?id=${item.id}"/>'><i class="fa fa-eye"></i>${item.viewClick}</a></small>
                                    </div>
                                </div>

                                <hr class="invis">
                            </c:forEach>
                        </div>

                    </div>

                    <hr class="invis">

                    <div class="row">
                        <div class="col-md-12">
                            <nav aria-label="Page navigation">
                                <ul class="pagination justify-content-start">
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                    <div class="sidebar">
                        <div class="widget">
                            <div class="banner-spot clearfix">
                                <div class="banner-img">
                                    <img src='<c:url value="/template/web/upload/5k.png"/>' class="img-fluid">
                                </div>
                            </div>
                        </div>

                        <div class="widget">
                            <h2 class="widget-title">Quan tâm</h2>
                            <div class="trend-videos">
                                <c:forEach var="best" items="${topNew}">
                                <div class="blog-box">
                                    <div class="post-media">
                                        <a href='<c:url value="/chi-tiet?id=${best.id}"/>'>
                                            <img src="${best.thumbnail}" class="img-fluid">
                                            <div class="hovereffect"></div>
                                        </a>
                                    </div>
                                    <div class="blog-meta">
                                        <h4><a href='<c:url value="/chi-tiet?id=${best.id}"/>'>${best.title}</a></h4>
                                    </div>
                                </div>
                                <hr class="invis">
                                </c:forEach>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>