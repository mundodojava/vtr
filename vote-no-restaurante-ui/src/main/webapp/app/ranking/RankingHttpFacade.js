define([ 'app' ], function(app) {

    app.register.service('RankingHttpFacade', [ 'Restangular', function(Restangular) {

        // POST /rankings/ //NOSONAR
        var _salvarRanking = function(body) {
            return Restangular.one('rankings').customPOST(body);
        };

        // GET /rankings/{tipo} //NOSONAR
        var _rankingPorTipo = function(tipo) {
            return Restangular.all('rankings/' + tipo).getList();
        };

        // GET /rankings/{tipo}/usuario?email={usuario} //NOSONAR
        var _rankingPorTipoEUsuario = function(tipo, usuario) {
            return Restangular.all('rankings/' + tipo + '/usuarios').getList({
                email : usuario
            });
        };

        return {
            salvarRanking : _salvarRanking,
            rankingPorTipo : _rankingPorTipo,
            rankingPorTipoEUsuario : _rankingPorTipoEUsuario
        };

    } ]);

});