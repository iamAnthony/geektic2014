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
            when('/resultats', {
                templateUrl: 'results.html',
                controller: 'ResultsCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

app.controller('InterestsCtrl', function($scope, $http) {
    $http.get('/interets').success(function(showInterests) {
        $scope.showInterests = showInterests;
    });

    $scope.search = function(){

        $http.get('geek', {
            params: $scope.criteria
        }).success(function(lesGeeks) {
            $scope.lesGeeks = lesGeeks;
        });

    }
});

app.controller('ResultsCtrl', function($scope, $http) {
    $http.get('/resultats').success(function(showResults) {
        $scope.showResults = showResults;
    });
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