'use strict';

/* App Module */

Array.prototype.randomize = function() {
    var i = this.length, j, temp;
    if(i===0)
	return this;
    while (--i) {
	j = Math.floor(Math.random() * (i - 1));
	temp = this[i];
	this[i] = this[j];
	this[j] = temp;
    }
    return this;
    
};

var analyticsApp = angular
	.module('analyticsApp', [
	    'ngRoute', 
	    'angularFileUpload', 
	    'ui.bootstrap', 
	    'track-map-ng',
	    'analyticsApp.filters',
	    'analyticsApp.services',
	    'analyticsApp.directives',
	    'analyticsApp.controllers'	    
	])
	.directive('ngActiveTab', function($location) {
	    return {
		link: function postLink(scope, element, attrs) {
		    scope.$on("$routeChangeSuccess", function(event, current, previous) {
			// this var grabs the tab-level off the attribute, or defaults to 1
			var pathLevel = attrs.activeTab || 1,
				// this var finds what the path is at the level specified
				pathToCheck = $location.path().split('/')[pathLevel],
				// this var finds grabs the same level of the href attribute
				tabLink = attrs.href.split('/')[pathLevel];

			if (pathToCheck === tabLink) {
			    element.parent().addClass("active");
			} else {
			    element.parent().removeClass("active");
			}
		    });
		}
	    };
	})
	.config(
		function($routeProvider, $locationProvider) {
		    $locationProvider.html5Mode(true);

		    $routeProvider.
			    when('/', {
				templateUrl: '/index.html',
				controller: 'IndexCtrl'
			    }).
			    when('/data', {
				templateUrl: '/partials/data.html',
				controller: 'DataCtrl'
			    }).
			    otherwise({
				redirectTo: '/'
			    });
		}
	)
	.filter('bytes', function() {
	    return function(bytes, precision) {
		if (isNaN(parseFloat(bytes)) || !isFinite(bytes)) return '-';
		if (bytes === 0) return '0 bytes';
		if (typeof precision === 'undefined') precision = 1;
		var units = [' bytes', 'KiB', 'MiB', 'GiB', 'TiB', 'PiB'],
			number = Math.floor(Math.log(bytes) / Math.log(1024));
		return (bytes / Math.pow(1024, Math.floor(number))).toFixed(precision) +  '' + units[number];
	    };
	})
	.run(function($rootScope) {
	    $rootScope.currentYear = new Date().getFullYear();
	});    
