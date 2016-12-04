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
    var resource = $resource('http://localhost:8000/api/groups/:id', {},
      {
        update: {method: "PUT"}
      }
    );
    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };

    return service;

    function getAllFn() {
      return resource.query().$promise;
    }

    function removeFn(entity){
      return resource.remove({id: entity.id}).$promise;
    }

    function saveFn(entity){
      if(entity.id === undefined) {
        return resource.save(entity, function(data){
          entity.id=data.id;
        }).$promise;
      }
      return updateFn(entity);
    }

    function getByIdFn(id){
      return resource.get(id).$promise;
    }

    function updateFn(entity) {
      if (entity.id === undefined) {
        return saveFn(entity);
      }
      return resource.update({id: entity.id}, entity).$promise;

    }

  }

})(angular);
