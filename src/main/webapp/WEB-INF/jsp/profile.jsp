<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<%!
    String data ="" ;
%>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>You profile</title>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
<%--    <script src="/resources/js/dtable.js" type="text/javascript"></script>--%>
</head>
<body>


<div class="jumbotron">
    <h1>You profile</h1>
    <div class="row">
        <div class="row no-gutters">
            <div class="col-12">
        <ul class="list-group">
            <li class="list-group-item"><input type="text" value="${user.surname}"></li>
            <li class="list-group-item"><input type="text" value="${user.name}"></li>
            <li class="list-group-item"><input type="text" value="${user.patronymic}"></li>
            <li class="list-group-item"><input type="text" value="${user.birthday}"></li>
            <li class="list-group-item"><input type="text" value="${user.gender}"></li>
            <li class="list-group-item"><input type="text" value="${user.registered}"></li>
        <c:forEach items="${user.categories}" var="category">
            ${category.name}
<%--        <%=data+=%>" "    <c: let=let+"${category.name}"></c:>--%>
        </c:forEach>
<%--            <li class="list-group-item"><input type="text" value="<%=data%>"></li>--%>
        </ul>
            </div>
            <div class="col-6 col-md-4">
                <p class="border-5">${user.foto}</p>
            </div>
        </div>
    </div>
<%--TODO https://bootstrap-4.ru/articles/cheatsheet/#no-gutters http://khpi-iip.mipk.kharkiv.edu/library/j2ee/tutoral/doc/JSPIntro7.html
закинуть фотку в БД сделать вывод фотки, разобраться с  выводом катерогий
--%>
    <section>
        <button>Сохранить</button>
        <button>Удалить</button>
        </br>
<%--        // TODO доделать--%>
        <form action="formdata" method="post" name="form1">
            <p><strong>Загрузите фотку</strong>:</p>
            <p><input type="file" name="vid" accept="image/jpg"></p>
            <p><input type="submit" value="Отправить"></p>
        </form>


    </section>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

<%--  //TODO Добавить страницу "Профиль" с полями ФИО, дата рождения, фото, пол, дата регистрации,
выбранные категории новостей.
--%>