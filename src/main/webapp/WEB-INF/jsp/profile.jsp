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
    <input id="userid" value="${user.id}" hidden="hidden"></input>
    <div class="container">
        <div class="row no-gutters">
            <div class="col-12 col-sm-6 col-md-8">
        <ul class="list-group">
            <input class="list-group-item" type="text" value="${user.surname}">
            <input class="list-group-item" type="text" value="${user.name}">
            <input class="list-group-item" type="text" value="${user.patronymic}">
            <input class="list-group-item" type="text" value="${user.birthday}">
            <input class="list-group-item" type="text" value="${user.gender}">
            <input class="list-group-item" type="text" value="${user.registered}">
        <c:forEach items="${user.categories}" var="category">
            ${category.name}
<%--        <%=data+=%>" "    <c: let=let+"${category.name}"></c:>--%>
        </c:forEach>
        </ul>
            </div>
            <div class="col-6 col-md-4">
                <img src="/resources/images/shrek.jpg" alt="Здесь может быть Ваше фото">

                <p class="border-5">${user.foto}</p>

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