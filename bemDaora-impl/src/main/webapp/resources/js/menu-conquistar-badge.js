var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'pages/conquistas',
    controller  : 'HomeController'
  })

  .when('/comprar', {
    templateUrl : 'pages/comprar',
    controller  : 'BlogController'
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
