<%-- 
    Document   : index
    Created on : Nov 18, 2015, 7:41:57 PM
    Author     : anuz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${SITE_URL}/assets/js/d3/d3.min.js" type="text/javascript"></script>

        <style>
            div.bar {
                display: inline-block;
                width: 20px;
                height: 75px;  
                margin-right: 2px;
                background-color: teal;

            }
        </style>
    </head>
    <body>

        <div></div>


        <script>

            d3.json("ForexNepal/exchange_rates/bank/6", function (error, data) {
                if (error)
                    return console.log(error);
                //["exchangeRatesByBank"]
                var arr = Object.keys(data);

                function objectPurifier(selector) {
                    //console.log(data[arr]);
                    var result = data[arr]
                            .map(function (k) {
//                    var a=Object.keys(k);
//                    a.forEach(function (d){
//                        console.log(Object.valueOf(d));    
//                    })
//         
                                //console.log(k["buyingRate"]);
                                return k[selector];
                            });

                    //console.log(result);
                    return result;
                }

                var buyingRate = objectPurifier("buyingRate");
                console.log(buyingRate);

                var sellingRate = objectPurifier("sellingRate");
                console.log(sellingRate);


                console.log(arr);

                var svg = d3.select("body").selectAll("div")
                        .data(buyingRate, function (d) {
                            return d;
                        })
                        .enter()
                        .append("div")
                        .attr("width", 700)
                        .attr("class", "bar")
                        .style("height", function (d) {

                            return d + "px";
                        })

//                var svg = d3.select("body").selectAll("div")
//                        .data(sellingRate, function (d) {
//                            return d;
//                        })
//                        .enter()
//                        .append("div")
//                        .attr("width", 700)
//                        .attr("class", "bar")
//                        .style("height", function (d) {
//
//                            return d + "px";
//                        })
//


            });



        </script>
    </body>



</html>
