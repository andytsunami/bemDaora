var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'pages/sobre',
    controller  : 'HomeController'
  })

  .when('/vagas', {
    templateUrl : 'pages/vagas',
    controller  : 'BlogController'
  })

  .when('/fotos', {
    templateUrl : 'pages/fotos',
    controller  : 'AboutController'
  })
  .when('/feed', {
    templateUrl : 'pages/feed',
    controller  : 'AboutController'
  })

  .otherwise({redirectTo: '/'});
});

/*
app.controller('HomeController', function($scope) {
  $scope.message = 'Hello from HomeController';
});

app.controller('BlogController', function($scope) {
  $scope.message = 'Hello from BlogController';
});

app.controller('AboutController', function($scope) {
  $scope.message = 'Hello from AboutController';
});*/
