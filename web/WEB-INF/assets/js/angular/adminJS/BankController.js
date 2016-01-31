admin.controller("BankController", function ($scope,$location, $http, adminFactory) {


    adminFactory.getAllBanks().then(function (response) {
        $scope.banks = response.data.allBanks;
    });

    $scope.toggleAddBankForm = function () {
        $scope.addBank = $scope.addBank === false ? true : false;
    };
    $scope.addNewBank = function () {
//        $scope.banks.push({'bankName': $scope.bankName, 'address': $scope.address, 'contactNo': $scope.contactNo, 'website': $scope.website});
//        var dataObj = {"newBank":{"bankName": $scope.bankName,"address": $scope.address,"contactNo": $scope.contactNo,"website":$scope.website}};
        
        $scope.banks.push($scope.bank);
        console.log($scope.bank);
        
        $http.post("http://localhost:8080/ForexNepal/admin/banks/save_bank",$scope.bank).then(function(response){
           alert(response);
        });
        
//      banksFactory.create(dataObj);
        
//        $http.post("http://localhost:8080/ForexNepal/admin/banks/save_bank",dataObj)
//                .success(function (data, status, headers, config) {
//                    console.log(data);
//                })
//                .error(function (data, status, header, config) {
//                    $scope.responseMsg = "error";
//                });

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