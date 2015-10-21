define([ 'app', 'messages', 'VotacaoService', 'RestauranteService'], function(app) {
	
	app.register.controller('VotacaoController', ['$scope', '$rootScope', 'flash', 'VotacaoService', '$location', 'RestauranteService', function ($scope, $rootScope, flash, VotacaoService, $location, RestauranteService) {
		
		$scope.template = 0;
		
		$scope.usuario = {};
		
		$scope.isSelected = function(template){
			return $scope.template === template;
		};
		
		$scope.votosTemplate = [ 
		                {
		                	"tipo":"ATENDIMENTO",
		                    "descricao":"Atendimento"
		                },
		                
		                {	"tipo":"DEMORA",
		                	"descricao":"Demora"
		                },
		                
		                {	"tipo":"SABOR",
		                	"descricao":"Sabor"
		                },
		                
		                {	"tipo":"PRECO",
		                	"descricao":"Preço"
		                },
		                
		                {	"tipo":"LOCALIZACAO",
		                	"descricao":"Localização"
		                } 
		                 
		                ];
		
		$scope.restaurantes = [];
		
		$scope.init = function(){
			$("html, body").animate({ scrollTop: $(document).height() }, 300);
			
			$scope.votosTemp = [];
			angular.copy($scope.votosTemplate, $scope.votosTemp);
			
			RestauranteService.listar(function(response){
				$scope.restaurantes = response.clone();
				var random1 = _.sample($scope.restaurantes);
				var random2 = _.sample($scope.restaurantes);
				
				while (random1.restauranteId === random2.restauranteId) {
					random2 = _.sample($scope.restaurantes);
				}
				
				$scope.randoms = [random1,random2];
			});
			
		}
		
		 $scope.iniciarVotacao = function () {
			 $scope.template = 1;
		 };
		 
		 $scope.escolherRestaurante = function (restaurante) {
			 $scope.restaurante = restaurante;
			 $scope.template = 2;
		 }
		
		$scope.continuar = function (restaurante){
			flash.cleanup();
			flash.clean();
			for (var i = 0; i < $scope.votosTemp.length; i++) {
				var voto = $scope.votosTemp[i];
				if(isNaN(voto.nota) || voto.nota === undefined){
					flash.error("Por favor, avalie todos os aspectos sobre o restaurante");
					return;
				} 
			}

			restaurante.votou = true;
			restaurante.votos = [];
			angular.copy($scope.votosTemp, restaurante.votos);
			proximoRestaurante();
		};
		
		$scope.naoConheco = function (restaurante){
			flash.cleanup();
			flash.clean();
			restaurante.naoConheco = true;
			proximoRestaurante();
		};
		
		$scope.salvarRanking = function (){
			VotacaoService.salvarRanking(montarRequestRanking(), function() {
				$rootScope.usuario = $scope.usuario.usuarioId;
				flash.success("Obrigado, agora sinta-se à vontade para navegar pelo site");
				$location.path('/home');
            });
		};
		
		montarRequestRanking = function () {
			var ranking = {};
			
			ranking.usuario = $scope.usuario;
			ranking.votos = [];
			
			for (var r = 0; r < $scope.restaurantes.length; r++) {
				var rest = $scope.restaurantes[r];
				if(rest.votou && rest.votos !== undefined){
					adicionarVotos(ranking, rest);
				} 
			}
			
			return ranking;
		}
		
		adicionarVotos = function(ranking, rest) {
			for (var v = 0; v < rest.votos.length; v++) {
				var voto = rest.votos[v];
				ranking.votos.push({
					"nota" : voto.nota,
					"tipoVoto" : voto.tipo,
					"restaurante" : {
						"restauranteId" : rest.restauranteId
					},
				});
			}
		}
		
		proximoRestaurante = function () {
			
			$scope.restaurante = undefined;
			 
			 for (var r = 0; r < $scope.restaurantes.length; r++) {
				var restaurante = $scope.restaurantes[r];
				if(!restaurante.votou && !restaurante.naoConheco){
					$scope.restaurante = restaurante;
					break;
				} 
			}
			 
			 if($scope.restaurante === undefined){
				 $scope.template = 4;
			 }else{
				 $scope.template = 3;
				 angular.copy($scope.votosTemplate, $scope.votosTemp);
			 }
		}
	    
	}]);
	
});