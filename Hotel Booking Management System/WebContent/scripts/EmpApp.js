var empModule = angular.module("empModule", []);

empModule.run(
	function($rootScope){
		$rootScope.title = "Capgemini India Pvt. Ltd.";
	}	
);

empModule.controller("empController",
	function($scope, $http){
		$scope.pageHead = "List of employees";
		refreshPage();
		
		function refreshPage(){
			$http({
				method : "GET",
				url : 'http://localhost:8088/SpringMVC040_NgRest/rest/empList/'
			}).success(
				function(data){
					$scope.empList = data;
				}
			);
		};

		
		$scope.empDetails = function(empNo){
			$http({
				method : "GET",
				url : 'http://localhost:8088/SpringMVC040_NgRest/rest/empDetails/'+empNo
			}).success(
				function(data){
					$scope.emp = data;
				}
			);
		};
		
		$scope.deleteEmp = function(empNo){
			$http({
				method : "DELETE",
				url : 'http://localhost:8088/SpringMVC040_NgRest/rest/delete/'+empNo
			}).success(
				function(data){
					alert(data);
					refreshPage();
				}
			);
		};
	}
);