<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForexNepal</title>
        <link href="${SITE_URL}/assets/css/custom-css.css" rel="stylesheet" type="text/css"/>

        <link href="${SITE_URL}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${SITE_URL}/assets/js/d3/d3.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular.min.js" type="text/javascript"></script>


    </head>
    <body>
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
                            <svg id="svglogo">
                            <rect x="0"  y="0"  width="20" height="20" fill="rgba(0, 0, 150,0.4)"></rect>
                            <rect x="5" y="5" width="20" height="20" fill="rgba(0, 150, 0, 0.7)"></rect>

                            </svg>

                        </a>

                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Currency <span class="sr-only">(current)</span></a></li>
                            <li><a href="#">Bank</a></li>

                        </ul>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->

            </nav>
        </div>      
