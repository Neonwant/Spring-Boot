var app = angular.module("springDemo", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.websites = [];

    $http({
        method: 'GET',
        url: 'http://localhost:8099/api/stackoverflow'
    }).then(function (success) {
        console.log(success, 'data');
        $scope.websites = success.data;
    }, function (error) {
        console.log(error, 'can`t get data');
    });

});