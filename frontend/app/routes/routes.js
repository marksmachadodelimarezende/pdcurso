(function () {
    'use strict';
    angular
        .module("pdCurso")
        .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/contato', {
                templateUrl: 'app/views/contato/contato.html',
                controller: 'ContatoController',
                // resolve: {
                //     // I will cause a 1 second delay
                //     delay: function ($q, $timeout) {
                //         var delay = $q.defer();
                //         $timeout(delay.resolve, 1000);
                //         return delay.promise;
                //     }
                // }
            })
            .when('/operadora', {
                template: '<strong>Teste operadora</strong>'
                //templateUrl: 'app/views/operadora/operadora.html',
                //controller: 'OperadoraController'
            })
            .otherwise({redirectTo: '/contato'});
    }]);
})();
