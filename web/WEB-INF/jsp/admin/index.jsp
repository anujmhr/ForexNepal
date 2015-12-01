<%-- 
    Document   : index
    Created on : Nov 4, 2015, 8:43:05 PM
    Author     : Anuz
--%>
<%@include file="../include/header.jsp" %>
</head>
<body>
    <h1>Admin</h1>
    <hr>

    <button id="scrapBtn">Scrap</button>
    <p id="result"> </p>


    <script>
        $(document).on("ready", function () {
            $("#scrapBtn").click(function () {
                $.get("http://localhost:8080/ForexNepal/admin/bank/scrap_all", function (data) {
                    alert(data);
                });
            });
        });
    </script>
</body>
</html>
