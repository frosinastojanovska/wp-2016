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
    return $resource('http://localhost:8000/api/groups/:id', {},
      {
        update: {method: "PUT"}
      }
    );

  }

})(angular);
