'use strict';


angular.module('analyticsApp.dataController', [])
	.controller('DataCtrl', function ($scope, $http, $modal){
		$http.get('http://localhost:8080/tiendas.json').sucess(function(data){
			$scope.tiendas = data;
		}),

		$scope.gridOptions = {
			data: 'tiendas',
			showGroupPanel: true,
			enableCellSelection: true,
			enableRowSelection: false,
			enableCellEdit: false
			columnDefs:[
				{field: 'no', displayName: 'Nº.'},
				{field: 'nombre', displayName: 'Nombre'},
				{field: 'ciudad', displayName: 'Ciudad'},
				{field: 'longitud', displayName: 'Longitud'},
				{field: 'latitud', displayName: 'Latitud'},
				{field: 'telf', displayName: 'Telefono'}
			]
		};

		$scope.showModal = function(){
			$scope.nuevaTienda={};
			var modalInstance = $modal.open({
				templateUrl: 'partials/addStore.html',
				controller: 'AddNewStoreCtrl',
				resolve:{
					nuevaTienda: function(){
						return $scope.nuevaTienda;
					}
				}
			});

			modalInstance.result.then(function(selectedItem){
				$scope.tiendas.push(
				{
					no: $scope.tiendas.length + 1,
					nombre: $scope.nuevaTienda.nombre,
					ciudad: $scope.nuevaTienda.ciudad,
					longitud: $scope.nuevaTienda.longitud,
					latitud: $scope.nuevaTienda.latitud,
					telf: $scope.nuevaTienda.telf
				}
				);
			});

		};

	})

	.controller('AddNewStoreCtrl', function ($scope, $modalInstance, nuevaTienda){
		$scope.nuevaTienda = nuevaTienda;
		$scope.salvarNuevaTienda= function(){
			$modalInstance.close(nuevaTienda);
		};
		$scope.cancel = function(){
			$modalInstance.dismiss('cancel');
		};
	});