/**
 * Created by Frosina on 24.10.2016.
 */
(function (angular) {
  'use strict';

  function WpInputController($attrs, $log){
    this.wpLabel = $attrs.wpLabel;
    this.wpType = $attrs.wpType;
    this.wpRequired = $attrs.wpRequired;
    $log.debug($attrs);
  }

  WpInputController.$inject = ['$attrs', '$log'];

  angular
    .module('wp-angular-starter')
    .component('wpInput', {
      templateUrl: "app/component/wp-input/wp-input.component.html",
      controller: WpInputController,
      bindings: {
        wpModel: '=',
        wpFocus: '='
      }
    });

})(angular);
