<%@ page language="java" contentType="text/html; charset= utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>


<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/webflow.css">
</head>
<title>Order Confirmation!</title>
<body style="background:#C7CBD0;">
<div class="container">
<div class="row">

<div class="col-sm-4 col-md-8">
 
<div class="panel panel-info">
<div class="panel-heading"><h1>Order Placed Successfully!</h1></div>
<div class="panel-body">

<div class="row" id="formContainer">
<div id="orderDisplay">
Your Order with Id: ${orderDetails.orderId}<br>
Will be Shipped to: ${orderDetails.shippingAddress.shippingAddress1}
${orderDetails.shippingAddress.shippingAddress2}
${orderDetails.shippingAddress.shippingCity}
${orderDetails.shippingAddress.shippingState}
${orderDetails.shippingAddress.shippingPincode}
<!--  <input type="submit" name="_eventId_toHome"/>-->
<a href="home">Submit</a>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>