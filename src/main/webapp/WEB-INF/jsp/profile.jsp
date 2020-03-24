<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<%--<jsp:include page="fragments/headTag.jsp"/>--%>
<head>
    <title>You profile</title>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script src="/resources/js/dtable.js" type="text/javascript"></script>
</head>
<body>


<div>
    <h1>You personal data</h1>
    <section class="p-2">
        <p>${user.surname}</p>
        <p>${user.name}</p>
        <p>${user.patronymic}</p>
        <p>${user.birthday}</p>
        <p>${user.gender}</p>
        <p>${user.registered}</p>
    </section>
    <section class="p-3 figure-img">
        <p>${user.foto}</p>
    </section>

</div>

</body>
</html>

<%--  //TODO Добавить страницу "Профиль" с полями ФИО, дата рождения, фото, пол, дата регистрации,
выбранные категории новостей.
--%>