define([ 'angularAMD' ], function() {
	return angular.module('voteNoRestaurante', [ 'ngRoute', 'ngAnimate', 'angular-input-stars',
			'jcs-autoValidate', 'ngTable', 'ngBootbox','angularModalService', 	
			'ngCookies', 'restangular' ]);
});
