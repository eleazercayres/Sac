'use strict';

/**
 * @ngdoc service
 * @name sacolx.alertMessageService
 * @description
 * # alertMessageService
 * Service in the sacolx.
 */
angular.module('sacolx')
  .service('alertMessageService', function ($timeout) {
    return {
      show: show
    };

    function show(code, closeOnTap, wait) {
      var element = $('.alert-message');
      function showAlert(message) {
        element.html(message);
        element.removeClass('ng-hide hide');
        if(closeOnTap) {
          element.on('click', function () {
            element.addClass('hide');
          });
        }
        if(wait) {
          $timeout(function () {
            element.addClass('hide');
          }, wait);
        }
      }
    }

  });
