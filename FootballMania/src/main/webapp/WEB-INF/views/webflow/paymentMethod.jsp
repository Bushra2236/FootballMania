

<%@ page language="java" contentType="text/html; charset= utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script>
function back(){
document.getElementById('payment').action='${flowExecutionUrl}&_eventId=backtoBilling';
document.getElementById('payment').submit();
}
</script>

<link rel="stylesheet" href="resources/webflow.css">
<head><title>Payment Method</title></head>

<body style="background:#C7CBD0;" ng-app="">
<div class="container">
<div class="row">

<div class="col-sm-4 col-md-8">

<div class="panel panel-info">
<div class="panel-heading">Payment Method</div>
<div class="panel-body">

<div class="row" id="formContainer">
<form:form method="POST" commandName="paymentMethod" id="payment">
<label for="">Select Payment Method</label><br>
    <form:radiobutton path="paymentMethod"  ng-model="details" value="COD" required="required"/>Cash On Delivery<br>
    <form:radiobutton path="paymentMethod"  ng-model="details" value="Debit" required="required"/>Debit Card<br>
    <form:radiobutton path="paymentMethod"  ng-model="details" value="Credit" required="required"/> Credit Card<br>
    <form:radiobutton path="paymentMethod"  ng-model="details" value="NetBanking" required="required"/>Netbanking<br>

<input type="submit" name= "_eventId_submitPaymentMethod" value="Done">
<input type="button" value="Cancel" onclick="back()">
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>

<div>
<div class="container" ng-show="details!='COD'">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                      <!-- Name -->
          <div class="control-group">
            <label class="control-label"  for="username">CARD HOLDER'S NAME</label>
            <div class="controls">
                 <input type="text" class="form-control" id="cardNumber" placeholder=""
                                required  />
            </div>
          </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expiryMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expiryMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expiryYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV2 CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CVV2" required />
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <a href="#" class="btn btn-default btn-lg btn-block" role="button">Pay</a>
        </div>
    </div>
</div>
</div>
</body>
</html>