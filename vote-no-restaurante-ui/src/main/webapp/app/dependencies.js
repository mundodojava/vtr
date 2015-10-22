define(function() {

    return {
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

        'app' : {
            deps : [ 'angular-route', 'angular-animate', 'jcs-auto-validate', 'ngTable', 'angular-bootbox', 'cookie', 'popupoverlay', 'bootstrap', 'ng-modal', 'angular-input-match', 'angular-underscore', 'angular-input-stars', 'angular-cookies', 'bootbox', 'restangular' ]
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

    };

});