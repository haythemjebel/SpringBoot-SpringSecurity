var myApp=angular.module("myApp",[]);
myApp.controller("inscriptionControler", function($scope,$http) {
	$scope.etudiant={};
	$scope.saveEtudiant=function(){
		$http.post("saveEtudiant",$scope.etudiant).success(function(data) {
			$scope.etudiant=data;
		});
	};
});