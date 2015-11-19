var tests = [];
for (var file in window.__karma__.files) {
  if (window.__karma__.files.hasOwnProperty(file)) {
    if (/Spec\.js$/.test(file)) {
      tests.push(file);
    }
  }
}
requirejs.config({
    // Karma serves files from '/base'
    baseUrl: '/base/app',

    paths: {
        'angular' : '../js/angular.min',
        'angular-route' : '../js/angular-route.min',
        'angular-underscore' : '../js/angular-underscore.min',
        'angular-animate' : '../js/angular-animate.min',
        'angular-mocks' : '../js/angular-mocks',
        'angular-cookies' : '../js/angular-cookies.min',
        'angular-bootbox' : '../js/angular-bootbox.min',
        'angular-scroll' : '../js/angular-scroll.min',
        'angular-input-match' : '../js/angular-input-match.min',
        'angular-locale_pt-br' : '../js/i18n/angular-locale_pt-br',
        'angularAMD' : '../js/angularAMD.min',

        'jquery' : '../js/jquery-1.10.2',
        'popupoverlay' : '../js/jquery.popupoverlay.min',
        'pace' : '../js/pace.min',
        'modernizr' : '../js/modernizr.min',
        'bootbox' : '../js/bootbox.min',
        'angular-input-stars' : '../js/angular-input-stars',

        'bootstrap' : '../js/bootstrap',
        'owlcarousel' : '../js/owl.carousel',
        'stickUp' : '../js/stickUp.min',
        'ng-modal' : '../js/angular-modal-service.min',
        'corner' : '../js/jquery.corner',
        'wow' : '../js/wow.min',
        'classie' : '../js/classie',
        'uiMorphingButton_inflow' : '../js/uiMorphingButton_inflow',
        'magnific-popup' : '../js/jquery.magnific-popup',

        'angular-flash' : '../js/angular-flash',
        'underscore' : '../js/underscore-min',
        'restangular' : '../js/restangular.min',

        'cookie' : '../js/jquery.cookie.min',
        'dashboard' : '../js/endless/endless_dashboard',
        'jcs-auto-validate' : '../js/jcs-auto-validate.min',

        'ngTable' : '../js/ng-table.min',

        'app' : 'app',
        'routes' : 'routes',
        'config' : 'config',
        'run' : 'run',
        'messages' : 'messages',
        'init' : 'init',

        'VotacaoController' : 'votacao/VotacaoController',
        'VotacaoService' : 'votacao/VotacaoService',
        'RankingService' : 'ranking/RankingService',
        'RestauranteService' : 'restaurante/RestauranteService',
        'RestauranteHttpFacade' : 'restaurante/RestauranteHttpFacade',
        'RankingHttpFacade' : 'ranking/RankingHttpFacade'
    },

    shim: {
		
        'bootstrap' : {
            deps : [ 'jquery' ]
        },

        'owlcarousel' : {
            deps : [ 'jquery' ]
        },

        'uiMorphingButton_inflow' : {
            exports : 'UIMorphingButton',
            deps : [ 'jquery', 'classie' ]
        },

        'stickUp' : {
            exports : 'stickUp',
            deps : [ 'jquery' ]
        },

        'magnific-popup' : {
            deps : [ 'jquery' ]
        },

        'flot' : {
            deps : [ 'jquery' ]
        },

        'intro' : {
            deps : [ 'jquery' ]
        },

        'popupoverlay' : {
            deps : [ 'jquery' ]
        },

        'cookie' : {
            deps : [ 'jquery' ]
        },

        'bootbox' : {
            exports : 'bootbox',
            deps : [ 'jquery' ]
        },

        'angular' : {
            exports : 'angular',
            deps : [ 'jquery' ]
        },

        'ng-modal' : {
            exports : 'angularModalService',
            deps : [ 'angular' ]
        },

        'angular-input-stars' : {
            deps : [ 'angular' ]
        },

        'angular-underscore' : {
            deps : [ 'underscore', 'angular' ]
        },

        'angular-scroll' : {
            exports : 'duScroll',
            deps : [ 'angular' ]
        },

        'ngTable' : {
            deps : [ 'angular' ]
        },

        'angular-bootbox' : {
            deps : [ 'angular' ]
        },

        'restangular' : {
            deps : [ 'angular' ]
        },

        'angular-cookies' : {
            exports : 'ngCookies',
            deps : [ 'angular' ]
        },

        'angular-route' : {
            exports : 'ngRoute',
            deps : [ 'angular' ]
        },

        'jcs-auto-validate' : {
            exports : 'jcs-autoValidate',
            deps : [ 'angular' ]
        },

        'angular-animate' : {
            exports : 'ngAnimate',
            deps : [ 'angular' ]
        },

        'angular-input-match' : {
            deps : [ 'angular' ]
        },
		
		'angular-mocks' : {
            deps : [ 'angular' ]
        },

        'app' : {
            deps : [ 'angular-mocks', 'angular-route', 'angular-animate', 'jcs-auto-validate', 'ngTable', 'angular-bootbox', 'cookie', 'popupoverlay', 'bootstrap', 'ng-modal', 'angular-input-match', 'angular-underscore', 'angular-input-stars', 'angular-cookies', 'bootbox', 'restangular' ]
        },

        'routes' : {
            deps : [ 'app' ]
        },

        'config' : {
            deps : [ 'routes' ]
        },

        'run' : {
            deps : [ 'config' ]
        },

        'messages' : {
            deps : [ 'config' ]
        },

        'PrincipalController' : {
            deps : [ 'run' ]
        },

    },

    // ask Require.js to load these files (all our tests)
    deps: tests,

    // start test run, once Require.js is done
    callback: window.__karma__.start
});

require([ 'init' ], function() {
});