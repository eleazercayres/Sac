'use strict';

/**
 * @ngdoc function
 * @name sacolx.controller:ErrorpageCtrl
 * @description
 * # ErrorpageCtrl
 * Controller of the sacolx
 */
angular.module('sacolx')
  .controller('ErrorpageCtrl', function ($scope, $location, apiService, loadingService) { 

    loadingService.hide(); 
    apiService.ga.pageview();

    $scope.error = null;

  });
