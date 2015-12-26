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
                    var x = d3.scale.ordinal()
                            .domain(dataset.map(function (d) {
                                return d.bank.bankName;

                            }))
                            .rangeBands([0, width]);

//                    var y = d3.scale.linear()
//                            .domain([0, dataset.length])
//                            .range([0, height]);


                    var y = d3.scale.linear()
                            .domain([d3.min(dataset, function (d) {
                                    return d.buyingRate;
                                }), d3.max(dataset, function (d) {
                                    return d.buyingRate;
                                })])
                            .range([height, 0]);

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
                                .attr("x", function (d, i) {
                                    return x(d.bank.bankName);
                                })
                                .attr("y", function (d, i) {
                                    return y(d.buyingRate);
                                })
                                .attr("width", function (d, i) {
                                    return x.rangeBand();
                                })
                                .attr("height", function (d, i) {
                                    return height - y(d.buyingRate);
                                });

                        this.selectAll(".bar-label")
                                .data(params.data)
                                .enter()
                                .append("text")
                                .classed("bar-label", true)
                                .attr("x", function (d, i) {
                                    return x(d.bank.bankName);
                                })
                                .attr("dx", 0)
                                .attr("y", function (d, i) {
                                    return y(d.buyingRate);
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