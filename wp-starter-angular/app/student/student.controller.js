/**
 * Created by Frosina on 17.10.2016.
 */
(function (angular) {
    'use strict';

    angular
      .module('wp-angular-starter')
      .controller('StudentController', StudentController);

    StudentController.$inject = ['$log', '$filter', 'StudentService', 'GroupService'];

    function StudentController($log, $filter, StudentService, GroupService){
      var vm = this;
      vm.entity = {};
      vm.entities = [];
      vm.groups = [];
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;
      vm.save = save;
      vm.clear = clear;
      vm.edit = edit;
      vm.remove = remove;
      vm.itemsByPage=5;
      vm.displayedPages=7;
      loadGroups();
      loadStudents();

      function loadGroups() {
        GroupService.getAll().then(function (data) {
          $log.debug(data);
          vm.groups = data;
        });
      }

      function loadStudents(){
        StudentService.getAll().then(function(data){
          vm.rowCollection = data;
          vm.entities = data;
        });
      }

      function save() {
        vm.saveOkMsg = null;
        vm.saveErrMsg = null;

        $log.debug('Saving student')

        var promise = StudentService.save(vm.entity);
        promise.then(successCallback, errorCallback);
        function successCallback(data) {
          loadStudents();
          vm.saveOkMsg = "Student with id " + data.id + " is saved";
          clear();
        }

        function errorCallback(data) {
          vm.saveErrMsg = "Saving error occurred: " + data.message;
        }
      }

      function clear() {
        vm.entity = {};
      }

      function edit(entity) {
        vm.entity = {};
        angular.extend(vm.entity, entity);
      }

      function remove(entity){
        StudentService
          .remove(entity)
          .then(function () {
            loadStudents();
          });
      }

    }
  })(angular);
