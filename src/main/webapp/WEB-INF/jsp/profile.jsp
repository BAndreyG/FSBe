<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Ваш профиль</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<h1>Ваш профиль</h1>
<div class="jumbotron">
    <div class="container">
        <div class="row no-gutters">
            <div class="col-10 col-sm-4 col-md-6">
        <ul class="list-group">
            <input class="list-group-item" id="id" value="${user.id}" hidden="hidden">
            <input class="figure" value="1244" p="1243">
            Фамилия<input class="list-group-item" type="text" id="surname" value="${user.surname}">
            Имя=Login<input class="list-group-item" type="text" id ="name" value="${user.name}">
            Отчество<input class="list-group-item" type="text" id ="patronymic" value="${user.patronymic}">
            День рождения<input class="list-group-item" type="date" id ="birthday" value="${user.birthday}">
            Пол(м/ж)<input list="gend" class="list-group-item" type="text" id ="gender" value="${user.gender}" required maxlength="1">
            <datalist id="gend">
                <option>м</option>
                <option>ж</option>
                <option>М</option>
                <option>Ж</option>
            </datalist>
            Дата регистрации<input class="list-group-item" readonly type="text" id ="registered" value="${user.registered}">
            Пароль<input class="list-group-item" type="text" id ="password" value="${user.password}" placeholder="Пароли надо прятать">
        <c:forEach items="${user.categories}" var="category">
            <p class="catName" hidden >${category.name}</p>
            <p class="catId" hidden>"${category.id}"</p>
        </c:forEach>
            Категории новостей<input class="list-group-item" type="text" id="category">

        </ul>
            </div>
            <div class="col-2 col-md-2"></div>
            <div class="col-6 col-md-4">
                <p><strong>Ваше фото:</strong></p>
                <img  id="foto" src="" alt="Здесь может быть Ваше фото">
                <input id ="fotoData" class="list-group-item" type="text"  value="${user.foto}" hidden="hidden">
                <input id="inp" type='file'>
                <%--<form action="" method="post" name="foto">
                    <input id="inp" type='file'>
                </form>--%>
                <section>
                    <br/>
                    <div class="g-recaptcha" data-sitekey="6LfhaeQUAAAAAJSe1NiWAHOaXROz9CqdgMVSPEnq"></div>
                    <button id="save">Сохранить</button>
                    <button id="delete">Удалить</button>
                </section>
            </div>
        </div>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="resources/js/profile.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
</body>
</html>

<%--  //TODO Добавить страницу "Профиль" с полями ФИО, дата рождения, фото, пол, дата регистрации,
выбранные категории новостей.
--%>