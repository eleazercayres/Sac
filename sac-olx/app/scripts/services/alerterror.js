'use strict';

/**
 * @ngdoc service
 * @name sacolx.alertErrorService
 * @description
 * # alertErrorService
 * Service in the sacolx.
 */
angular.module('sacolx')
  .service('alertErrorService', function ($timeout) {
    return {
      show: show
    };

    function show(code, closeOnTap, wait) {
      var element = $('.alert-error');
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
