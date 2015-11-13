define(['app','angularAMD', 'home/HomeController'], function(app, angularAMD) {

	var $scope, controller;

	beforeEach(angularAMD.bootstrap(app));
	
	angularAMD.inject(function ($rootScope, $controller) {
		$scope = $rootScope.$new();
		controller = $controller('HomeController', { '$scope': $scope });
	});
	
	// Descricao de um cenario de teste
	describe("Ao ler json com roles", function() {
		
		afterEach(function() {
			//Verifica apos cada teste se dentro do array é um objeto
			array.forEach(function(element){
				expect(element instanceof Object).toBe(true); 
			});
		});

		
	});
});
