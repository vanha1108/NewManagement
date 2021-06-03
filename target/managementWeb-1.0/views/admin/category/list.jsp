<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="APIurl" value="/api-admin-new"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách bài viết</title>
</head>

<body>
<div class="main-content">
    <form action="<c:url value='/admin-category'/>" id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty messageParam}">
                            <div class="alert alert-${alert}" role="alert">
                                    ${messageParam}
                            </div>
                        </c:if>
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title='Thêm danh mục' href='<c:url value="/admin-category?type=add"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Tên danh mục</th>
                                            <th>Lượt bài viết đang sử dụng</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>${item.name}
                                                <td>${item.count_use}
                                                <td>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật danh mục"
                                                       href='<c:url value="/admin-category?type=edit&id=${item.id}"/>'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                <c:set var="count" value="${item.count_use}"/>
                                                <c:set var="zero" value="${0}"/>
                                                <c:if test="${count != zero}">
                                                    <a disabled="true" href='<c:url value="/admin-category?type=delete&id=${item.id}" />'
                                                       class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                       data-toggle="tooltip" title='Xóa danh mục'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                                    </a>
                                                </c:if>
                                                <c:if test="${count == zero}">
                                                    <a href='<c:url value="/admin-category?type=delete&id=${item.id}" />'
                                                       class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                       data-toggle="tooltip" title='Xóa danh mục'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                                    </a>
                                                </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>

</html>