var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'welcome.html',
                controller: 'InterestsCtrl'
            }).
            when('/geek/:id', {
                templateUrl: 'geek_details.html',
                controller: 'GeekCtrl'
            }).
            when('/geek', {
                templateUrl: 'all_geeks.html',
                controller: 'AllGeekCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

app.controller('InterestsCtrl', function($scope, $http) {
    $scope.myForm = {};
    $scope.myForm.sexe = "H";
    $scope.montrerTableau = false;

    $http.get('/interets').success(function (showInterests) {
        $scope.showInterests = showInterests;
    });

    $scope.myForm.submitTheForm = function (item, event) {
        console.log("--> Submitting form");
        console.log("interets : "+$scope.myForm.interets);
        $http.get('/geek', {
            params: {sexe: $scope.myForm.sexe, interets: $scope.myForm.interets}
        }).success(function(showResults) {
            $scope.showResults = showResults;
        })
    };
});

app.controller('GeekCtrl', function($scope, $http, $location, $routeParams) {
    $http.get('/geek/' + $routeParams.id).success(function (showGeek) {
        $scope.showGeek = showGeek;
    }).error(function (){
        $location.url('/geek');
    });
});

app.controller('AllGeekCtrl', function($scope, $http) {
    $http.get('/geek').success(function(allGeeks) {
        $scope.allGeeks = allGeeks;
    });
});