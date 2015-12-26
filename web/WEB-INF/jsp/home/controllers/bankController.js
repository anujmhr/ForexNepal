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
