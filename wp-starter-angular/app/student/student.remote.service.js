(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('StudentService', StudentServiceFn);

  StudentServiceFn.$inject = ['$resource'];

  function StudentServiceFn($resource) {
    var resource = $resource('/api/students/:id', {},
      {
        update: {method: "PUT"},
        addCourse: {method: "POST", url: '/api/students/addCourse'}
      }
    );

    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn,
      addCourse: addCourseFn
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

    function addCourseFn(studentCourseAssociation) {
      return resource.addCourse(studentCourseAssociation).$promise;
    }

  }

})(angular);
