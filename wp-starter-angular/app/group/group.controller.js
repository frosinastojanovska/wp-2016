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
      GroupService.query(function(data) {
        vm.entities=data;
        $log.debug(data);
      });
    }

    function remove(entity) {
      $log.debug(entity);
      GroupService.remove({id: entity.id}, function(data){
        loadGroups();
      });
    }

    function save() {
      var entity = vm.entity;
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      if(entity.id != null) {
        editEntity(entity);
        return;
      }

        GroupService.save(entity, function (data) {
          loadGroups();
          vm.saveOkMsg = "Group with id " + data.id + " is saved";
          clear();
        }, function (data) {
          vm.saveErrMsg = "Saving error occurred: " + data.message;
        });
    }

    function editEntity(entity){
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      GroupService.update({id: entity.id}, entity, function (data) {
        loadGroups();
      }, function (data) {

      });
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

