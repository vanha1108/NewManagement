<%--
  Created by IntelliJ IDEA.
  User: DEV
  Date: 6/1/2021
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${detailNew.title}</title>
</head>
<body>
<section class="section single-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                <div class="page-wrapper">
                    <div class="blog-title-area text-center">
                        <ol class="breadcrumb hidden-xs-down">
                            <li class="breadcrumb-item"><a href='<c:url value="/trang-chu"/>'>Trang chủ</a></li>
                            <li class="breadcrumb-item active">${detailNew.title}</li>
                        </ol>

                        <span class="color-orange"><a href='<c:url value="/danh-muc?type=list&id=${detailNew.categoryId}"/>' title="">${detailNew.categoryName}</a></span>

                        <h3>${detailNew.title}</h3>

                        <div class="blog-meta big-meta">
                            <small><a>${detailNew.disCreateDate}</a></small>
                            <small><a><i class="fa fa-eye"></i> ${detailNew.viewClick}</a></small>
                        </div>
                    </div>

                    <div class="single-post-media">
                        <img src="upload/tech_menu_08.jpg" alt="" class="img-fluid">
                    </div><!-- end media -->

                    <div class="blog-content">
                        ${detailNew.content}
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
                                            <img src="${best.thumbnail}" alt="" class="img-fluid">
                                            <div class="hovereffect"></div><!-- end hover -->
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
