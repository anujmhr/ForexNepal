var admin = angular.module('admin', ['ngRoute']);
//



admin.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/', {
        templateUrl: 'admin/dashboard',
        controller: 'DashboardController'
    }).when('/banks', {
        templateUrl: 'admin/banks',
        controller: 'BankController'
    }).when('/exchangeRates', {
        templateUrl: 'admin/exchangeRates',
        controller: 'ExchangeRatesController'
    }).when('/currency', {
        templateUrl: 'admin/currency',
        controller: 'CurrencyController'
    }).otherwise({
        redirectTo: '/'
    });
//    $locationProvider.html5Mode({
//        enabled: true,
//        requireBase: false
//    });

});



