
<%@include file="../include/header.jsp" %>


<body ng-app="main-app">

    <div class="container">
        <div class="row">
            <div class="col-md-6">

                <div ng-controller="currencyController" id="currencyPlot">






                    <select id="currencySelect" ng-model="byCurrencyId" >
                        <option value="" selected disabled>Select Currency</option>
                        <c:forEach var="currency" items="${allCurrency}">
                            <option value="${currency.currencyId}">${currency.currencyName}</option>
                        </c:forEach>

                    </select>

                    <select  id="currencyDate" ng-model="byDate" ng-change="populateTime(byDate)">
                        <option value="0" disabled selected>Select Date</option>
                        <option ng-repeat="date in dateList" value="{{date}}" >
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


                    <!--                        <div id="currencyDisplayPlot"></div>-->

                </div>  <!--end of currencyController-->
            </div>

            <div class="col-md-6">
                <div ng-controller="bankController">
                    <select id="bankSelect" ng-model="byBankId">
                        <option value="">Select Bank</option>
                        <c:forEach var="bank" items="${allBank}">
                            <option value="${bank.bankId}">${bank.bankName}</option>
                        </c:forEach>

                    </select>



                    <input type="button" class="btn btn-default" ng-click="displayGraphByBank()" value="Display"/>


                    <div id="bankDisplayPlot"></div>

                </div>
            </div>
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

            $scope.populateTime = function (date) {

                $http.get("http://localhost:8080/ForexNepal/exchange_rates/time_by_date/" + date)
                        .then(function (response) {
                            $scope.timeList = response.data.timeByDate;
                        });

            };








            $scope.displayGraphByCurrency = function () {

                d3.json("http://localhost:8080/ForexNepal/exchange_rates/" + $scope.byCurrencyId + "/" + $scope.byDate + "/" + $scope.byTime, function (error, data) {
                    if (error)
                        return console.log(error);


                    

                    var arr = Object.keys(data);
                    var dataset = data[arr].map(function (d) {
                        return d;
                    });
                    //console.log(dataset[0].bank.bankName);



                    //returns array of selected attribute
                    //                    function objectPurifier(selector) {
                    //                        var result = data[arr]
                    //                                .map(function (k) {
                    //                                  return k[selector];//return specific attribute from a row 
                    //                                });
                    //                        return result;
                    //                    }


                    var w = 500;
                    var h = 350;

                    var margin = {
                        top: 20,
                        bottom: 40,
                        left: 80,
                        right: 20
                    };
                    var width = w - margin.left - margin.right;
                    var height = h - margin.top - margin.bottom;

                    //get array of specified selector
                    //var buyingRate = objectPurifier("buyingRate");
                    //console.log(buyingRate);
                    //var sellingRate = objectPurifier("sellingRate");
                    var x = d3.scale.linear()
                            .domain([d3.min(dataset, function (d) {
                                    return d.buyingRate;
                                }), d3.max(dataset, function (d) {
                                    return d.buyingRate;
                                })])
                            .range([0, width]);
                    
//                    var y = d3.scale.linear()
//                            .domain([0, dataset.length])
//                            .range([0, height]);


                    var y = d3.scale.ordinal()
                            .domain(dataset.map(function (d) {
                                return d.bank.bankName;

                            }))
                                    .rangeBands([0, height]);
                            
                            

//
                            var xAxis = d3.svg.axis()
                                    .scale(x)
                                    .orient("bottom")
                                    .ticks(5);
                            var yAxis = d3.svg.axis()
                                    .scale(y)
                                    .orient("left")
                                    .ticks(5);

                            var currencySVG = d3.select("#currencyPlot").append("svg")
                                    .attr("id", "currencyDisplayPlot")
                                    .attr("width", w)
                                    .attr("height", h);
                            var chart = currencySVG.append("g")
                                    .classed("display", true)
                                    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

                            function plot(params) {
                                //console.log(this);
                                this.selectAll(".bar")
                                        .data(params.data)
                                        .enter()
                                        .append("rect")
                                        .classed("bar", true)
                                        .attr("x", 0)
                                        .attr("y", function (d, i) {
                                            return y(d.bank.bankName);
                                        })
                                        .attr("width", function (d, i) {
                                            return x(d.buyingRate);
                                        })
                                        .attr("height", function (d, i) {
                                            return y.rangeBand() - 1;
                                        });

                                this.selectAll(".bar-label")
                                        .data(params.data)
                                        .enter()
                                        .append("text")
                                        .classed("bar-label", true)
                                        .attr("x", function (d, i) {
                                            return x(d.buyingRate);
                                        })
                                        .attr("dx", -4)
                                        .attr("y", function (d, i) {
                                            return y(d.bank.bankName);
                                        })
                                        .attr("dy", function (d, i) {
                                            return y.rangeBand() / 1.5;
                                        })
                                        .text(function (d, i) {
                                            return d.buyingRate;
                                        });

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



                            //                    var displayChart = d3.select("#currencyDisplayPlot").selectAll("div");
                            //
                            //
                            //                    displayChart.remove();//clear existing graph
                            //                    //create new chart
                            //                    displayChart.data(buyingRate)
                            //                            .enter()
                            //                            .append("div")
                            //                            .attr("class", "bar")
                            //                            .style("height", function (d) {
                            //
                            //                                return d + "px";
                            //                            });
                        });
                    };//end of testme

                });
                app.controller("bankController", function ($scope) {
                    $scope.displayGraphByBank = function () {


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
                            console.log(buyingRate);
                            //var sellingRate = objectPurifier("sellingRate");


                            var scale = d3.scale.linear()
                                    .domain([0, 200])
                                    .range([0, 400]);

                            var displayChart = d3.select("#bankDisplayPlot").selectAll("div");

                            displayChart.remove();//clear existing graph
                            //create new chart
                            displayChart.data(buyingRate)
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
