define([ 'app','init', 'RankingHttpFacade' ], function(app) {

    app.register.service('RankingService', [ 'RankingHttpFacade', function(RankingHttpFacade) {

        var _salvarRanking = function(body, responseFunction) {
            RankingHttpFacade.salvarRanking(body).then(responseFunction, function() {
            });
        };

        var _rankingPorTipo = function(tipo, responseFunction) {
            RankingHttpFacade.rankingPorTipo(tipo).then(responseFunction, function() {
            });
        };

        var _rankingPorTipoEUsuario = function(tipo, usuario, responseFunction) {
            RankingHttpFacade.rankingPorTipoEUsuario(tipo, usuario).then(responseFunction, function() {
            });
        };

        return {
            salvarRanking : _salvarRanking,
            rankingPorTipo : _rankingPorTipo,
            rankingPorTipoEUsuario : _rankingPorTipoEUsuario
        };

    } ]);

});