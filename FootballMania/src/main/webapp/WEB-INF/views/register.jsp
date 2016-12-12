<%@include file="CommonHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="resources/customQuery.js"></script>

<div class= "container">
<div>
<div id="teamDis" class="jumbotron">
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
</div>
<%@include file="CommonFooter.jsp" %>