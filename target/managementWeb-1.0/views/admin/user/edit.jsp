<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Chỉnh sửa tài khoản</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form id="formSubmit" method="post">
                        <c:if test="${not empty messageParam}">
                            <div class="alert alert-${alert}" role="alert">
                                    ${messageParam}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <c:if test="${empty model.id}">
                                <label hidden="true" class="col-sm-3 control-label no-padding-right">Mã tài khoản</label>
                                <div hidden="true" class="col-sm-9">
                                    <input type="text" class="form-control"
                                           value="${model.id}"/>
                                </div>
                            </c:if>
                            <c:if test="${not empty model.id}">
                                <label class="col-sm-3 control-label no-padding-right">Mã tài khoản</label>
                                <div  class="col-sm-9">
                                    <input readonly="true" type="text" class="form-control" id="id" name="id"
                                           value="${model.id}"/>
                                </div>
                            </c:if>

                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Họ và tên</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="fullName" name="fullName"
                                       value="${model.fullName}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên tài khoản</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="userName" name="userName"
                                       value="${model.userName}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mật khẩu</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="password" name="password"
                                       value="${model.password}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <a href='<c:url value="/admin-user?type=update"/>'
                                       id="btnAddOrUpdateNew">
                                        <input class="btn btn-white btn-warning btn-bold" type="submit" value="Cập nhật"/>
                                    </a>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <a href='<c:url value="/admin-category?type=add"/>'
                                       id="btnAddOrUpdateNew">
                                        <input class="btn btn-white btn-warning btn-bold" type="submit" value="Thêm"/>
                                    </a>
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
