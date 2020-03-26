<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<%!
    String data ="" ;
%>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Ваш профиль</title>
</head>
<body>
<div class="jumbotron">
    <h1>Ваш профиль</h1>
    <br>

    <div class="container">
        <div class="row no-gutters">
            <div class="col-12 col-sm-6 col-md-8">
        <ul class="list-group">
            <input class="list-group-item" id="userid" value="${user.id}" hidden="hidden"></input>
            <input class="list-group-item" type="text" id="surname" value="${user.surname}">
            <input class="list-group-item" type="text" id ="name" value="${user.name}">
            <input class="list-group-item" type="text" id ="patronymic" value="${user.patronymic}">
            <input class="list-group-item" type="date" id ="birthday" value="${user.birthday}">
            <input class="list-group-item" type="text" id ="gender" value="${user.gender}">
            <input class="list-group-item" readonly type="text" id ="registered" value="${user.registered}">
            <input class="list-group-item" type="text" id ="password" value="${user.password}">
        <c:forEach items="${user.categories}" var="category">
            <p class="catName" hidden >${category.name}</p>
            <p class="catId" hidden>"${category.id}"</p>
<%--        <%=data+=%>" "    <c: let=let+"${category.name}"></c:>--%>
        </c:forEach>
            <input class="list-group-item" type="text" id="category">
        </ul>
            </div>
            <div class="col-6 col-md-4">
                <img src="/resources/images/shrek.jpg" alt="Здесь может быть Ваше фото">

<%--                <p class="border-5">${user.foto}</p>--%>
                <input class="list-group-item" type="text" id ="foto" value="${user.foto}">

                <form action="" method="post" name="foto">
                    <p><strong>Загрузите фотку</strong>:</p>
                    <p><input type="file" name="vid" accept="image/*"></p>
<%--                    <p><input type="image" src="/resources/images/shrek.jpg"></p>--%>

<%--                    <p><input type="submit" value="Отправить"></p>--%>
                </form>

            </div>
        </div>
        <br>
        <br>
    </div>
<%--TODO https://bootstrap-4.ru/articles/cheatsheet/#no-gutters http://khpi-iip.mipk.kharkiv.edu/library/j2ee/tutoral/doc/JSPIntro7.html
закинуть фотку в БД сделать вывод фотки, разобраться с  выводом катерогий
--%>
    <section>
        <button id="save">Сохранить</button>
        <button id="delete">Удалить</button>
    </section>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="resources/js/profile.js"></script>
</body>
</html>

<%--  //TODO Добавить страницу "Профиль" с полями ФИО, дата рождения, фото, пол, дата регистрации,
выбранные категории новостей.
--%>