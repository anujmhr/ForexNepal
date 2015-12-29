<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>



        <link href="${SITE_URL}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${SITE_URL}/assets/css/custom-css.css" rel="stylesheet" type="text/css"/>
    </head> 
    <body ng-app="admin">
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">
                            <!--                            <svg id="svglogo">
                                                        <rect x="0"  y="0"  width="20" height="20" fill="rgba(0, 0, 150,0.4)"></rect>
                                                        <rect x="5" y="5" width="20" height="20" fill="rgba(0, 150, 0, 0.7)"></rect>
                            
                                                        </svg>-->
                            ForexNepal
                        </a>

                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Currency </a></li>
                            <li><a href="#">Bank</a></li>

                        </ul>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->

            </nav>  

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="list-group">
                            <a href="#dashboard" class="list-group-item active">Dashboard</a>
                            <a href="#banks" class="list-group-item">Banks</a>
                            <a href="#exchangeRates" class="list-group-item"  >Exchange Rates</a>
                            <a href="#currency" class="list-group-item">Currency</a>
                        </div>
                    </div>
                    <div class="col-lg-9">

                        <div ng-view="">

                        </div>
                    </div>
                </div>
            </div>  

        </div> <!--end of container-->
        <script>





//            $(document).on("ready", function () {
//                $("#scrapBtn").click(function () {
//                    $.get("http://localhost:8080/ForexNepal/admin/bank/scrap_all", function (data) {
//                        alert(data);
//                    });
//                });
//            });
        </script>
        <script src="${SITE_URL}/assets/js/d3/d3.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-route.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-resource.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-animate.min.js" type="text/javascript"></script>
        
        
        <script src="${SITE_URL}/assets/js/angular/adminJS/adminScript.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular/adminJS/DashboardController.js" type="text/javascript"></script>       
        <script src="${SITE_URL}/assets/js/angular/adminJS/BankController.js" type="text/javascript"></script>       
        <script src="${SITE_URL}/assets/js/angular/adminJS/CurrencyController.js" type="text/javascript"></script>       
        <script src="${SITE_URL}/assets/js/angular/adminJS/ExchangeRatesController.js" type="text/javascript"></script>       

        <script>


        </script>

        <!--        <script src="js/controller/DashboardController.js" type="text/javascript"></script>
                <script src="js/controller/BankController.js" type="text/javascript"></script>-->
    </body>
</html>
