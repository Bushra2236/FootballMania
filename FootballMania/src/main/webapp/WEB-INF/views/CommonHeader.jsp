<%@ page language="java" contentType="text/html; charset= utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!--Font Awesome Script  -->
<script src="https://use.fontawesome.com/c055af1911.js"></script>

<link rel="stylesheet" href="resources/myCss.css">



<html>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="resources/customQuery.js"></script>
<script>

var catDisplay= ${catList};
var app1= angular.module('myDisplay', []);

app1.controller('disController', function($scope)
		   {
		                $scope.cate=catDisplay;
		    });
		    
app1.controller('displayController', function($scope)
		   {
    $scope.prods=prodDisplay;
	
});		    

app1.controller('teamController',function($scope){
	$scope.teams= teamDisplay;
});
</script>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Football Mania</title>
</head>


<body ng-app="myDisplay">
<nav class="navbar  navbar-light" >
  <div class="navbar-header">
  <img class="logo" src= "resources/logo.png">    
    </div>
    
    <ul class="nav navbar-nav">
    <li class="active">      
    <a href="home">Home</a></li>
    <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
    <ul class="dropdown-menu" ng-controller="disController">
          <li><a href="fetchProducts?catId={{cat.catId}}" ng-repeat="cat in cate">{{cat.catName}}</a></li>
     </ul>
     </li>
     <li><a href="fetchTeams">Teams</a></li> 
     <li><a href="contactus">Contact Us</a></li> 
     
     </ul>

     <ul class="nav navbar-nav navbar-right" >
     <li><a data-toggle="modal" data-target="#signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     <li><a data-toggle="modal" data-target="#Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     </ul>
</nav>



<!-- Modal for Login -->
 <div id="Login" class="modal fade" role="dialog">
<div class="modal-dialog">

<!-- Modal content-->
<div class="modal-content">     
<div class="modal-body">
<p>Login here...!!</p>
<div class="form-body">
<hr class="colorgraph">
<div class="tab-content">
        <div id="sectionA" class="tab-pane fade in active">
        <div class="innter-form">
            <form class="sa-innate-form" method="post">
            <label style="margin-top:-10px;">Email Address</label>
            <input type="text" name="username">
            <label>Password</label>
            <input type="password" name="password">
            <hr class="colorgraph">
            <input type="checkbox" name="rememberme" id="rememberme" class="visible" value="1"> 
            Remember ME!
			<br>
            <button type="submit">Sign In</button>
            <a href="">Forgot Password?</a>
            </form>
            </div>
        </div>
    </div>
    </div>
    </div>
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
</div>
<!-- Modal for Login ends -->




<!-- Modal for Registration begins -->
	<div id="signUp" class="modal fade" role="dialog">
  	<div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
     <div class="modal-body">
     <p>Register Here!</p>
        	<form:form method="POST" action="registerUser" commandName="commands">
			<hr class="colorgraph">
			
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
    		<form:input type="text" class="form-control" path="firstName" placeholder="First Name" required="required"></form:input>
			</div>
			</div>
 			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input type="text" class="form-control" path="lastName" placeholder="Last Name" required="required"></form:input>
			</div>
			</div>
			</div>
			
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
    		<form:input type="text" class="form-control" path="userId" placeholder="Enter a UserName" required="required"></form:input>
			</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input type="email" class="form-control" path="emailAddress" placeholder="Email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Email should be of the format 'username@domain'"></form:input>	
			</div>
			</div>
			</div>
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input id="pass" type="password" class="form-control" path="userPassword" placeholder="Password" required="required"></form:input>
			</div>
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input id="passcon" type="password" class="form-control" path="confirmPassword" placeholder="Confirm Password" required="required" onChange="isPasswordMatch();"></form:input>
			</div>
			<div id="divCheckPassword"></div>
			</div>
			</div>
		
			
			<div class="row">	
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input type="text" class="form-control" path="address1" placeholder="Address Line 1" required="true"></form:input>
			</div>
			</div>
	
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input type="text" class="form-control" path="address2" placeholder="Address Line 2" required="true"></form:input>
			</div>
			</div>
			</div>			
			
			<div class="row">
			<div class="col-sm-4">
			<div class= "form-group">
			<form:input type="text" class="form-control" path="userCity" placeholder="City" required="true"></form:input>
			</div>
			</div>
			<div class = "col-sm-4">
			<form:input type="text" class="form-control" path="userState" placeholder="State" required="true"></form:input>
			</div>
			<div class = "col-sm-4">
			<form:input type="text" class="form-control" path="userPincode" placeholder="Pincode" required="true" pattern="^\d{6}$"></form:input>
			</div>
			</div>
	
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<form:input type="text" class="form-control" path="userMobile" placeholder="Mobile Number" required="true" pattern="^[789]\d{9}$" title="Mobile Number should start with 7,8 or 9 and be 10 digits"></form:input>
			</div>
			</div>
			</div>
			
			<hr class="colorgraph">
			<div class="row">
			<div class="col-xs-4 col-md-4">
			<button id="register" type="submit">Register</button>
			</div>
			</div>
			</form:form>
		
      </div>
    </div>
    
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
  </div>
</div>
<!-- Modal for Registration ends -->

			