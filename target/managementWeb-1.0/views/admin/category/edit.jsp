<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form id="formSubmit">
                        <c:if test="${not empty messageParam}">
                            <div class="alert alert-${alert}" role="alert">
                                    ${messageParam}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <c:if test="${empty model.id}">
                            <label hidden="true" class="col-sm-3 control-label no-padding-right">Mã loại danh mục</label>
                            <div hidden="true" class="col-sm-9">
                                <input type="text" class="form-control"
                                       value="${model.id}"/>
                            </div>
                            </c:if>
                            <c:if test="${not empty model.id}">
                                <label class="col-sm-3 control-label no-padding-right">Mã loại danh mục</label>
                                <div  class="col-sm-9">
                                    <input readonly="true" type="text" class="form-control" id="id" name="id"
                                           value="${model.id}"/>
                                </div>
                            </c:if>

                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên danh mục</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="name" name="name"
                                       value="${model.name}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <button type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật"
                                           id="btnAddOrUpdateNew">
                                        Cập nhật
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm"
                                           id="btnAddOrUpdateNew">
                                        Thêm
                                    </button>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
