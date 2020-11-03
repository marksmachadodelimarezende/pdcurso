(function () {
    'use strict';

    angular.module("pdCurso")
        .controller("OperadoraController", ['$scope', OperadoraController]);

    /*@ngInject*/
    function OperadoraController($scope, $route, $routeParams, $location) {
        var scope = $scope;

        scope.titlePage = "Cadastro de operadoras telefonicas";
    }
})();
