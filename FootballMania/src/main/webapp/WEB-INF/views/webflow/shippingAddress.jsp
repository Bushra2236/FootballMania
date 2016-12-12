<%@ page language="java" contentType="text/html; charset= utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/webflow.css">
<title>Shipping Details</title>
</head>

<body style="background:#C7CBD0;">
<div class="container">
<div class="row">

<div class="col-sm-4 col-md-8">
 
<div class="panel panel-info">
<div class="panel-heading">Enter Shipping Details!</div>
<div class="panel-body">
                            
<div class="row" id="formContainer">			
			
	<form:form method="POST" commandName="shippingAddress">
			 
  <div class="form-group row">
    <label for="">Address Line 1</label>
    <form:input type="text" class="form-control" path="shippingAddress1" placeholder="Enter Address Line 1" required="required"/>
  </div>
  
  <div class="form-group row">
    <label for="">Address Line 2</label>
    <form:input type="text" class="form-control" path="shippingAddress2" placeholder="Enter Address Line 2" required="required"/>
  </div>
  
  <div class="form-group row">
    <label for="">City</label>
    <form:input type="text" class="form-control" path="shippingCity" placeholder="Enter City" required="required"/>
  </div>
  
  <div class="form-group row">
    <label for="">State</label>
    <form:input type="text" class="form-control" path="shippingState" placeholder="Enter State" required="required"/>
  </div>
  
  <div class="form-group row">
    <label for="">Pincode/Zipcode</label>
    <form:input type="text" class="form-control" path="shippingPincode" placeholder="Enter Pincode" required="required" pattern="^\d{6}$"/>
  </div>
  <div class="form-group row">
  <input type="submit" name= "_eventId_submitShippingAddress">
  </div>
  
		</form:form>	
	</div>
		</div>
		</div>
		</div>
		</div>
		</div>
</body>
</html>