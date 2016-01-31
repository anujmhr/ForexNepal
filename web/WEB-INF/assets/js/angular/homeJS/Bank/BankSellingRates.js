home.controller("BankSellingRates", function ($scope, $http, exchangeRateFactory) {
//    $scope.message = "Hello World-- CurrencysellingRates";

    exchangeRateFactory.getBankList().then(function (response) {
        $scope.bankList = response.data.bankList;
    });

    exchangeRateFactory.getAllDates().then(function (response) {
        $scope.dateList = response.data.forexDates;
    });


    $http.get("http://localhost:8080/ForexNepal/exchange_rates/latest_date").then(function (response) {

        var latestDate = response.data.latestDate;

        $http.get("http://localhost:8080/ForexNepal/exchange_rates/latest_time/" + latestDate).then(function (response) {
            var latestTime = response.data.latestTime;
            $scope.latestDate = latestDate;
            $scope.latestTime = latestTime;
//            console.log($scope.latestDate + "," + $scope.latestTime);
        });



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
                    .domain([0, d3.max(dataset, function (d) {
                            return d.sellingRate;
                        })])
                    .range([0, width]);
            //                  

            var y = d3.scale.ordinal()
                    .domain(dataset.map(function (d) {
                        return d.currency.currencyName;
                    }))
                    .rangeBands([0, height]);
            var xAxis = d3.svg.axis()
                    .scale(x)
                    .orient("bottom");
                   
            var yAxis = d3.svg.axis()
                    .scale(y)
                    .orient("left")
                    .ticks(5);

            d3.selectAll(".bankDisplayPlot").remove();
            var currencySVG = d3.select(".bankPlot").append("svg")
                    .attr("class", "bankDisplayPlot")
                    .attr("width", w)
                    .attr("height", h);


            var chart = currencySVG.append("g")
                    .classed("display", true)
                    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");



            function plot(params) {
                x.domain([d3.min(dataset, function (d) {
                        return d.sellingRate;
                    }), d3.max(dataset, function (d) {
                        return d.sellingRate;
                    })])
                        .range([0, width]);
                y.domain(dataset.map(function (d) {
                    return d.currency.currencyName;
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
                            return y(d.currency.currencyName);
                        })
                        .attr("width", function (d, i) {
                            return x(d.sellingRate);
                        })
                        .attr("height", function (d, i) {
                            return y.rangeBand() - 2;
                        });
                this.selectAll(".bar-label")
                        .attr("x", function (d, i) {
                            return x(d.sellingRate);
                        })
                        .attr("dx", 4)
                        .attr("y", function (d, i) {
                            return y(d.currency.currencyName);
                        })
                        .attr("dy", function (d, i) {
                            return y.rangeBand() / 1.5;
                        })
                        .text(function (d, i) {
                            return d.sellingRate;
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


       // console.log($scope.byDate === undefined ? "abc" : "xyz");

        if ($scope.byDate === undefined || $scope.byDate === undefined) {
            d3.json("http://localhost:8080/ForexNepal/exchange_rates/bank/" + $scope.byBankId + "/" + $scope.latestDate + "/" + $scope.latestTime, function (error, data) {
                if (error)
                    return console.log(error);

                var arr = Object.keys(data);
                var dataset = data[arr].map(function (d) {
                    return d;
                });

                plotGraph(dataset);

            });
        } else {

            d3.json("http://localhost:8080/ForexNepal/exchange_rates/bank/" + $scope.byBankId + "/" + $scope.byDate + "/" + $scope.byTime, function (error, data) {
                if (error)
                    return console.log(error);

                var arr = Object.keys(data);
                var dataset = data[arr].map(function (d) {
                    return d;
                });

                plotGraph(dataset);

            });
        }


        //  end of d3.json


    }; //display graph by currency

});



