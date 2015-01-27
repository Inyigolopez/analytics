'use strict';

/* App Module */


angular.module('analyticsApp',[])
	.controller('IndexCtrl' ['$scope', '$parse' function ($scope, $parse){
		$scope.csv = {
			content: null,
			header: true,
			separator: ',',
			result: null
		};
	}])

	

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
			    when('/maps', {
				templateUrl: '/partials/maps.html',
				controller: 'MapsCtrl'
			    }).
			    otherwise({
				redirectTo: '/'
			    });
		}
	)
	
	.run(function($rootScope) {
	    $rootScope.currentYear = new Date().getFullYear();
	});
   
