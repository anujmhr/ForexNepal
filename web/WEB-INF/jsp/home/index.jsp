<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForexNepal</title>
        <link href="${SITE_URL}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${SITE_URL}/assets/css/custom-css.css" rel="stylesheet" type="text/css"/>





    </head>

    <body ng-app="main-app">
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
                        <a class="navbar-brand" href="#currency">
                            <!--                            <svg id="svglogo">
                                                        <rect x="0"  y="0"  width="20" height="20" fill="rgba(0, 0, 150,0.4)"></rect>
                                                        <rect x="5" y="5" width="20" height="20" fill="rgba(0, 150, 0, 0.7)"></rect>
                            
                                                        </svg>-->
                            ForexNepal
                        </a>
                    </div>

                </div><!-- /.container-fluid -->

            </nav>


            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3">

                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            Currency
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="list-group">
                                        <a href="#buying_rate" class="list-group-item">CurrencyBuyingRate</a>
                                        <a href="#selling_rate" class="list-group-item">CurrencySellingRate</a>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            Bank
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                    <div class="list-group">
                                        <a href="#bank/buying_rate" class="list-group-item">BanksBuyingRate</a>
                                        <a href="#bank/selling_rate" class="list-group-item">BanksSellingRate</a>
                                    </div>
                                </div>
                            </div>
                            

                        </div>

                    </div>
                    <div class="col-lg-9">

                        <div ng-view="">

                        </div>
                    </div>
                </div>
            </div>
        </div> 

        <script>

        </script>

        <script src="${SITE_URL}/assets/js/d3/d3.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-route.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-resource.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular-animate.min.js" type="text/javascript"></script>



        <script src="${SITE_URL}/assets/js/angular/homeJS/homeScript.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular/homeJS/Currency/HomeCurrencyController.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular/homeJS/Bank/HomeBankController.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular/homeJS/Currency/CurrencySellingRates.js" type="text/javascript"></script>

        <script src="${SITE_URL}/assets/js/angular/homeJS/Currency/CurrencyBuyingRates.js" type="text/javascript"></script>

        <script src="${SITE_URL}/assets/js/angular/homeJS/Bank/BankSellingRates.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular/homeJS/Bank/BankBuyingRates.js" type="text/javascript"></script>
    </body>



</html>
