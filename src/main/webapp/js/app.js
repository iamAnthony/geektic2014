var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'welcome.html',
                controller: 'IndexCtrl'
            }).
            when('/geek/:id', {
                templateUrl: 'geek_details.html',
                controller: 'GeekCtrl'
            }).
            when('/resultats', {
                templateUrl: 'results.html',
                controller: 'ResultsCtrl'
            })
            otherwise({
                redirectTo: '/'
            });
    }]);

app.controller('IndexCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('ResultsCtrl', function($scope, $http) {
    $http.get('/api/resultats').success(function(showResults) {
        $scope.showResults = showResults;
    });
});

app.controller('GeekCtrl', function($scope, $http, $routeParams) {
    $http.get('api/geek/' + $routeParams.id).success(function (showGeek) {
        $scope.showGeek = showGeek;
    });
});