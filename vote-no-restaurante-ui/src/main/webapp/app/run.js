define([ 'app', 'messages' ], function(app) {
    var run = app

    .run([ '$rootScope', function($rootScope) {
        $rootScope.$on("$routeChangeStart", function() {
            $rootScope.loading = true;
        });
    } ])

    .run([ '$rootScope', function($rootScope) {
        $rootScope.$on("$routeChangeSuccess", function() {
            $rootScope.loading = false;
        });
    } ])

    .run([ '$rootScope', '$window', function($rootScope, $window) {
        $rootScope.$on("$routeChangeError", function() {
            $window.location.href = "error";
        });
    } ])

    .run([ 'validator', 'bootstrap3ElementModifier', 'defaultErrorMessageResolver', function(validator, bootstrap3ElementModifier, defaultErrorMessageResolver) {
        bootstrap3ElementModifier.enableValidationStateIcons(false);
        defaultErrorMessageResolver.setI18nFileRootPath('js/lang');
        defaultErrorMessageResolver.setCulture('pt-BR');
        validator.validationEnabled = false;
        defaultErrorMessageResolver.getErrorMessages().then(function(errorMessages) {
            errorMessages.confirmaEmailPrincipal = 'Os emails não estão iguais';
            errorMessages.confirmaSenha = 'As senhas não estão iguais';
            errorMessages.minToday = 'A data não pode ser anterior a data atual';
            errorMessages.invalidDate = 'Por favor insira uma data válida';
            errorMessages.match = 'Os campos não estão iguais.';
        });
    } ]);

    app.run([ '$rootScope', '$location', '$http', 'flash', function($rootScope, $location, $http, flash) {

        $location.getURLParameter = function(url, name) {
            return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(url))[1].replace(/\+/g, '%20'));
        };

    } ]);

    app.run([ 'Restangular', '$location', '$http', 'flash', '$window', '$rootScope', function(Restangular, $location, $http, flash, $window, $rootScope) {
        $http.defaults.headers.common['Content-Encoding'] = 'gzip,deflate';

        Restangular.setErrorInterceptor(function(response) {
            tratarErrorsResponse(response, flash);
            // error not handled
            return true;
        });

        tratarErrorsResponse = function(response, flash) {
            switch (response.status) {
                case 422:
                case 409: {
                    errorResponse422Or409(response, flash);
                }
                    break;
                case 500: {
                    errorResponse500(response, flash);
                }
                    break;
                default:
                    break;
            }
        };

        errorResponse500 = function(response, flash) {
            if (response.status === 500) {
                flash.error("Problemas ao chamar serviço!");
            }
        };

        errorResponse422Or409 = function(response, flash) {
            var messages = [];

            if (response.data.errors === undefined || response.data.errors.length === 0) {
                messages.push({
                    level : 'alert-danger',
                    text : response.data.detail
                });
            } else {
                for (var i = 0; i < response.data.errors.length; i++) {
                    messages.push({
                        level : 'alert-danger',
                        text : response.data.errors[i].message
                    });
                }
            }
            flash.flash(messages);
        };

    } ]);
    return run;
});