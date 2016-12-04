(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('GroupController', GroupController);

  GroupController.$inject = ['$log', 'GroupService', 'orderByFilter'];

  /* @ngInject */
  function GroupController($log, GroupService, orderBy) {
    var vm = this;
    vm.title = 'Group';
    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;
    vm.sortBy = sortBy;
    vm.propertyName = 'name';
    vm.reverse = true;
    vm.entity = {};
    vm.entities = [];
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    vm.availableSizes = [20, 40];
    loadGroups();

    function loadGroups() {
      GroupService.getAll().then(function (data) {
        vm.entities = data;
      });
    }

    function remove(entity) {
      GroupService.remove(entity).then(function () {
        loadGroups();
      });
    }

    function save() {
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      var promise = GroupService.save(vm.entity);
      promise.then(successCallback, errorCallback);

      function successCallback(data) {
        loadGroups();
        vm.saveOkMsg = "Group with id " + data.id + " is saved";
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

    function sortBy(propertyName) {
      vm.reverse = (vm.propertyName === propertyName) ? !vm.reverse : false;
      vm.propertyName = propertyName;
      vm.entities = orderBy(vm.entities, vm.propertyName, vm.reverse);
      $log.debug(vm.propertyName);
    };
  }

})(angular);

