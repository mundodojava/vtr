var modules = [ 'bootbox', "jquery", "angularAMD", "app", "run", 'messages',
		"wow", "owlcarousel" ];
define(modules, function(bootbox, jquery, angularAMD, app, run, messages) {
	window['bootbox'] = bootbox;

	/** window['jQuery'] = jquery; */
	angularAMD.bootstrap(app);

	$(window).load(function() {
		// Preloader
		// $('#status').delay(300).fadeOut();
		// $('#preloader').delay(300).fadeOut('slow');
		// $('body').delay(550).css({'overflow':'visible'});
	})

	$(document).ready(function() {

		/*$("#votarPrincipal").click(function() {
			var offset = 20; // Offset of 20px

			$('html, body').animate({
				scrollTop : $("#vote").offset().top + offset
			}, 2000);
		});
*/
		$('#preloader').delay(1).fadeOut('fast');
		$('body').delay(550).css({
			'overflow' : 'visible'
		});
		// animated logo
		/*
		 * $(".navbar-brand").hover(function () { $(this).toggleClass("animated
		 * shake"); });
		 */

		// animated scroll_arrow
		/*
		 * $(".img_scroll").hover(function () { $(this).toggleClass("animated
		 * infinite bounce"); });
		 */

		// Wow Animation DISABLE FOR ANIMATION MOBILE/TABLET
		/*
		 * wow = new WOW( { mobile: false }); wow.init();
		 */

		// MagnificPopup
		/* $('.image-link').magnificPopup({type:'image'}); */

		// OwlCarousel N1
		/*
		 * $("#owl-demo").owlCarousel({ autoPlay: 3000, items : 3, itemsDesktop :
		 * [1199,3], itemsDesktopSmall : [979,3] });
		 */

		// OwlCarousel N2
		/*
		 * $("#owl-demo-1").owlCarousel({ navigation : false, // Show next and
		 * prev buttons slideSpeed : 300, paginationSpeed : 400, singleItem:true
		 * });
		 */

		// SmothScroll
		/*
		 * $('a[href*=#]').click(function() { if
		 * (location.pathname.replace(/^\//,'') ==
		 * this.pathname.replace(/^\//,'') && location.hostname ==
		 * this.hostname) { var $target = $(this.hash); $target = $target.length &&
		 * $target || $('[name=' + this.hash.slice(1) +']'); if ($target.length) {
		 * var targetOffset = $target.offset().top;
		 * $('html,body').animate({scrollTop: targetOffset}, 600); return false; } }
		 * });
		 */

		// Subscribe
		// new UIMorphingButton( document.querySelector( '.morph-button' ) );
		// for demo purposes only
		/*
		 * [].slice.call( document.querySelectorAll( 'form button' ) ).forEach(
		 * function( bttn ) { bttn.addEventListener( 'click', function( ev ) {
		 * ev.preventDefault(); } ); } );
		 */

		// $('.navbar-default').stickUp();
	});

	new WOW().init();

	window.down = function() {
		$("html, body").animate({
			scrollTop : $(document).height()
		}, 1500);
	}

});
