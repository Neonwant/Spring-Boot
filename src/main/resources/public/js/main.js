var app = angular.module("springDemo", []);

app.controller("AppCtrl", function ($scope) {
    $scope.websites = [{
        iconImageUrl: '',
        id: 'stackoverflow',
        website: 'stackoverflow.com',
        title: 'StackOverflow webiste',
        description: 'StackOverflow description'
    }];

});
