<%-- 
    Document   : index
    Created on : Nov 4, 2015, 8:43:05 PM
    Author     : Anuz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${SITE_URL}/assets/js/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Admin</h1>
        <hr>

        <button id="scrapBtn">Scrap</button>
        <p id="result"> </p>


        <script>
            $(document).on("ready", function () {
                $("#scrapBtn").click(function () {
                    $.get("http://localhost:8080/ForexNepal/admin/bank/scrap_all",function(data){
                       alert(data);
                    });
                });
            });
        </script>
    </body>
</html>
