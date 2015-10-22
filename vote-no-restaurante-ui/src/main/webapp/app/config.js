define([ 'app' ], function(app) {

    app.config([ 'RestangularProvider', function(RestangularProvider) {
        RestangularProvider.setBaseUrl('/vote-no-restaurante-api');

        RestangularProvider.setMethodOverriders([ "put", "patch" ]);

        RestangularProvider.setDefaultHeaders({
            'Content-Type' : "application/json"
        });

        // In this case we are mapping the id of each element to the _id field.
        // We also change the Restangular route.
        // The default value for parentResource remains the same.
        RestangularProvider.setRestangularFields({
            id : "_id",
            route : "restangularRoute",
            selfLink : "self.href"
        });

        // Use Request interceptor
        RestangularProvider.setRequestInterceptor(function(element) {
            // delete element.name;
            return element;
        });

        // ..or use the full request interceptor, setRequestInterceptor's more
        // powerful brother!
        RestangularProvider.setFullRequestInterceptor(function(element, operation, route, url, headers, params, httpConfig) {
            // delete element.name;
            return {
                element : element,
                params : params,
                headers : headers,
                httpConfig : httpConfig
            };
        });

        // add a response intereceptor
        RestangularProvider.addResponseInterceptor(function(data) {
            return data;
        });

    } ]);

    // Restangular service that uses setFullResponse
    app.factory('RestFulResponse', [ 'Restangular', function(Restangular) {
        return Restangular.withConfig(function(RestangularConfigurer) {
            RestangularConfigurer.setFullResponse(true);
        });
    } ]);

    app.directive('includeReplace', function() {
        return {
            require : 'ngInclude',
            restrict : 'A', /* optional */
            link : function(scope, el) {
                el.replaceWith(el.children());
            }
        };
    });

    app.directive('removeSpace', function() {
        return {
            require : '?ngModel',
            link : function(scope, element, attrs, ngModelCtrl) {
                if (!ngModelCtrl) {
                    return;
                }

                element.bind('keypress', function(event) {
                    if (event.keyCode === 32) {
                        event.preventDefault();
                    }
                });
            }
        };
    });

    app.directive('emailValido', function() {
                return {
                    require : '?ngModel',
                    link : function(scope, element, attrs, ngModelCtrl) {
                        if (!ngModelCtrl) {
                            return;
                        }

                        ngModelCtrl.$parsers
                                .push(function(val) {
                                    if (angular.isUndefined(val)) {
                                        val = '';
                                    }
                                    if (!/([a-z0-9_-]([a-z0-9-_\.]*[a-z0-9-_])*)@([a-z0-9\.-]*[a-z0-9]\.(arpa|root|aero|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw)|([0-9]{1,3}\.{3}[0-9]{1,3}))/
                                            .test(val)) {
                                        ngModelCtrl.$setValidity('email', false);
                                        angular.element(element[0]).focus();
                                    } else {
                                        ngModelCtrl.$setValidity('email', true);
                                    }

                                    return val;
                                });

                        element.bind('keypress', function(event) {
                            if (event.keyCode === 32) {
                                event.preventDefault();
                            }
                        });
                    }
                };
            });

    /** *********** DIRETIVA PARA FOCUS *********** */
    app.directive('focusMe', [ '$timeout', function() {
        return {
            link : function(scope, element, attrs) {
                scope.$watch(attrs.focusMe, function(value) {
                    if (value) {
                        element[0].focus();
                        scope[attrs.focusMe] = false;
                    }
                });
            }
        };
    } ]);

    app.directive('jqueryMask', function() {
        return {
            require : '?ngModel',
            restrict : 'AC',
            link : function(scope, element, attrs, ngModelCtrl) {
                $(element).mask(attrs.jqueryMask, {
                    optional : !attrs.jqueryMaskOptional ? false : true,
                    placeholder : attrs.jqueryMaskPlaceholder !== undefined ? attrs.jqueryMaskPlaceholder : "_"
                });

                if (!ngModelCtrl) {
                    return;
                }

                ngModelCtrl.$parsers.unshift(function(val) {
                    if (attrs.jqueryMaskValidFunction !== undefined) {
                        if (!window[attrs.jqueryMaskValidFunction](val, element[0])) {
                            ngModelCtrl.$setValidity('invalidDate', false);
                            angular.element(element[0]).focus();
                            return '';
                        } else {
                            ngModelCtrl.$setValidity('invalidDate', true);
                        }
                    }
                    return val;
                });
            }
        };
    });

    app.directive('autoFocus', [ '$timeout', function($timeout) {
        return {
            restrict : 'AC',
            link : function(_scope, _element) {
                $timeout(function() {
                    _element[0].focus();
                }, 0);
            }
        };
    } ]);

    app.directive('compareTo', function() {
        return {
            require : "ngModel",
            scope : {
                otherModelValue : "=compareTo"
            },
            link : function(scope, element, attributes, ngModel) {

                ngModel.$validators.compareTo = function(modelValue) {
                    return modelValue === scope.otherModelValue;
                };

                scope.$watch("otherModelValue", function() {
                    ngModel.$validate();
                });
            }
        };
    });

    app.directive('ngEnter', function() {
        return function(scope, element, attrs) {
            element.bind("keydown keypress", function(event) {
                if (event.which === 13) {
                    scope.$apply(function() {
                        scope.$eval(attrs.ngEnter, {
                            'event' : event
                        });
                    });

                    event.preventDefault();
                }
            });
        };
    });

    app.filter('capitalize', function() {
        return function(input) {
            if (input != null) {
                input = input.toLowerCase();
                return input.substring(0, 1).toUpperCase() + input.substring(1);
            }
            return input;
        };
    });
});