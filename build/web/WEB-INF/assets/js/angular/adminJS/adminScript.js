var admin = angular.module('admin', ['ngRoute','ngResource']);

admin.config(['$httpProvider', function ($httpProvider) {    
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
}]);

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

admin.factory("adminFactory",function($http){
   var obj={};
   obj.getAllBanks=function(){
     return $http.get("http://localhost:8080/ForexNepal/admin/banks/all_banks");
   };
   
   return obj;
   
});

//admin.factory("banksFactory",function($resource){
//    return $resource('http://localhost:8080/ForexNepal/admin/banks', {}, {
//        query: { method: 'GET', isArray: true },
//        create: { method: 'POST' }
//    });
//
//});
//
//admin.factory('bankFactory', function ($resource) {
//    return $resource('http://localhost:8080/ForexNepal/admin/banks/', { id: '@_id' }, {
//        show: { method: 'GET' },
//        update: { method: 'PUT', params: {id: '@id'} },
//        delete: { method: 'DELETE', params: {id: '@id'} }
//    });
//}); 



