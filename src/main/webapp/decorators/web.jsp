<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Trang chủ"/></title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

<%--    <!-- css -->--%>
    <!-- Design fonts -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

    <link href="<c:url value='/template/web/makup/css/bootstrap.css' />" rel="stylesheet"/>

    <link href="<c:url value='/template/web/makup/css/font-awesome.min.css' />" rel="stylesheet"/>

    <link href="<c:url value='/template/web/makup/style.css' />" rel="stylesheet"/>

    <link href="<c:url value='/template/web/makup/css/responsive.css' />" rel="stylesheet"/>

    <link href="<c:url value='/template/web/makup/css/colors.css' />" rel="stylesheet"/>

    <link href="<c:url value='/template/web/makup/css/version/tech.css' />" rel="stylesheet"/>

<%--    <link href="<c:url value='/template/web/css/style.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/css/font-awesome.min.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/css/responsive.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/css/colors.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/css/version/tech.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

<%--    <link href="<c:url value='/template/web/bootstrap/style.css' />"--%>
<%--          rel="stylesheet" type="text/css" media="all"/>--%>

</head>
<body>
<!-- header -->
<%@ include file="/common/web/header.jsp" %>
<!-- header -->
    <dec:body/>

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- footer -->

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<script type="text/javascript"
        src="<c:url value='/template/web/makup/js/tether.min.js' />"></script>

<script type="text/javascript"
        src="<c:url value='/template/web/makup/js/custom.js' />"></script>

<script type="text/javascript"
        src="<c:url value='/template/web/makup/js/bootstrap.min.js' />"></script>

<script type="text/javascript"
        src="<c:url value='/template/web/makup/js/custom.js' />"></script>
</body>
</html>