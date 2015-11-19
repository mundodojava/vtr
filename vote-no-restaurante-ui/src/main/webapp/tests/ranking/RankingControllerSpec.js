define([ 'app', 'angularAMD', 'ranking/RankingController' ], function(app, angularAMD) {

    var $scope, $routeParams, controller;
	var inject = angularAMD.inject;

    inject(function($rootScope, $controller, $routeParams) {
        $scope = $rootScope.$new();
		jQuerySpy = spyOn(window, '$');
        controller = $controller('RankingController', {
            '$scope' : $scope,
            '$routeParams' : $routeParams
        });
		
    });

    // Descricao de um cenario de teste
    describe("Deve iniciar o controller com ranking e rankingDescricao como JSONs", function() {
		
		beforeEach(function(){
			module("ngRoute");
			inject(function(_$routeParams_){
				$routeParams = _$routeParams_;
			})		
		});
	
        it("ranking não deve estar null ou undefined", function() {
            expect($scope.ranking).not.toBeNull();
            expect($scope.ranking).not.toBeUndefined();
        });
		
		it("rankingDescricao não deve estar null ou undefined", function() {
            expect($scope.rankingDescricao).not.toBeNull();
            expect($scope.rankingDescricao).not.toBeUndefined();
        });
		
		it("rankingDescricao deve conter ranking preco rapidez atendimento sabor localizacao custobeneficio", function() {			
			 expect($scope.rankingDescricao.preco).toBeDefined();
			 expect($scope.rankingDescricao.rapidez).toBeDefined();
			 expect($scope.rankingDescricao.atendimento).toBeDefined();
			 expect($scope.rankingDescricao.sabor).toBeDefined();
			 expect($scope.rankingDescricao.localizacao).toBeDefined();
			 expect($scope.rankingDescricao.custobeneficio).toBeDefined();
        });
		
		it("deve capturar o tipo do ranking", function() {			
			 $routeParams.tipoRanking = 'preco';
			 spyOn($("#vote")).and.returnValue("<div></div>");
			 $scope.init();
			 expect( $scope.ranking.model.tipo).toBe('preco');
        });


    });

});
