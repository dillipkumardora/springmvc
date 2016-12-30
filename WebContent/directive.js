angular.module('app.directives' , [])
.directive('navigationbar' , [function(){
	//run during compile
	
	return{
		//name:'',
		//priority:1,
		//terminal:true,
		//scope:{}, //{}=isolate,true=child,false/undefined="no change
		controller:['$scope','$http', function($scope, $http){
			$http.get('data/pages.json').success(function(data){
				$scope.pages = data;
			});
			
		}],
		//require:'ngmodel',//Array=multiple requires, ?=optional, ^=check parent element
		restrict:'E',//E-Element, A-Attribute, C-Class, M-Comment
		//template:'<h1>Navigation</h1>',
		templateUrl:'navigation/nav.html',
		//replace:true,
		//transclude:true,
		//compile:function(tElement, tArrs, function transclude(function(scope,
		//cloneLiinkingFn) {return function linking(scope, elm, attrs){}})),
		
		link:function($scope,iElm,iAttrs,controller){
			
		}
	};
}]);;