var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'welcome.html',
            }).
            when('/geek/:id', {
                templateUrl: 'geek_details.html',
                controller: 'GeekCtrl'
            }).
            when('/resultats', {
                templateUrl: 'results.html',
                controller: 'ResultsCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

app.controller('ResultsCtrl', function($scope, $http) {
    $http.get('/resultats').success(function(showResults) {
        $scope.showResults = showResults;
    });
});

app.controller('GeekCtrl', function($scope, $http, $routeParams) {
    $http.get('/geek/' + $routeParams.id).success(function (showGeek) {
        $scope.showGeek = showGeek;
    });
});