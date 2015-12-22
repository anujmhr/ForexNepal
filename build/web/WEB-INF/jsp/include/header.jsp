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
        <div class="container-fluid well">
            <div class="row">
                <div class="col-md-1">
                    <a href="#">
                        <svg id="svglogo">
                        <rect x="0"  y="0"  width="40" height="40" fill="rgba(0, 0, 150,0.4)"></rect>
                        <rect x="5" y="5" width="40" height="40" fill="rgba(0, 150, 0, 0.7)"></rect>
                        </svg>
                    </a>
                </div>
                <div class="col-md-11">
                    <h3>ForexNepal</h3>
                </div>
            </div>
        </div>

