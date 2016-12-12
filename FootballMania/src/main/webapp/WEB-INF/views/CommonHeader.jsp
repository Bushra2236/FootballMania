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

app1.controller('cartController',function($scope){
	$scope.cart = cartDisplay;
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
     <li><a href="perform_logout"><i class="fa fa-sign-out fa-3" aria-hidden="true"></i></a></li>
     <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
     <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     
     
     </ul>
</nav>



