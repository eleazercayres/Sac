'use strict';

/**
 * @ngdoc function
 * @name sacolx.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sacolx
 */
angular.module('sacolx')
  .controller('MainCtrl', function ($scope, $rootScope, apiService, loadingService, $interval) { 

    $rootScope.reasons;
    $rootScope.types;
    $rootScope.states;
    
    $scope.type;
    $scope.state;
    $scope.reason;
    $scope.detalhes;

    var callDTO = function(detalhes, reason, state, type) {
       this.date            =  new Date();
       this.detalhes        =  detalhes;
       this.reason          =  reason;
       this.state           =  state;
       this.type            =  type;
     };

    $scope.salvar = function() {
    
    loadingService.show();
    var call = new callDTO($scope.detalhes, $scope.reason, $scope.state, $scope.type);
      apiService.attendace.create(null, call).then(function (res) {
        console.log("Salvo");
        $scope.type = {};
        $scope.state = {};
        $scope.reason = {};
        $scope.detalhes = "";
        $scope.success = true;
        $scope.Timer = $interval(function () {
          $scope.success = false;
        }, 2000);
        loadingService.hide();
      }, function (err) {
          loadingService.hide();
          console.log(err);
      });
    }

    apiService.reason.get().then(function (res) {
      if (res.data != null) {
        $rootScope.reasons = res.data;
      }
    }, function (err) {
        console.log(err);
    });

    apiService.type.get().then(function (res) {
      if (res.data != null) {
        $rootScope.types = res.data;
      }
    }, function (err) {
        console.log(err);
    });
     
    apiService.state.get().then(function (res) {
      if (res.data != null) {
        $rootScope.states = res.data;
      }
    }, function (err) {
        console.log(err);
    });
    
  });
