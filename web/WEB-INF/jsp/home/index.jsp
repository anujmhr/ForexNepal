<%-- 
    Document   : index
    Created on : Nov 18, 2015, 7:41:57 PM
    Author     : anuz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${SITE_URL}/assets/js/d3/d3.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/assets/js/angular.min.js" type="text/javascript"></script>

        <style>
            div.bar {
                display: inline-block;
                width: 20px;
                height: 75px;  
                margin-right: 2px;
                background-color: teal;

            }
            #displayPlot{

            }
        </style>
    </head>
    <body ng-app="main-app">
        <div ng-controller="selectBankController">
            <input type="text" name="byBankId" ng-model="byBankId" >

            <input type="button" ng-click="testme()"/>
            <p></p>
        </div>

        <div id="displayPlot">
        </div>


        <script>


            var bankId;
            var app = angular.module("main-app", []);

            app.controller("selectBankController", function ($scope) {



                $scope.testme = function () {


                    d3.json("http://localhost:8080/ForexNepal/exchange_rates/bank/" + $scope.byBankId, function (error, data) {
                        if (error)
                            return console.log(error);
                        var arr = Object.keys(data);
                        //returns array of selected attribute
                        function objectPurifier(selector) {
                            var result = data[arr]
                                    .map(function (k) {
                                        return k[selector];//return specific attribute from a row 
                                    });
                            return result;
                        }
                        //get array of specified selector
                        var buyingRate = objectPurifier("buyingRate");
                        //var sellingRate = objectPurifier("sellingRate");

                        var displayChart = d3.select("#displayPlot").selectAll("div");

                        displayChart.remove();//clear existing graph
                        //create new chart
                        displayChart.data(buyingRate, function (d) {
                            return d;
                        })
                                .enter()
                                .append("div")
                                .attr("class", "bar")
                                .style("height", function (d) {

                                    return d + "px";
                                });
                    });
                };//end of testme
            });//end of app.controller
        </script>
    </body>



</html>
