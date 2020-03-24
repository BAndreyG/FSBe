<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html xmlns:th="http://www.thymeleaf.org">--%>
<html lang="ru">
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>News</title>
</head>
<body>
<div class="jumbotron">
    <table border="3">
        <thead>
        <tr>
            <th>Заголовок</th>
            <th>Сокращенный текст</th>
            <th>Новость</th>
            <th>Превью</th>
            <th>Дата создания</th>
            <th>Категория новости</th>
            <th>Ссылка</th>
        </tr>
        </thead>
        <tbody>
        <%--        c:forEach ="news:${news}"--%>
        <c:forEach items="${newsList}" var="news">
            <tr>
                <td>${news.head}</td>
                <td>${news.mintext}</td>
                <td>${news.news}</td>
                <td>${news.preview}</td>
                <td>${news.createday}</td>
                <td>${news.category.name}</td>
                <td>${news.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
<%--
//TODO  Создать страницу новости (заголовок, сокращенный текст, новости, маленькое фото для превью,
 дата создания новости, категория новости, ссылка на новость).
Добавить 30 записей, по 10 записей на странице
--%>
