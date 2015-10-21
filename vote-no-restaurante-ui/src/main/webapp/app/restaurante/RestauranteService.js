define([ 'app', 'RestauranteHttpFacade'], function(app) {
	
	app.register.service('RestauranteService', ['RestauranteHttpFacade',  function (RestauranteHttpFacade) {
        
        var _listar = function(responseFunction) {
        	RestauranteHttpFacade.listar().then(responseFunction, function() {
        	});
        };
        
        return {
        	listar : _listar,
        };
		
	}]);
		    
});