define([ 'app', 'RankingService' ], function(app) {

    app.register.service('VotacaoService', [ 'RankingService', function(RankingService) {

        var _salvarRanking = function(body, responseFunction) {
            RankingService.salvarRanking(body, responseFunction);
        };

        return {
            salvarRanking : _salvarRanking,
        };

    } ]);

});