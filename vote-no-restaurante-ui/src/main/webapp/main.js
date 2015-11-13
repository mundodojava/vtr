window.name = "NG_DEFER_BOOTSTRAP!";

/*
 * Date Format 1.2.3 (c) 2007-2009 Steven Levithan <stevenlevithan.com> MIT license Includes enhancements by Scott Trenda <scott.trenda.net> and Kris Kowal <cixar.com/~kris.kowal/> Accepts a date, a
 * mask, or a date and a mask. Returns a formatted version of the given date. The date defaults to the current date/time. The mask defaults to dateFormat.masks.default.
 */

var isIE = function() {
	var myNav = navigator.userAgent.toLowerCase();
	return (myNav.indexOf('msie') !== -1) ? parseInt(myNav.split('msie')[1]) : false;
};

var log;

if (isIE() <= 9) {
	if (typeof console.log === "undefined") {
		console.log = function() {
		};
	}
}

if (!String.prototype.startsWith) {

	String.prototype.enumerable = false;

	String.prototype.startsWith = function(searchString, position) {
		position = position || 0;
		return this.lastIndexOf(searchString, position) === position;
	};
}

if (!String.prototype.contains) {
	String.prototype.contains = function(str, startIndex) {
		return ''.indexOf.call(this, str, startIndex) !== -1;
	};
}
if (!String.prototype.containsIgnoreCase) {
	String.prototype.containsIgnoreCase = function(str, startIndex) {
		return ''.indexOf.call(this.toLowerCase(), str.toLowerCase(), startIndex) !== -1;
	};
}

if (!String.prototype.endsWith) {

	String.prototype.endsWith = function(searchString, position) {
		var subjectString = this.toString();
		if (position === undefined || position > subjectString.length) {
			position = subjectString.length;
		}
		position -= searchString.length;
		var lastIndex = subjectString.indexOf(searchString, position);
		return lastIndex !== -1 && lastIndex === position;
	};
}

/**
 * Shim for "fixing" IE's lack of support (IE < 9) for applying slice on host objects like NamedNodeMap, NodeList, and HTMLCollection (technically, since host objects have been
 * implementation-dependent, at least before ES6, IE hasn't needed to work this way). Also works on strings, fixes IE < 9 to allow an explicit undefined for the 2nd argument (as in Firefox), and
 * prevents errors when called on other DOM objects.
 */
(function() {
	'use strict';
	var _slice = Array.prototype.slice;

	try {
		// Can't be used with DOM elements in IE < 9
		_slice.call(document.documentElement);
	} catch (e) {
		// Fails in IE < 9

		// This will work for genuine arrays, array-like objects,
		// NamedNodeMap (attributes, entities, notations),
		// NodeList (e.g., getElementsByTagName), HTMLCollection (e.g.,
		// childNodes),
		// and will not fail on other DOM objects (as do DOM elements in IE < 9)
		Array.prototype.slice = function(begin, end) {
			// IE < 9 gets unhappy with an undefined end argument
			end = (typeof end !== 'undefined') ? end : this.length;

			// For native Array objects, we use the native slice function
			if (Object.prototype.toString.call(this) === '[object Array]') {
				return _slice.call(this, begin, end);
			}

			// For array like object we handle it ourselves.
			var cloned = [], size, len = this.length;

			// Handle negative value for "begin"
			var start = begin || 0;
			start = (start >= 0) ? start : len + start;

			// Handle negative value for "end"
			var upTo = (end) ? end : len;
			if (end < 0) {
				upTo = len + end;
			}
			// Actual expected size of the slice
			size = upTo - start;

			tratarSlice(cloned, start);
			return cloned;
		};
	}
}());

tratarSlice = function(cloned, start) {
	if (size > 0) {
		cloned = new Array(size);
		if (this.charAt) {
			for (i = 0; i < size; i++) {
				cloned[i] = this.charAt(start + i);
			}
		} else {
			for (i = 0; i < size; i++) {
				cloned[i] = this[start + i];
			}
		}
	}
};

if (!Array.prototype.remove) {
	Array.prototype.remove = function(item) {
		for (var i = this.length; i--;) {
			if (this[i] === item) {
				this.splice(i, 1);
			}
		}
	};
}
if (!Array.prototype.contains) {
	Array.prototype.contains = function(obj) {
		var i = this.length;
		while (i--) {
			if (this[i] === obj) {
				return true;
			}
		}
		return false;
	};
}

var dateFormat = function() {
	var token = /d{1,4}|m{1,4}|yy(?:yy)?|([HhMsTt])\1?|[LloSZ]|"[^"]*"|'[^']*'/g, timezone = /\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g, timezoneClip = /[^-+\dA-Z]/g, pad = function(val, len) {
		val = String(val);
		len = len || 2;
		while (val.length < len) {
			val = "0" + val;
		}
		return val;
	};

	// Regexes and supporting functions are cached through closure
	return function(date, mask, utc) {
		var dF = dateFormat;

		// You can't provide utc if you skip other args (use the "UTC:" mask
		// prefix)
		if (arguments.length === 1 && Object.prototype.toString.call(date) === "[object String]" && !/\d/.test(date)) {
			mask = date;
			date = undefined;
		}

		// Passing date through Date applies Date.parse, if necessary
		date = date ? new Date(date) : new Date();
		if (isNaN(date))
			throw SyntaxError("invalid date");

		mask = String(dF.masks[mask] || mask || dF.masks["default"]);

		// Allow setting the utc argument via the mask
		if (mask.slice(0, 4) === "UTC:") {
			mask = mask.slice(4);
			utc = true;
		}

		var _ = utc ? "getUTC" : "get", d = date[_ + "Date"](), D = date[_ + "Day"](), m = date[_ + "Month"](), y = date[_ + "FullYear"](), H = date[_ + "Hours"](), M = date[_ + "Minutes"](), s = date[_ + "Seconds"](), L = date[_ + "Milliseconds"](), o = utc ? 0 : date.getTimezoneOffset(), flags = {
			d : d,
			dd : pad(d),
			ddd : dF.i18n.dayNames[D],
			dddd : dF.i18n.dayNames[D + 7],
			m : m + 1,
			mm : pad(m + 1),
			mmm : dF.i18n.monthNames[m],
			mmmm : dF.i18n.monthNames[m + 12],
			yy : String(y).slice(2),
			yyyy : y,
			h : H % 12 || 12,
			hh : pad(H % 12 || 12),
			H : H,
			HH : pad(H),
			M : M,
			MM : pad(M),
			s : s,
			ss : pad(s),
			l : pad(L, 3),
			L : pad(L > 99 ? Math.round(L / 10) : L),
			t : H < 12 ? "a" : "p",
			tt : H < 12 ? "am" : "pm",
			T : H < 12 ? "A" : "P",
			TT : H < 12 ? "AM" : "PM",
			Z : utc ? "UTC" : (String(date).match(timezone) || [ "" ]).pop().replace(timezoneClip, ""),
			o : (o > 0 ? "-" : "+") + pad(Math.floor(Math.abs(o) / 60) * 100 + Math.abs(o) % 60, 4),
			S : [ "th", "st", "nd", "rd" ][d % 10 > 3 ? 0 : (d % 100 - d % 10 !== 10) * d % 10]
		};
		return mask.replace(token, function($0) {
			return $0 in flags ? flags[$0] : $0.slice(1, $0.length - 1);
		});
	};
}();

// Some common format strings
dateFormat.masks = {
	"default" : "ddd mmm dd yyyy HH:MM:ss",
	shortDate : "m/d/yy",
	mediumDate : "mmm d, yyyy",
	longDate : "mmmm d, yyyy",
	fullDate : "dddd, mmmm d, yyyy",
	shortTime : "h:MM TT",
	mediumTime : "h:MM:ss TT",
	longTime : "h:MM:ss TT Z",
	isoDate : "yyyy-mm-dd",
	isoTime : "HH:MM:ss",
	isoDateTime : "yyyy-mm-dd'T'HH:MM:ss",
	isoUtcDateTime : "UTC:yyyy-mm-dd'T'HH:MM:ss'Z'"
};

// Internationalization strings
dateFormat.i18n = {
	dayNames : [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ],
	monthNames : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ]
};

// For convenience...
Date.prototype.format = function(mask, utc) {
	return dateFormat(this, mask, utc);
};

(function() {
	'use strict';

	var root = this, require = root.require;

	// fake 'has' if it's not available
	var has = root.has = root.has || function() {
		return false;
	};
	// http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
	window.name = 'NG_DEFER_BOOTSTRAP!';

	// this requires dom ready to update on ui, so this function expression
	// will be implemented later when domReady.
	var updateModuleProgress = function(context, map, depMaps) {
		// when dom is not ready, do something more useful?
		var console = root.console;
		if (console && console.log) {
			console.log(new Date().format('HH:mm:ss.l') + ' loading: ' + map.name + ' at ' + map.url);
		}
	};

	require.onResourceLoad = function(context, map, depMaps) {
		updateModuleProgress(context, map, depMaps);
	};

	require([ 'app/paths', 'app/dependencies' ], function(paths, dependencies) {
		// if it's prod mode, set log level to 'info'
		if (has('prod')) {
			$.log.setLevel($.log.LEVEL.INFO);
		}

		var version = "1418303597184";
		if (version.indexOf("timestamp") > -1) {
			version = new Date().getTime();
		}

		require.config({
			baseUrl : "app",
			paths : paths,
			shim : dependencies,
			waitSeconds : 0
		/* urlArgs : "version=" + new Date().getTime() */
		});

		require([ 'app/init' ], function() {
		});
	});
}).call(this);