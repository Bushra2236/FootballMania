<%@include file="CommonHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>



	<div class= "container col-sm-8" style="padding-left:100px;">
	<div>
	<p>${ErrorMessage}
	<div id="teamDis" class="jumbotron">
	<p>Login Here!</p>
        	<form:form method="POST" action="perform_login">
			<hr class="colorgraph">
			
			
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
    		<input type="text" class="form-control" name="userName" placeholder="Enter your UserName" required="required"/>
			</div>
			</div>
			</div>
			
			<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="form-group">
			<input type="password" class="form-control" name="password" placeholder="Password" required="required"/>	
			</div>
			</div>
			</div>
			
			<hr class="colorgraph">
			<div class="row">
			<div class="col-xs-4 col-md-4">
			<button id="register" type="submit">Login</button>
			</div>
			</div>
			</form:form>
</div>
</div>
</div>
<%@include file="CommonFooter.jsp" %>