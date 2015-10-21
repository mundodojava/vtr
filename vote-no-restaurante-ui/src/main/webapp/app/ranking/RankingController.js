define([ 'app', 'messages', 'RankingService', 'RestauranteService'], function(app) {
	
	app.register.controller('RankingController', ['$scope','$rootScope', 'flash', '$routeParams', 'RankingService', 'RestauranteService', function ($scope, $rootScope, flash, $routeParams, RankingService, RestauranteService) {
		
		$scope.ranking = {};
		$scope.rankingDescricao = {
				
		       "demora" : {
		            "img" : "img/icon/watch.svg",
		            "titulo" : "Tempo",
		            "frase" : "Porque você está com pressa e seu tempo é valioso."
		       },
		"atendimento" : {
			"img" : "img/icon/chair.svg",
			"titulo" : "Atendimento",
			"frase" : "Porque você aprecia um bom tratamento e não quer ser mal servido."
		},
		"sabor" : {
			"img" : "img/icon/retina.svg",
			"titulo" : "Sabor",
			"frase" : "Seu paladar é quem manda, tem que ser gostoso."
		},
		"localizacao" : {
			"img" : "img/icon/map.svg",
			"titulo" : "Localização",
			"frase" : "Você gosta de fácil acesso, tem que ter um em cada esquina."
		},
		"preco" : {
			"img" : "img/icon/bill.svg",
			"titulo" : "Preço",
			"frase" : "Porque você zela pelo bem estar da sua carteira."
		},
		"custobeneficio" : {
			"img" : "img/icon/cup.svg",
			"titulo" : "Custo-Benefício",
			"frase" : "Não é só o preço, o tempo ou o sabor, tudo importa. Você quer o melhor custo-benefício."
		}
		       
		}
		
		$scope.init = function() {
			
			if($rootScope.usuario !== undefined){
				$scope.usuario = $rootScope.usuario;
				$scope.rankingPorUsuario();
			}else{
				$scope.usuario = undefined;
			}
			
			$("html, body").animate({ scrollTop: $(document).height() }, 300);
			
			if ($routeParams !== undefined && $routeParams.tipoRanking !== undefined) {
					$scope.ranking.model = $scope.rankingDescricao[$routeParams.tipoRanking];
					RankingService.rankingPorTipo($routeParams.tipoRanking, function(response){
							$scope.ranking.rankingGeral = response.clone();
					});
			}
		}
		
		$scope.ranking.rankingUsuario = [];
		
		$scope.rankingPorUsuario = function() {
			
			if ($scope.usuario !== undefined) {
				if ($routeParams !== undefined && $routeParams.tipoRanking !== undefined) {
					RankingService.rankingPorTipoEUsuario($routeParams.tipoRanking, $scope.usuario, function(response){
							$scope.ranking.rankingUsuario = response.clone();
					});
				}
			}
		}
	    
	
	}]);
	
});