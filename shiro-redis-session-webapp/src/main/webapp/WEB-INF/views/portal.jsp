<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>portal</title>
    <%--<style type="text/css">
        /* <![CDATA[ */
        /*css 内容*/
        /* ]]> */
    </style>

    <script type="text/javascript">
        // <![CDATA[
        // JavaScrip 内容
        // ]]>
    </script>--%>

</head>
<body>
<h2>Hello World!</h2>

<a href="${ctx}/logout">退出</a>

<script type="text/javascript">
    $(document).ready(
            function () {
                $(document).mousedown(function (e) {
                    console.log(e);
                    if (e.which == 3) {
                        e.preventDefault();
                        alert('禁用右键，弹出自己的');
                    }
                });
            }
    );
</script>

<%--
JS文件引入位置
<script type=”text/javascript” src=”JS文件”></script>
--%>
Server Info:<br>
<%
    out.println("ServerName : " + request.getServerName() + "<br>");
    out.println("IP&Port : " + request.getLocalAddr() + ":" + request.getLocalPort() + "<br>");
    out.println("<br> ID " + session.getId() + "<br>");
    // 如果有新的 Session 属性设置
    String dataName = request.getParameter("dataName");
    if (dataName != null && dataName.length() > 0) {
        String dataValue = request.getParameter("dataValue");
        session.setAttribute(dataName, dataValue);
    }
    out.println("<b>Session 列表</b><br>");
    System.out.println("==============portal.jsp==============");
    Enumeration e = session.getAttributeNames();
    while (e.hasMoreElements()) {
        String name = (String) e.nextElement();
        String value = session.getAttribute(name).toString();
        out.println(name + " = " + value + "<br>");
        System.out.println(name + " = " + value);
    }
%>
<shiro:hasRole name="admin">
    <br><span>拥有角色admin，才能看到本段文字</span><br>

</shiro:hasRole>

<br><span>个性化的值 : ${custom.test}</span><br>
<form action="${ctx}/session/add" method="POST">
    <span>名称:</span><input type=text size=20 name="dataName">
    <br>
    <span>值:</span><input type=text size=20 name="dataValue">
    <br>
    <input type=submit>
</form>
</body>
</html>
