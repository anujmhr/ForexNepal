
<%@include file="../include/header.jsp" %>

<body ng-app="main-app">

    <div class="container">


        <div ng-controller="currencyController" id="currencyPlot">

            <select id="currencySelect" ng-model="byCurrencyId" >
                <option value="" selected disabled>Select Currency</option>
                <c:forEach var="currency" items="${allCurrency}">
                    <option value="${currency.currencyId}">${currency.currencyName}</option>
                </c:forEach>

            </select>
            <!--ng-change="populateTime(byDate)"--> 


            <select  id="currencyDate" ng-model="byDate" ng-change="populateTime(byDate)" >

                <option ng-repeat="date in dateList|orderBy:'-':true" value="{{date}}" selected>
                    {{date}}
                <option>
            </select>

            <select  id="currencyTime" ng-model="byTime" >
                <option value="" disabled selected>Select Time</option>
                <option ng-repeat="time in timeList" value="{{time}}" >
                    {{time}}
                <option>
            </select>




            <input type="button" class="btn btn-default" ng-click="displayGraphByCurrency()" value="Display"/>




        </div>  <!--end of currencyController-->



        <!--        <div ng-controller="bankController">
                    <select id="bankSelect" ng-model="byBankId">
                        <option value="">Select Bank</option>
        <c:forEach var="bank" items="${allBank}">
            <option value="${bank.bankId}">${bank.bankName}</option>
        </c:forEach>

    </select>



    <input type="button" class="btn btn-default" ng-click="displayGraphByBank()" value="Display"/>


    <div id="bankDisplayPlot"></div>

</div>-->

    </div>


</div>


<script>


    var app = angular.module("main-app", []);

    app.factory("exchangeRateFactory", function ($http) {
        var obj = {};

        obj.getAll = function () {
            $http.get("http://localhost:8080/ForexNepal/exchange_rates")
                    .then(function (response) {
                        var allDateList = response.data.exchangeRates;
                    });
        };

        obj.getAllDates = function () {
            return $http.get("http://localhost:8080/ForexNepal/exchange_rates/all_dates");

        };

        return obj;
    });

    app.controller("currencyController", function ($scope, $http, exchangeRateFactory) {


        exchangeRateFactory.getAllDates().then(function (response) {
            $scope.dateList = response.data.forexDates;
        });


        $scope.populateTime = function (byDate) {

            $http.get("http://localhost:8080/ForexNepal/exchange_rates/time_by_date/" + byDate)
                    .then(function (response) {
                        $scope.timeList = response.data.timeByDate;
                    });
        };

        $scope.displayGraphByCurrency = function () {
            var plotGraph = function (dataset) {
                var w = 700;
                var h = 400;
                var margin = {
                    top: 30,
                    bottom: 40,
                    left: 220,
                    right: 70
                };
                var width = w - margin.left - margin.right;
                var height = h - margin.top - margin.bottom;




                var x = d3.scale.linear()
                        .domain([d3.min(dataset, function (d) {
                                return d.buyingRate;
                            }), d3.max(dataset, function (d) {
                                return d.buyingRate;
                            })])
                        .range([0, width]);
//                  

                var y = d3.scale.ordinal()
                        .domain(dataset.map(function (d) {
                            return d.bank.bankName;
                        }))
                        .rangeBands([0, height]);
                var xAxis = d3.svg.axis()
                        .scale(x)
                        .orient("bottom")
                        .ticks(5);
                var yAxis = d3.svg.axis()
                        .scale(y)
                        .orient("left")
                        .ticks(5);
                
                d3.selectAll("#currencyDisplayPlot").remove();
                var currencySVG = d3.select("#currencyPlot").append("svg")
                        .attr("id", "currencyDisplayPlot")
                        .attr("width", w)
                        .attr("height", h);


                var chart = currencySVG.append("g")
                        .classed("display", true)
                        .attr("transform", "translate(" + margin.left + "," + margin.top + ")");


                
                function plot(params) {
                    x.domain([d3.min(dataset, function (d) {
                            return d.buyingRate;
                        }), d3.max(dataset, function (d) {
                            return d.buyingRate;
                        })])
                            .range([0, width]);
                    y.domain(dataset.map(function (d) {
                        return d.bank.bankName;
                    }))
                            .rangeBands([0, height]);

                    //enter()
                    this.selectAll(".bar")
                            .data(params.data)
                            .enter()
                            .append("rect")
                            .classed("bar", true);

                    this.selectAll(".bar-label")
                            .data(params.data)
                            .enter()
                            .append("text")
                            .classed("bar-label", true);


                    //update
                    this.selectAll(".bar")
                            .transition()
                            .duration(400)
                            .attr("x", 0)
                            .attr("y", function (d, i) {
                                return y(d.bank.bankName);
                            })
                            .attr("width", function (d, i) {
                                return x(d.buyingRate);
                            })
                            .attr("height", function (d, i) {
                                return y.rangeBand() - 2;
                            });
                    this.selectAll(".bar-label")
                            .attr("x", function (d, i) {
                                return x(d.buyingRate);
                            })
                            .attr("dx", 4)
                            .attr("y", function (d, i) {
                                return y(d.bank.bankName);
                            })
                            .attr("dy", function (d, i) {
                                return y.rangeBand() / 1.5;
                            })
                            .text(function (d, i) {
                                return d.buyingRate;
                            });

                    //exit()
                    this.selectAll(".bar")
                            .data(params.data)
                            .exit()
                            .remove();

                    this.selectAll(".bar-label")
                            .data(params.data)
                            .exit()
                            .remove();


                    this.append("g")
                            .classed("x axis", true)
                            .attr("transform", "translate(" + 0 + "," + height + ")")
                            .call(xAxis);
                    this.append("g")
                            .classed("y axis", true)
                            .attr("transform", "translate(0,0)")
                            .call(yAxis);

                }

                plot.call(chart, {
                    data: dataset
                });
            }

            d3.json("http://localhost:8080/ForexNepal/exchange_rates/" + $scope.byCurrencyId + "/" + $scope.byDate + "/" + $scope.byTime, function (error, data) {
                if (error)
                    return console.log(error);

                var arr = Object.keys(data);
                var dataset = data[arr].map(function (d) {
                    return d;
                });

                plotGraph(dataset);
                
            });

            //  end of d3.json


        }; //display graph by currency
    });//currencyy controller
    
    
    

</script>
</body>



</html>
