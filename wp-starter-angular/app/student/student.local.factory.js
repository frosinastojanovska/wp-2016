/**
 * Created by Frosina on 17.10.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('StudentService', StudentServiceFn);

  StudentServiceFn.$inject = ['$log', '$timeout', '$q', '$localStorage'];

  function StudentServiceFn($log, $timeout, $q, $localStorage) {
    $localStorage.studentsList = $localStorage.studentsList || [];
    $localStorage.studentIdSequence = $localStorage.studentIdSequence || 0;

    var service = {
      save: saveFn,
      update: updateFn,
      getAll: getAllFn,
      getById: getByIdFn,
      remove: removeFn
    };

    return service;

    function saveFn(entity) {
      var entityForSave, errorMessage;
      var deferred = $q.defer();

      $log.debug(entity);

      if (entity.id === undefined) {
        $timeout(function () {
          entityForSave = angular.copy(entity);
          errorMessage = validateStudent(entityForSave);
          if (errorMessage === null) {
            entityForSave.id = ++$localStorage.studentIdSequence;
            $localStorage.studentsList.push(entityForSave);
            $log.debug('saving student', entityForSave);
            deferred.resolve(entityForSave);
          } else {
            $log.debug('saving invalid:', errorMessage);
            deferred.reject({
              message: errorMessage
            });
          }
        }, 100);
        return deferred.promise;
      } else {
        return updateFn(entity);
      }
      $log.debug('in save fn');
    }

    function validateStudent(entity) {
      if (entity.name === null
        || entity.name === undefined
        || typeof entity.name !== 'string'
        || entity.name.length === 0) {
        return 'Invalid name';
      }
      if (entity.surname === null
        || entity.surname === undefined
        || typeof entity.surname !== 'string'
        || entity.surname.length === 0) {
        return 'Invalid surname';
      }
      if (entity.index === null
        || entity.index === undefined
        || typeof entity.index !== 'number'
        || entity.index.length === 0) {
        return 'Select index';
      }
      if (entity.group.name === null
        || entity.group.name === undefined
        || typeof entity.group.name !== 'string'
        || entity.group.name.length === 0) {
        return 'Invalid group selection';
      }
      return null;
    }

    function updateFn(entity) {
      var deferred = $q.defer();
      if (entity.id === undefined) {
        return saveFn(entity);
      } else {
        $timeout(function () {
          getByIdFn(entity.id)
            .then(function (savedEntity) {
              angular.extend(savedEntity, entity);
              $log.debug("merged entity", savedEntity);
              $log.debug('updating', savedEntity);
              deferred.resolve(savedEntity);
            });

        }, 100);
        return deferred.promise;
      }
    }

    function getByIdFn(studentId) {
      var index;
      var deferred = $q.defer();


      $timeout(function () {
        $log.debug('get by id: ', studentId);
        index = findIndexById(studentId);
        if (index === -1) {
          deferred.resolve(null);
        } else {
          deferred.resolve($localStorage.studentsList[index]);
        }
      }, 100);
      return deferred.promise;

    }

    function findIndexById(studentId) {
      var result = -1, item;

      $log.debug('get index by id: ', studentId);
      for (var i = 0; i < $localStorage.studentsList.length; i++) {
        item = $localStorage.studentsList[i];
        if (item.id === studentId) {
          result = i;
          break;
        }
      }
      return result;
    }

    function getAllFn() {
      var entities;
      var deferred = $q.defer();
      $timeout(function () {
        $log.debug('getAllStudents');
        deferred.resolve(angular.copy($localStorage.studentsList));
      }, 100);
      return deferred.promise;
    }

    function removeFn(entity) {
      var deferred = $q.defer();
      $timeout(function () {
        var index = findIndexById(entity.id);
        if (index !== -1) {
          $localStorage.studentsList.splice(index, 1);
        }
        $log.debug('remove', entity);
        deferred.resolve();
      }, 100);
      return deferred.promise;

    }
  }
})(angular);
