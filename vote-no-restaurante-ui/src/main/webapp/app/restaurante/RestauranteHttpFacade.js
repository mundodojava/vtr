define([ 'app' ], function(app) {

    app.register.service('RestauranteHttpFacade', [ 'Restangular', function(Restangular) {

        // GET /restaurantes //NOSONAR
        var _listar = function() {
            return Restangular.all('restaurantes').getList();
        };

        return {
            listar : _listar
        };

    } ]);

});