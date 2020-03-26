<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--https://getbootstrap.com/docs/4.0/examples/sticky-footer/--%>
<footer class="footer">
    <%--    <link rel="stylesheet" href="resources/css/bootstrap.min.css">--%>
    <div class="container">
        <div class="row">
            <div class="col-2" id="buttons">
                <a href="news">
                    <button id="newsButton" type="button" class="btn btn-primary">Новости</button>
                </a>
            </div>
            <div class="col-2">
                <a href="profile">
                    <button id="profileButton" type="button" class="btn btn-secondary">Профиль</button>
                </a>
            </div>
            <div class="col-8">
                <div class="d-flex justify-content-end">
                    <a href="/">
                        <button type="button" class="btn btn-danger">Выйти</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
        <script type="text/javascript" src="resources/js/footer.js"></script>
</footer>