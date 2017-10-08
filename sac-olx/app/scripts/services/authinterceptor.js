'use strict';

/**
 * @ngdoc service
 * @name sacolx.authInterceptor
 * @description
 * # authInterceptor
 * Factory in the sacolx.
 */
angular.module('sacolx')
  .factory('authInterceptor', function ($q, $rootScope, $location, loadingService) {
    return {
      request: function(config) {

        if(config.url.includes('.html')) 
        loadingService.show(); 
        
        config.headers = config.headers || {};

        if(!$rootScope.config.notIncludeAccessToken) {
          config.headers['access-token'] = 'qm4mhFmIbs1wwQAWhnZWE9lMrw4XaIS432434dUcmJ';
        } else {
          $rootScope.config.notIncludeAccessToken = false;
        }

        return config;
      },
      requestError: function(rejection) {
        return $q.reject(rejection);
      },
      response: function(response) {
        return response;
      },
      responseError: function(rejection) {
        return $q.reject(rejection);
      }
    };
  });
