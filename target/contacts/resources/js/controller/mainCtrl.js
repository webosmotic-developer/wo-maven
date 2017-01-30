app.controller('MainCtrl', function($scope, $resource, $timeout) {
	var Contacts = $resource('rest/contacts/:id', {
		id : '@id'
	}, {
		'get' : {
			method : 'GET'
		},
		'save' : {
			method : 'POST'
		},
		'query' : {
			method : 'GET',
			isArray : true
		},
		'remove' : {
			method : 'DELETE'
		},
		'update' : {
			url : 'rest/contacts',
			method : 'PUT'
		}
	});

	$scope.contact = {};

	$scope.gridOptions = {
		data : 'contacts',
		paginationPageSizes : [ 5, 10, 25 ],
		paginationPageSize : 5,
		enableFiltering : true,
		columnDefs : [
				{
					name : 'id',
					displayName : '#',
					minWidth : 120,
					maxWidth : 120,
					enableFiltering : false,
					enableHiding : false
				},
				{
					name : 'firstName',
					enableHiding : false,
					minWidth : 100
				},
				{
					name : 'lastName',
					enableHiding : false,
					minWidth : 100
				},
				{
					name : 'mobile',
					enableHiding : false,
					minWidth : 100
				},
				{
					name : 'Action',
					cellTemplate : '<div class="ui-grid-cell-contents">'
							+ '<a href="javascript:void(0)" ng-click="grid.appScope.fnEditContact(row.entity)"><i class="glyphicon glyphicon-edit"></i></a> | '
							+ '<a href="javascript:void(0)" class="text-danger" ng-click="grid.appScope.fnDeleteContact(row.entity)"><i class="glyphicon glyphicon-trash"></i></a></div>',
					minWidth : 100,
					maxWidth : 80,
					enableFiltering : false,
					enableColumnMenu : false,
					enableSorting : false
				} ]
	}

	$scope.fnEditContact = function(contact) {
		$scope.contact = Contacts.get({
			id : contact.id
		});
	};

	$scope.fnReset = function() {
		$scope.contact = {};
		$scope.contactForm.$setPristine();
	};

	$scope.fnSave = function(contact) {
		if (contact.id) {
			$scope.fnUpdateContact(contact);
		} else {
			$scope.fnAddContact(contact);
		}
	};

	$scope.fnAddContact = function(contact) {
		var newContact = new Contacts();
		newContact.firstName = contact.firstName;
		newContact.lastName = contact.lastName;
		newContact.mobile = contact.mobile;
		newContact.$save(function() {
			toastr.success("Contact added successfully.");
			$scope.fnReset();
			$scope.fnGetContactList();
		}, function() {
			toastr.error("Contact not added.");
		});
	};

	$scope.fnUpdateContact = function(contact) {
		contact.$update(function() {
			toastr.success("Contact updated successfully.");
			$scope.fnReset();
			$scope.fnGetContactList();
		}, function() {
			toastr.error("Contact not updated.");
		});
	};

	$scope.fnDeleteContact = function(contact) {
		var result = confirm("Are you sure you want to delete this contact?");
		if (result) {
			var param = {id : contact.id};
			
			function fnSuccess(){
				toastr.success("Contact deleted successfully.");
				$scope.fnGetContactList();
			}
			
			function fnFailure(){
				toastr.error("Contact not deleted.");
			}
			
			Contacts.remove(param, fnSuccess,fnFailure);
		}
	};

	$scope.fnGetContactList = function() {
		Contacts.query(function(contacts) {
			$timeout(function () {
                angular.element('.preloader').fadeOut('slow', function () {
                    angular.element(this).remove();
                });
            }, 1000);
			$scope.contacts = contacts;			
		});
	};

	$scope.fnInitContacts = function() {
		$scope.fnGetContactList();
	};

});
