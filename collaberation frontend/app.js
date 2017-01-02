angular.module('app',[
'ngRoute',
'app.controllers'

])
.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/' ,{
		templateUrl:'c_blog/blog.html',
		controller:'postcontroller'	
	}).when('/blog/:id', {
		templateUrl:'c_blog/singleblog.html',
		controller:'singleblogcontroller'
	}).when('/page/:id', {
		templateUrl:'page.html',
		controller:'pagecontroller'
	})  
	
			
	.otherwise({redirectTo: '/'});
}]);
       