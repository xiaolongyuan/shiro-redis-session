<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Learn - <sitemesh:write property='title'/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/static/images/favicon.ico"/>

    <link type="text/css" rel="stylesheet" href="${ctx}/static/bootstrap/bootstrap-3.2.0/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/jquery/jquery-validation-1.13.0/validate.css"/>
    <script type="text/javascript" src="${ctx}/static/jquery/jquery-1.11.1/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/bootstrap/bootstrap-3.2.0/js/bootstrap.min.js"></script>

    <!--[if lt IE 9]>
    <script type="text/javascript" src="${ctx}/static/html5css3/html5shiv.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/html5css3/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        window.publicPath = "${ctx}";

        //跳转到想要去的页面
        function goTo(href, flag) {
            var f = 0;
            if (flag)
                f = flag;
            if (f == 0)
                window.location.href = href;
            else
                window.open(href);
        }

        function logout() {
            $.ajax()
        }
    </script>

    <sitemesh:write property='head'/>
</head>
<body>
<sitemesh:write property='body'/>
</body>
</html>