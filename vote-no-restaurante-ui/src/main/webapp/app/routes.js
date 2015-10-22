define([ 'app', 'angularAMD' ], function(app, angularAMD) {
    var routes = app.config([ '$routeProvider', '$locationProvider', '$httpProvider', '$cookiesProvider', function($routeProvider, $locationProvider, $httpProvider) {

        $httpProvider.defaults.timeout = 120000;
        $locationProvider.hashPrefix('!');

        $routeProvider.when('/votacao', angularAMD.route({
            caseInsensitiveMatch : true,
            controller : "VotacaoController",
            controllerUrl : "votacao/VotacaoController",
            templateUrl : "templates/votacao/principal.html"
        }));

        $routeProvider.when('/', angularAMD.route({
            caseInsensitiveMatch : true,
            controller : "HomeController",
            controllerUrl : "home/HomeController",
            templateUrl : "templates/home/home.html"
        }));

        $routeProvider.when('/home', angularAMD.route({
            caseInsensitiveMatch : true,
            controller : "HomeController",
            controllerUrl : "home/HomeController",
            templateUrl : "templates/home/home.html"
        }));

        $routeProvider.when('/ranking/:tipoRanking', angularAMD.route({
            caseInsensitiveMatch : true,
            controller : "RankingController",
            controllerUrl : "ranking/RankingController",
            templateUrl : "templates/ranking/ranking.html"
        }));

        $routeProvider.otherwise(angularAMD.route({
            caseInsensitiveMatch : true,
            templateUrl : "templates/votacao/principal.html"
        }));

    } ]);

    return routes;
});