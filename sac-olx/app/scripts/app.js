'use strict';

/**
 * @ngdoc overview
 * @name sacolx
 * @description
 * # sacolx
 *
 * Main module of the application.
 */
angular
  .module('sacolx', [
    'ngAnimate',
    'ngResource',
    'ngRoute',
    'ui.mask'
  ])
  .constant('API_URL', 'https://localhost:8080/')
  .config(function ($routeProvider, $locationProvider, $sceDelegateProvider, $httpProvider) {
	  
    $httpProvider.interceptors.push('authInterceptor');

    $locationProvider.hashPrefix('');
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main/'
      })
//      .when('/about', {
//        templateUrl: 'views/about.html',
//        controller: 'AboutCtrl',
//        controllerAs: 'about'
//      })
//      .when('/errorPage', {
 //       templateUrl: 'views/errorpage.html',
  //      controller: 'ErrorpageCtrl',
   //     controllerAs: 'errorPage'
    //  })
      .otherwise({
        redirectTo: '/'
      });
  })
  .run(function ($rootScope, $window) { 
    
       $rootScope.$on('$locationChangeStart', function () {  
    
  }); 
    $rootScope.config = {
      hideLoading:false
    };
  });
