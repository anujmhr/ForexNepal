admin.controller("BankController", function ($scope, $http) {

    $http.get("http://localhost:8080/ForexNepal/admin/all_banks")
            .then(function (response) {
                $scope.banks = response.data.allBanks;
            });

    $scope.toggleAddBankForm = function () {
        $scope.addBank = $scope.addBank === false ? true : false;
    };
    $scope.addNewBank = function () {
        $scope.banks.push({'bankName': $scope.bankName, 'address': $scope.address, 'contactNo': $scope.contactNo, 'website': $scope.website});
        var dataObj = "bankName:"+ $scope.bankName+",address:"+$scope.address+",contactNo:"+$scope.contactNo+",website:"+$scope.website;

        
        
        $http.post("http://localhost:8080/ForexNepal/admin/saveBank", dataObj)
                .success(function (data, status, headers, config) {
                    console.log(data);
                })
                .error(function (data, status, header, config) {
                    $scope.responseMsg = "error";
                });

    };

    $scope.removeRow = function (name) {
//        var index = -1;
//        var comArr = eval($scope.banks);
//        for (var i = 0; i < comArr.length; i++) {
//            if (comArr[i].name === name) {
//                index = i;
//                break;
//            }
//        }
//        if (index === -1) {
//            alert("Something gone wrong");
//        }
//        $scope.banks.splice(index, 1);
    };

});