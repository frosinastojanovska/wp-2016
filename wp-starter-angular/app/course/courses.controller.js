/**
 * Created by Frosina on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('CoursesController', CoursesController);

  CoursesController.$inject = ['$log', 'CourseService', 'orderByFilter'];

  /* @ngInject */
  function CoursesController($log, CourseService, orderBy) {
    var vm = this;
    vm.title = 'Courses';
    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;
    vm.sortBy = sortBy;
    vm.propertyName = 'name';
    vm.reverse = true;
    vm.entity = {};
    vm.entities = [];
    vm.OkMsg = null;
    vm.ErrMsg = null;
    loadCourses();

    function loadCourses() {
      CourseService.getAll().then(function (data) {
        vm.entities = data;
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function remove(entity) {
      CourseService.remove(entity).then(function () {
        loadCourses();
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function save() {
      vm.OkMsg = null;
      vm.ErrMsg = null;

      var promise = CourseService.save(vm.entity);
      promise.then(successCallback, errorCallback);

      function successCallback(data) {
        loadCourses();
        vm.OkMsg = "Course with id " + data.id + " is saved";
        clear();
      }

      function errorCallback(response) {
        vm.ErrMsg = "Saving error occurred: " + response.data.ex;
      }
    }

    function clear() {
      vm.entity = {};
    }

    function edit(entity) {
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function sortBy(propertyName) {
      vm.reverse = (vm.propertyName === propertyName) ? !vm.reverse : false;
      vm.propertyName = propertyName;
      vm.entities = orderBy(vm.entities, vm.propertyName, vm.reverse);
      $log.debug(vm.propertyName);
    };
  }

})(angular);

