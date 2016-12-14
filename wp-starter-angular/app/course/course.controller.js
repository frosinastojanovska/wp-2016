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
    vm.assignedStudents = [];
    vm.courses = [];
    vm.selectedStudent = null;
    vm.OkMsg = null;
    vm.ErrMsg = null;
    loadCourse();
    loadAssignedStudents();
    loadCourses();
    loadUnAssignedStudents();

    function loadCourse() {
      var currentId = $stateParams.id;
      CourseService.getById(currentId).then(function (data) {
        vm.entity = data;
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function loadAssignedStudents() {
      var currentId = $stateParams.id;
      console.log("Uspesno vleze");
      CourseService.getAssignedStudents(currentId).then(function (data) {
        vm.assignedStudents = data;
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function loadCourses(){
      CourseService.getAll().then(function(data){
        vm.courses = data;
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function loadUnAssignedStudents(){
      var currentId = $stateParams.id;
      console.log("Uspesno vleze");
      CourseService.getUnassignedStudents(currentId).then(function (data) {
        vm.unassignedStudents = data;
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function remove() {
      CourseService.remove(vm.entity).then(function () {
        $window.location.href = '/#/courses';
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function edit() {
      CourseService.update(vm.entity).then(function () {
        vm.OkMsg = "Course updated.";
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }

    function assignStudent(){
      if(vm.selectedStudent == null) return;

      var studentCourseAssotiation = {
        course: vm.entity,
        student: vm.selectedStudent
      };
      StudentService.addCourse(studentCourseAssotiation).then(function (){
        vm.OkMsg = "Student assigned to course";
        loadAssignedStudents();
        loadUnAssignedStudents();
      }, function (response) {
        vm.ErrMsg = "Error occurred: " + response.data.ex;
      });
    }
  }

})(angular);

