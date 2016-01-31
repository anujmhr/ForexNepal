var home = angular.module('main-app', ['ngRoute', 'ngResource']);

home.config(['$httpProvider', function ($httpProvider) {
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
    }]);

home.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'ForexNepal/currency',
        controller: 'HomeCurrencyController'
    }).when('/buying_rate', {
        templateUrl: 'ForexNepal/currency/buying_rate',
        controller: 'CurrencyBuyingRates'
    }).when('/selling_rate', {
        templateUrl: 'ForexNepal/currency/selling_rate',
        controller: 'CurrencySellingRates'
    }).when('/bank', {
        templateUrl: 'ForexNepal/bank',
        controller: 'HomeBankController'
    }).when('/bank/buying_rate', {
        templateUrl: 'ForexNepal/bank/buying_rate',
        controller: 'BankBuyingRates'
    }).when('/bank/selling_rate', {
        templateUrl: 'ForexNepal/bank/selling_rate',
        controller: 'BankSellingRates'
    }).otherwise({
        redirectTo: '/'
    });



});

home.factory("exchangeRateFactory", function ($http) {
    var obj = {};
 
    obj.getBankList=function(){
        return $http.get("http://localhost:8080/ForexNepal/exchange_rates/bank_list");
    };
    obj.getCurrencyList = function () {
        return $http.get("http://localhost:8080/ForexNepal/exchange_rates/currency_list");

    };

    obj.getAllDates = function () {
        return $http.get("http://localhost:8080/ForexNepal/exchange_rates/all_dates");
    };

    return obj;
});

