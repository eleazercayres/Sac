'use strict';

/**
* @ngdoc service
* @name sacolx.apiService
* @description
* # apiService
* Service in the sacolx.
*/
angular.module('sacolx')
.service('apiService', function ($http, $rootScope, API_URL) {

  return {
    account: {
      get                   : api('get', '/account/get/{msisdn}/'),
      elegible              : api('get', '/account/elegible/{msisdn}/'),
      create                : api('post', '/account/create/'),
      update                : api('put', '/account/update/'),
      verifyAnswer          : api('post', '/account/verifyAnwser/{msisdn}/'),
      checkOptin            : api('get', '/account/checkOptin/{phone}/'),
      sendQueueOptin        : api('post', '/account/sendQueueOptin/'),
      updateTerms           : api('put', '/account/updateAccountTerms/')
    },
  };

  /**
  * Cria uma function para requisição http
  *
  * @example
  *   var getVoucher = api('get', '/voucher/{voucher}');
  *   getVoucher({voucher: 'meuvoucher'}).then(success, error);
  *
  * @param  {string} method método http (get, post, delete, put, option)
  * @param  {string} url    endpoint do webservice
  * @param  {string} [host] endereço do webservice
  * @return {function}
  */
  function api (method, url, host) {
    return function (params, body) {
      var parsedUrl = angular.copy(url);
      if(params) {
        for (var p in params) {
          if (params.hasOwnProperty(p)) {
            parsedUrl = parsedUrl.replace('{' + p + '}', params[p]);
          }
        }
      }
      return $http[method]((host || API_URL) + parsedUrl, body);
    }
  }

});
