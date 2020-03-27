<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<p><a href="profile">Регистрация</a> </p>
<p><a href="news">Войти</a> </p>

<%--<form action="/" method="POST" enctype="utf8">
    <div class="g-recaptcha col-sm-5"
         th:attr="data-sitekey=${captchaSettings.getSite()}"></div>
    <span id="captchaError" class="alert alert-danger col-sm-4"
          style="display:none"></span>
   &lt;%&ndash; <form action="/" method="post">
        <div class="g-recaptcha" data-sitekey="${captchaSettings.getSite()}"></div>
        <input type="submit" value="Validate reCAPTCHA" />
    </form>&ndash;%&gt;
</form>--%>

<form action="/profile" method="post">
    User: <input name="username" type="text" value="" />
    Password: <input name="password" type="password" value="" />
    <!--<if request has 'showRecaptcha' query param>-->
    <div class="g-recaptcha" data-sitekey="6LfhaeQUAAAAAJSe1NiWAHOaXROz9CqdgMVSPEnq"></div>
    <!--</if>-->
    <input type="submit" value="Log in" />
</form>
</body>
</html>

<%--TODO https://www.baeldung.com/spring-security-registration-captcha
https://o7planning.org/ru/10397/using-google-recaptcha-with-java-web-application
https://memorynotfound.com/integrate-google-recaptcha-spring-web-application-java/
--%>