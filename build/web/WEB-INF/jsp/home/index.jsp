
<%@include file="../include/header.jsp" %>


<body ng-app="main-app">

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div ng-controller="currencyController">
                    <select id="currencySelect" ng-model="byCurrencyId">
                        <option value="" disabled>Select Currency</option>
                        <c:forEach var="currency" items="${allCurrency}">
                            <option value="${currency.currencyId}">${currency.currencyName}</option>
                        </c:forEach>

                    </select>
                    <input type="button" class="btn btn-default" ng-click="displayGraphByCurrency()" value="Display"/>

                    <div id="currencyDisplayPlot">
                    </div>
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

                    <div id="bankDisplayPlot">
                    </div>
                </div>
            </div>
        </div>


    </div>


    <script>


        var app = angular.module("main-app", []);
        
        

        app.controller("currencyController", function ($scope) {
            $scope.displayGraphByCurrency = function () {
                d3.json("http://localhost:8080/ForexNepal/exchange_rates/currency/" + $scope.byCurrencyId, function (error, data) {
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
                            .domain([0, d3.max(buyingRate)])
                            .range([0,100]);

                    var displayChart = d3.select("#currencyDisplayPlot").selectAll("div");

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
