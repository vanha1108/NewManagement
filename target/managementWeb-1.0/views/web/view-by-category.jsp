<%--
  Created by IntelliJ IDEA.
  User: DEV
  Date: 6/1/2021
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${model.categoryName}</title>
</head>
<body>
<div class="page-title lb single-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <h2><i class="fa fa-star bg-orange"></i> ${model.categoryName}</h2>
            </div><!-- end col -->
            <div class="col-lg-4 col-md-4 col-sm-12 hidden-xs-down hidden-sm-down">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href='<c:url value="/trang-chu"/>'>Trang chủ</a></li>
                    <li class="breadcrumb-item active">${model.categoryName}</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<section class="section">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                <div class="page-wrapper">
                    <div class="blog-list clearfix">
                        <c:forEach var="item" items="${model.listResult}">
                            <div class="blog-box row">
                                <div class="col-md-4">
                                    <div class="post-media">
                                        <a href='<c:url value="/chi-tiet?id=${item.id}"/>'>
                                            <img src="${item.thumbnail}" alt="" class="img-fluid">
                                            <div class="hovereffect"></div>
                                        </a>
                                    </div>
                                </div>
                                <div class="blog-meta big-meta col-md-8">
                                    <h4><a href='<c:url value="/chi-tiet?id=${item.id}"/>'>${item.title}</a></h4>
                                    <p>${item.shortDescription}</p>
                                    <small class="firstsmall"><a class="bg-orange" href='<c:url value="/danh-muc?type=list&id=${model.id}"/>'>${model.categoryName}</a></small>
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
                                <li class="page-item"><a class="page-link" href='<c:url value="/danh-muc?page=${1}&id=${model.id}"/>'>1</a></li>
                                <li class="page-item"><a class="page-link" href='<c:url value="/danh-muc?page=${2}&id=${model.id}"/>'>2</a></li>
                                <li class="page-item"><a class="page-link" href='<c:url value="/danh-muc?page=${3}&id=${model.id}"/>'>3</a></li>
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
                                <img src='<c:url value="/template/web/upload/5k.png"/>' alt="" class="img-fluid">
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
</body>
</html>
