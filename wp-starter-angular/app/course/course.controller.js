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
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    loadCourse();
    loadAssignedStudents();
    loadCourses();
    loadStudents();

    function loadCourse() {
      var currentId = $stateParams.id;
      CourseService.getById(currentId).then(function (data) {
        vm.entity = data;
      });
    }

    function loadAssignedStudents() {
      var currentId = $stateParams.id;
      console.log("Uspesno vleze");
      CourseService.getAssignedStudents(currentId).then(function (data) {
        vm.assignedStudents = data;
      });
    }

    function loadCourses(){
      CourseService.getAll().then(function(data){
        vm.courses = data;
      });
      vm.courses.splice(vm.entity, 1);
    }

    function loadStudents(){
      StudentService.getAll().then(function (data) {
        vm.students = data;
      });
      for (var i = vm.assignedStudents.length -1; i >= 0; i--)
        vm.students.splice(assignedStudents[i],1);
    }

    function remove() {
      CourseService.remove(vm.entity).then(function () {
        $window.location.href = '/#/courses';
      });
    }

    function edit() {
      CourseService.update(vm.entity).then(function () {

      });
    }

    function assignStudent(){
      if(vm.selectedStudent == null) return;

      var studentCourseAssotiation = {
        course: vm.entity,
        student: vm.selectedStudent
      };
      StudentService.addCourse(studentCourseAssotiation).then(function (){
        loadAssignedStudents();
      });
    }
  }

})(angular);

