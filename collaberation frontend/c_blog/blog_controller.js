angular.module('app.controllers' ,[
                 
     'app.directives'                              
])

	.controller('postcontroller' ,['$scope','$http' ,function($scope ,$http){
		$http.get('c_blog/blogs.json').success(function(data){
			$scope.blogs=data;
		});
				
		
	}])
	.controller('singleblogcontroller', ['$scope','$http','$routeParams', function($scope , $http,$routeParams){
		$http.get('c_blog/blogs.json').success(function(data){
			$scope.blog=data[$routeParams.id];
		});
	}])
	.controller('pagecontroller', ['$scope','$http','$routeParams', function($scope , $http ,$routeParams){
		$http.get('data/pages.json').success(function(data){
			$scope.page=data[$routeParams.id];
		})
	
		
		
		
	}]);
	
	
	             
	