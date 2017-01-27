<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WebOsmotic | Manage Contacts Maven Project</title>
<!--  START : Vendor -->
<link rel="stylesheet"
	href="resources/cdn/bootstrap/3.3.7/bootstrap.min.css" />
<link rel="stylesheet"
	href="resources/cdn/bootstrap/3.3.7/bootstrap-theme.min.css" />
<link rel="stylesheet"
	href="resources/cdn/angular-ui-grid/4.0.2/ui-grid.min.css" />
<link rel="stylesheet" href="resources/cdn/toastr/2.1.3/toastr.min.css" />
<!--  END : Vendor -->

<link rel="shortcut icon" type="image/png" href="resources/favicon.ico"/>

<!--  START : Custom -->
<link rel="stylesheet" href="resources/css/main.css" />
<!--  END : Custom -->
</head>
<body ng-app="contactsApp">
	<div class="container-fluid" ng-controller="MainCtrl">
		<div class=row ng-init="fnInitContacts()">
			<nav role="navigation" class="col-sm-12 navbar navbar-default navbar-fixed-top">
				<div class="navbar-header">
        			<a href="http://www.webosmotic.com">
        				<img class="img-responsive" src="resources/images/logo.png"/>
        			</a>
    			</div>
			    <ul class="nav navbar-nav navbar-right">
			        <li><a href="http://www.webosmotic.com/examples"><strong>Back</strong></a></li>
			    </ul>
			</nav>
			<div class="container m-t-65">
				<div class="page-header">
    				<h3>Manage Contacts</h3>      
  				</div>
				<div class="row">
					<!-- START : Contact Form -->
					<div class="col-sm-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 ng-bind="contact.id ? 'Update Contact' : 'Add Contact'"></h4>
							</div>
							<div class="panel-body">
								<form name="contactForm" novalidate>
									<div class="form-group"
										ng-class="{ 'has-error' : contactForm.$submitted && contactForm.firstName.$invalid }">
										<label for="inputFirstName">
											First Name<span class=text-danger>*</span>
										</label> 
										<input type="text" class="form-control" id="inputFirstName" name=firstName
											placeholder="Enter first name" ng-model="contact.firstName"
											required />
									</div>
									<div class="form-group"
										ng-class="{ 'has-error' : contactForm.$submitted && contactForm.lastName.$invalid }">
										<label for="inputLastName">
											Last Name<span class=text-danger>*</span>
										</label> 
										<input type="text" class="form-control" id="inputLastName" name=lastName
											placeholder="Enter last name" ng-model="contact.lastName"
											required />
									</div>
									<div class="form-group"
										ng-class="{ 'has-error' : contactForm.$submitted && contactForm.mobile.$invalid }">
										<label for="inputMobile">
											Mobile<span class=text-danger>*</span>
										</label>
										<input type="text" class="form-control" id="inputMobile"
											name=mobile placeholder="Enter 10 digit mobile no."
											ng-model="contact.mobile" ng-pattern="/^\d{10}$/" required />
									</div>
									<button type="submit" class="btn btn-primary"
												ng-click="contactForm.$valid && fnSave(contact)">Save</button>
									<button type="reset" class="btn btn-warning" ng-click="fnReset()">Reset</button>
								</form>
							</div>
						</div>
					</div>
					<!-- END : Contact Form -->

					<!-- START : Contact List -->
					<div class="col-sm-8">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>Contact List</h4>
							</div>
							<div class="panel-body grid-panel-body">
								<div class="grid" ui-grid="gridOptions" ui-grid-pagination ui-grid-auto-resize></div>
							</div>
						</div>
					</div>
					<!-- END : Contact List -->
				</div>
			</div>
		</div>
	</div>
	<div class="preloader"><div class="loader"></div></div>
	<!--  START : Vendor -->
	<script type="text/javascript"
		src="resources/cdn/jquery/3.0.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="resources/cdn/toastr/2.1.3/toastr.min.js"></script>
	<script type="text/javascript"
		src="resources/cdn/angular/1.5.5/angular.min.js"></script>
	<script type="text/javascript"
		src="resources/cdn/angular/1.5.5/angular-resource.min.js"></script>
	<script type="text/javascript"
		src="resources/cdn/angular-ui-grid/4.0.2/ui-grid.min.js"></script>
	<!--  END : Vendor -->

	<!--  START : Custom -->
	<script type="text/javascript" src="resources/js/app.js"></script>
	<script type="text/javascript"
		src="resources/js/controller/mainCtrl.js"></script>
	<!--  END : Custom -->
</body>
</html>
