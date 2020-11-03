(function () {
    'use strict';

    //Aqui procura-se um modulo criado para injecao de controllers, services, diretivas ...
    angular.module("pdCurso")
        .controller("ContatoController", ContatoController);

    /*@ngInject*/
    function ContatoController($scope, $filter, uppercaseFilter, dateFilter) {
        $scope.app = "PdCurso - AngularJs";
        $scope.contatos = [
            {nome: $filter('uppercase')("Pedro"), telefone: "818283845", data: dateFilter(new Date(), 'dd/MM/yyyy'), operadora: "TIM", selecionado: false},
            {nome: uppercaseFilter("Laura"), telefone: "121314151", data: dateFilter(new Date(), 'dd/MM/yyyy'), operadora: "Vivo"},
        ];
        $scope.operadoras = [
            {codigo: 15, nome: "Vivo", categoria: "Móvel", preco: 1111},
            {codigo: 41, nome: "TIM", categoria: "Móvel", preco: 0.5},
            {codigo: 14, nome: "Oi", categoria: "Móvel", preco: 1.2},
            {codigo: 21, nome: "Embratel", categoria: "Fixo", preco: 0.35},
        ];

        /* Jeito de adicionar dados na grid não praticavel.
               Devemos sempre inserir dados no scope, dentro do scrip controller JS
               (MANTRA DE BOAS PRATICAS) */
        // $scope.adicionarContato = function () {
        //     $scope.contatos.push({nome: $scope.nome, telefone: $scope.telefone});
        // }

        $scope.setMaximizedWindow = function (isMaximized) {
            $scope.isMaximizedWindow = isMaximized || false;
        };
        $scope.adicionarContato = function (contato) {
            $scope.contatos.push(angular.copy(contato));
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
        };
        $scope.alterarContato = function (contato) {
            console.log('Alterando', contato);
        };
        $scope.editarContato = function (contato) {
            $scope.contato = angular.copy(contato);
            $scope.isEditandoRegistro = true;
        };
        $scope.apagarContatos = function (contatos) {
            $scope.contatos = contatos.filter(function (contato) {
                if (!contato.selecionado) return contato;
            });
        };
        $scope.excluirContato = function (contato) {
            contato.selecionado = true;
            $scope.apagarContatos($scope.contatos);
        };
        $scope.isContatoSelecionado = function (contatos) {
            return contatos.some(function (contato) {
                return contato.selecionado;
            });
        };
        $scope.ordenarTabelaPor = function (campo) {
            $scope.criterioOrdenacao = campo;
            $scope.criterioReverse = !$scope.criterioReverse;

        };
        $scope.limparForm = function () {
            delete $scope.contato;
            $scope.isEditandoRegistro = false;
        };
    }
})();
