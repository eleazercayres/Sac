'use strict';

/**
 * @ngdoc function
 * @name sacolx.controller:mainJsonDataCtrl
 * @description
 * # mainJsonDataCtrl
 * Controller of the sacolx
 */

angular.module('sacolx')
  .filter('to_trusted', ['$sce', function($sce){
      return function(text) {
          return $sce.trustAsHtml(text);
      };
  }]);

angular.module('sacolx')
  .controller('mainJsonDataCtrl', function ($scope, $rootScope, $sce, $location, $window, apiService) {


});