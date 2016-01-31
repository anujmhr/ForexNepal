home.controller("HomeCurrencyController", function ($scope,exchangeRateFactory) {
//    exchangeRateFactory.getCurrencyList().then(function (response) {
//        $scope.currencyList = response.data.currencyList;
//    });
//
//    exchangeRateFactory.getAllDates().then(function (response) {
//        $scope.dateList = response.data.forexDates;
//    });
//
//   // exchangeRateFactory.getLatestDateTime();
//
//
//    $scope.populateTime = function (byDate) {
//
//        $http.get("http://localhost:8080/ForexNepal/exchange_rates/time_by_date/" + byDate)
//                .then(function (response) {
//                    $scope.timeList = response.data.timeByDate;
//                });
//    };

$scope.message="HomeCurrencyController";

});//currencyy controller

