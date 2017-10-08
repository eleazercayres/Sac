'use strict';

/**
 * @ngdoc service
 * @name sacolx.loadingService
 * @description
 * # loadingService
 * Service in the sacolx.
 */
angular.module('sacolx')
  .service('loadingService', function ($rootScope) {

    var element = $('.loading');

    return {
      show: show,
      hide: hide
    };

    function show() {
      element.removeClass('ng-hide');
    }

    function hide() {
      element.addClass('ng-hide');
    }

  });
