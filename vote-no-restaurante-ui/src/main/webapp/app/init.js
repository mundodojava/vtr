var modules = [ 'bootbox', "jquery", "angularAMD", "app", "run", 'messages', "wow", "owlcarousel" ];
define(modules, function(bootbox, jquery, angularAMD, app, run, messages) {
    window['bootbox'] = bootbox;

    /** window['jQuery'] = jquery; */
    angularAMD.bootstrap(app);

    $(document).ready(function() {

        $('#preloader').delay(1).fadeOut('fast');
        $('body').delay(550).css({
            'overflow' : 'visible'
        });
        
        window.down = function() {
            $("html, body").animate({
                scrollTop : parseInt($("#vote").offset().top)
            }, 1000);
        }
        
    });

    new WOW().init();

});
