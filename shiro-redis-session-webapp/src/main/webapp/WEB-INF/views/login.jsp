<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登陆页</title>
</head>
<body id="cas">
<div class="container">

    <div id="loginbox" style="margin-top:100px;" class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">请输入您的用户名和密码.</div>
            </div>

            <div style="padding-top:30px" class="panel-body">
                <form id="fm1" class="form-horizontal" action="${ctx}/login" method="post">


                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                        <input type="text" id="loginName" name="loginName" value="${loginName}" class="form-control"
                               placeholder="用户名:" style="width: 70%;">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" name="password" class="form-control"
                               placeholder="密码:" style="width: 70%;">
                    </div>
                    <div class="input-group">
                        <div class="checkbox">
                            <label>
                                <input id="warn" type="checkbox" name="rememberMe" value="true">记住我.
                            </label>
                        </div>
                    </div>

                    <c:if test="${not empty shiroLoginFailure && shiroLoginFailure==true}">
                        <br>
                        <div class="alert alert-danger col-sm-12 col-md-12">登陆失败,请重新登录</div>
                    </c:if>

                    <div style="margin-top:10px" class="form-group">
                        <div class="col-md-2">
                            <button name="submit" type="submit" class="btn btn-success">登陆</button>
                        </div>
                        <div class="col-md-2">
                            <button name="reset" type="reset" class="btn btn-info">重置</button>
                        </div>
                    </div>
                </form>


            </div>
        </div>
    </div>
</div>


</body>
</html>
