<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>
<div id="wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                    data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href=""><img src="" alt=""></a>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/trang-chu"/>'>Tất cả</a>
                    </li>
                    <c:forEach var="item" items="${topCategory}">
                        <li class="nav-item">
                            <a class="nav-link"
                               href='<c:url value="/danh-muc?type=list&id=${item.id}"/>'>${item.name}</a>
                        </li>
                    </c:forEach>
<%--                    <c:if test="${not empty childCategory}">--%>
<%--                        <li class="nav-item dropdown has-submenu menu-large hidden-md-down hidden-sm-down hidden-xs-down">--%>
<%--                            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown">Khác</a>--%>
<%--                            <ul class="dropdown-menu" aria-labelledby="dropdown01">--%>
<%--                                <li>--%>
<%--                                    <div class="container">--%>
<%--                                        <div class="mega-menu-content clearfix">--%>
<%--                                            <div class="tab">--%>
<%--                                                <c:forEach var="child" items="${childCategory}">--%>
<%--                                                    <a class="tablinks"--%>
<%--                                                       href='<c:url value="/danh-muc?type=list&id=${child.id}"/>'>${child.name}</a>--%>
<%--                                                </c:forEach>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
<%--                        </li>--%>
<%--                    </c:if>--%>
                </ul>
            </div>
        </nav>
    </div>
</div>
</body>