<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Navigation -->
<body>
<div id="wrapper">
    <!-- <header class="tech-header header"> -->
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
                        <a class="nav-link" href="tech-index.html">Tất cả</a>
                    </li>
                    <c:forEach var="item" items="${topCategory}">
                        <li class="nav-item">
                            <a class="nav-link" href="tech-index.html">${item.name}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${not empty childCategory}">
                        <li class="nav-item dropdown has-submenu menu-large hidden-md-down hidden-sm-down hidden-xs-down">
                            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown">Khác</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown01">
                                <li>
                                    <div class="container">
                                        <div class="mega-menu-content clearfix">
                                            <div class="tab">
                                                <button class="tablinks">Science</button>
                                                <button class="tablinks">Technology</button>
                                                <button class="tablinks">Social Media</button>
                                                <button class="tablinks">Car News</button>
                                                <button class="tablinks">Worldwide</button>
                                            </div>
                                        </div><!-- end mega-menu-content -->
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </c:if>


                </ul>
            </div>
        </nav>
    </div>
</div>
</body>


<%--<div id="wrapper">--%>
<%--    <!-- <header class="tech-header header"> -->--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="navbar navbar-expand-md navbar-dark bg-dark mb-4" role="navigation">--%>
<%--            <a class="navbar-brand" href="#">Web tin tức</a>--%>
<%--            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"--%>
<%--                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                <span class="navbar-toggler-icon"></span>--%>
<%--            </button>--%>
<%--            <div class="collapse navbar-collapse" id="navbarCollapse">--%>
<%--                <ul class="navbar-nav mr-auto">--%>
<%--                    <li class="nav-item active">--%>
<%--                        <a class="nav-link" href="#">Home </a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item active">--%>
<%--                        <a class="nav-link" href="">Github</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item active">--%>
<%--                        <a class="nav-link" href="#">Disabled</a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>