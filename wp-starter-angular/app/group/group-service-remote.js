/**
 * Created by Frosina on 28.11.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$resource'];

  function GroupServiceFn($resource) {
    return $resource('http://localhost:8080/api/groups/:id', {id:"@id"},
      {
        query: {method: "GET", isArray: true},
        save: {method: "POST"},
        get: {method: "GET"},
        remove: {method: "DELETE"},
        update: {method: "PUT"}
      }
    );

  }

})(angular);
