<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Welcome</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>


<div class="jumbotron center-block">
    <ul>
        <a href="registration"><input class="btn btn-lg btn-primary" type="submit" value="Регистрация"/></a>
        <br>
        <br>
        <br>
        <br>
        <form action="/j_spring_security_check" method="post">
            User: <input name="username" type="text" value=""/>
            <br>
            <br>
            <br>
            <br>
            Password: <input name="password" type="password" value=""/>
            <br>
            <br>
            <br>
            <br>
            <!--<if request has 'showRecaptcha' query param>-->
            <div class="g-recaptcha" data-sitekey="6LfhaeQUAAAAAJSe1NiWAHOaXROz9CqdgMVSPEnq"></div>
            <!--</if>-->
            <br>
            <br>
            <br>
            <br>
            <input class="btn btn-lg btn-primary" type="submit" value="Войти"/>
        </form>
    </ul>
</div>
</body>
</html>

<%--TODO https://www.baeldung.com/spring-security-registration-captcha
https://o7planning.org/ru/10397/using-google-recaptcha-with-java-web-application
https://memorynotfound.com/integrate-google-recaptcha-spring-web-application-java/
--%>