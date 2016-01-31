/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

admin.controller("DashboardController", function ($scope, $http) {
    
    $scope.scrapAll = function () {

        $http.get("http://localhost:8080/ForexNepal/admin/bank/scrap_all").then(function (data) {
            var arr=Object.keys(data);
//            console.log(arr);
            alert(data["data"]["message"]);
            
                
            
        });


    };
});

admin
        .controller('DateTimeController', ['$scope', '$interval',
            function ($scope, $interval) {
                $scope.format = 'M/d/yy h:mm:ss a';
            }])
        .directive('myCurrentTime', ['$interval', 'dateFilter',
            function ($interval, dateFilter) {
                // return the directive link function. (compile function not needed)
                return function (scope, element, attrs) {
                    var format, stopTime;
                    ; // date format


                    // used to update the UI
                    function updateTime() {
                        element.text(dateFilter(new Date(), format));
                    }

                    // watch the expression, and update the UI on change.
                    scope.$watch(attrs.myCurrentTime, function (value) {
                        format = value;
                        updateTime();
                    });
                    stopTime = $interval(updateTime, 1000);

                    // listen on DOM destroy (removal) event, and cancel the next UI update
                    // to prevent updating time after the DOM element was removed.
                    element.on('$destroy', function () {
                        $interval.cancel(stopTime);
                    });
                };
            }
        ]);