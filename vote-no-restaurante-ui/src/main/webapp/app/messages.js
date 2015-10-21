define([ 'app' ], function(app) {
    app.directive('flashMessages', [ 'flash', function(flash) {
                var directive = {
                    restrict : 'EA',
                    replace : true,
                    link : function(scope) {
                        scope.clean = function() {
                            flash.flash([]);
                        };
                    }
                };
                directive.template = '<div ng-show="messages.length > 0" class="alert {{messages[0].level}}" id="flash-container" >'
                        + '<a class="close" aria-hidden="true" id="flash-close" ng-click="clean()">&times;</a>'
                        + '<div ng-repeat="m in messages" id="flash-messages">' + '<div>' + '<span class="">{{m.text}}</span>' + '</div>' + '</div>'
                        + '</div>';

                directive.controller = [ '$scope', '$rootScope', function($scope, $rootScope) {
                    $rootScope.$on('flash:message', function(_, messages, done) {
                        $rootScope.messages = messages;
                        done();
                    });
                } ];
                return directive;
            } ]);
    app.service('flash', [ '$rootScope', '$timeout', function($rootScope, $timeout) {
        var messages = [];
        var reset;
        var _clean = function() {
            _emit(messages = asArrayOfMessages([]));
        };

        var _cleanup = function() {
            $timeout.cancel(reset);
            reset = $timeout(function() {
                $rootScope.messages = [];
            }, 7000);
        };

        var _emit = function(messages, preEmit) {
            if (preEmit !== undefined) {
                preEmit();
            }
            $rootScope.$emit('flash:message', messages, _cleanup);
        };

        // limpa as mensagens qdo muda a rota
        $rootScope.$on('$routeChangeSuccess', _cleanup);

        var asMessage = function(level, text) {
            if (!text) {
                text = level;
                level = 'success';
            }
            return {
                level : level,
                text : text
            };
        };
        var asArrayOfMessages = function(level, text) {
            if (level instanceof Array)
                return level.map(function(message) {
                    return message.text ? message : asMessage(message);
                });
            return text ? [ {
                level : level,
                text : text
            } ] : [ asMessage(level) ];
        };

        var _flash = function(level, text, preEmit) {
            _emit(messages = asArrayOfMessages(level, text), preEmit);
        };

        var _info = function(msg, preEmit) {
            _emit(messages = asArrayOfMessages('alert-info', msg), preEmit);
        };

        var _success = function(msg, preEmit) {
            _emit(messages = asArrayOfMessages('alert-primary', msg), preEmit);
        };
        var _warn = function(msg, preEmit) {
            _emit(messages = asArrayOfMessages('alert-warning', msg), preEmit);
        };
        var _error = function(msg, preEmit) {
            _emit(messages = asArrayOfMessages('alert-danger', msg), preEmit);
        };
        return {
            flash : _flash,
            cleanup : _cleanup,
            clean : _clean,
            info : _info,
            success : _success,
            warn : _warn,
            error : _error
        };
    } ]);
});