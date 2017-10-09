'use strict';

/**
 * @ngdoc function
 * @name sacolx.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sacolx
 */
angular.module('sacolx')
  .controller('RelatorioController', function ($scope, $rootScope, $location, $window, apiService, loadingService) { 

    $rootScope.calls;

    apiService.attendace.get().then(function (res) {
      if (res.data != null) {
        $rootScope.calls = res.data;
      }
    }, function (err) {
        console.log(err);
    });
    
});