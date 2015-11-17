define([ 'app', 'init', 'RankingService', 'RestauranteService' ], function(app) {

    app.register.controller('RankingController', [ '$scope', '$rootScope', 'flash', '$routeParams', 'RankingService', 'RestauranteService', function($scope, $rootScope, flash, $routeParams, RankingService, RestauranteService) {

        $scope.ranking = {};
        $scope.rankingDescricao = {

            "rapidez" : {
                "img" : "img/icon/watch.svg",
                "titulo" : "Tempo",
                "frase" : "Porque seu tempo é valioso."
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

            if ($routeParams !== undefined && $routeParams.tipoRanking !== undefined) {
                $scope.ranking.model = $scope.rankingDescricao[$routeParams.tipoRanking];
                $scope.ranking.model.tipo = $routeParams.tipoRanking;
            }

            if ($rootScope.usuario !== undefined) {
                $scope.usuario = $rootScope.usuario;
                $scope.rankingPorUsuario();
            } else {
                $scope.usuario = undefined;
            }

            $("html, body").animate({
                scrollTop : parseInt($("#vote").offset().top)
            }, 500);

            $scope.rankingGeral();
        }

        $scope.ranking.rankingUsuario = [];

        $scope.rankingGeral = function() {
            if ($scope.ranking.model.tipo !== undefined) {
                RankingService.rankingPorTipo($scope.ranking.model.tipo, function(response) {
                    $scope.ranking.rankingGeral = response.clone();
                });
            }
        }

        $scope.rankingPorUsuario = function() {
            flash.clean();
            flash.cleanup();
            if ($scope.usuario !== undefined) {
                if ($scope.ranking.model.tipo !== undefined) {
                    RankingService.rankingPorTipoEUsuario($scope.ranking.model.tipo, $scope.usuario, function(response) {
                        $scope.ranking.rankingUsuario = response.clone();
                        if($scope.ranking.rankingUsuario.length === 0){
                            flash.warn("Não foram encontradas votações para o e-mail informado");
                        }
                    });
                }
            }
        }

        $scope.trocarTipo = function() {
            var tipo = $scope.ranking.model.tipo;
            $scope.ranking.model = $scope.rankingDescricao[tipo];
            $scope.ranking.model.tipo = tipo;
            $scope.rankingPorUsuario();
            $scope.rankingGeral();
        }

    } ]);

});