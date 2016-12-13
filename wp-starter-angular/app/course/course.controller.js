/**
 * Created by Frosina on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('CourseController', CourseController);

  CourseController.$inject = ['$log', '$window', '$stateParams', 'CourseService', 'StudentService', 'orderByFilter'];

  /* @ngInject */
  function CourseController($log, $window, $stateParams, CourseService, StudentService, orderBy) {
    var vm = this;
    vm.title = 'Course';
    vm.edit = edit;
    vm.remove = remove;
    vm.assignStudent = assignStudent;
    vm.propertyName = 'name';
    vm.reverse = true;
    vm.entity = {};
    vm.students = [];
    vm.courses = [];
    vm.selectedStudent = null;
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    loadCourse();
    loadCourses();
    loadStudents();

    function loadCourse() {
      var currentId = $stateParams.id;
      CourseService.getById(currentId).then(function (data) {
        vm.entity = data;
      });
    }

    function loadCourses(){
      CourseService.getAll().then(function(data){
        vm.courses = data;
      });
    }

    function loadStudents(){
      var students;
      StudentService.getAll().then(function (data) {
        vm.students = data;
      });
    }

    function remove() {
      CourseService.remove(vm.entity).then(function () {
        $window.location.href = '/#/courses';
      });
    }

    function edit(entity) {
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function assignStudent(){
      if(vm.selectedStudent == null) return;

      var studentCourseAssotiation = {
        course: vm.entity,
        student: vm.selectedStudent
      };
      StudentService.addCourse(studentCourseAssotiation).then(function (){
        console.log("Adding course");
        loadStudents();
      });
    }
  }

})(angular);

