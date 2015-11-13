define([ 'app', 'angularAMD', 'ranking/RankingController' ], function(app, angularAMD) {

    var $scope, controller;

    angularAMD.inject(function($rootScope, $controller) {
        $scope = $rootScope.$new();
        controller = $controller('RankingController', {
            '$scope' : $scope
        });
    });

    // Descricao de um cenario de teste
    describe("Deve iniciar o controller com ranking e rankingDescricao como JSONs", function() {

        it("ranking não deve estar null ou undefined", function() {
            expect($scope.ranking).not.toBe(null);
            expect($scope.ranking).not.toBe(null);
        });

    });

});
