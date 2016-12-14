/**
 * Created by Frosina on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('CourseService', CourseServiceFn);

  CourseServiceFn.$inject = ['$resource'];

  function CourseServiceFn($resource) {
    var resource = $resource('/api/courses/:id', {},
      {
        update: {method: "PUT"},
        getAssignedStudents: {method: "GET", url:'/api/courses/:id/assignedStudents', isArray: true}
      }
    );
    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn,
      getAssignedStudents: getAssignedStudentsFn
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
      return resource.get({id: id}).$promise;
    }

    function updateFn(entity) {
      if (entity.id === undefined) {
        return saveFn(entity);
      }
      return resource.update({id: entity.id}, entity).$promise;

    }

    function getAssignedStudentsFn(id) {
      return resource.getAssignedStudents({id: id}).$promise;
    }

  }

})(angular);
