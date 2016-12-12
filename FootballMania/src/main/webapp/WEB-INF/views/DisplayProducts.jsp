<%@include file="CommonHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script>
  var prodDisplay = ${displayProd};
</script>

  
 <div class= "container">
 
 <div ng-controller="displayController">
<div id="teamDis" class="jumbotron">
<form:form ng-controller="displayController" method="POST" action="updateQuantity" commandName="comm">
<table class="table table-bordered">
<tr>
<th>Product ID</th>
<th>Product Names</th>
<th>Product Category</th>
<th>Product Supplier</th>
<th>Product Quantity</th>
<th>Product Image</th>
<th></th>
</tr>

  <tr ng-repeat="prod in prods">
    <td>{{ prod.prodId }}</td>
    <td>{{ prod.prodName }}</td>
    <td>{{ prod.prodCat }}</td>
    <td>{{ prod.prodSupp }}</td>
    <td>{{prod.prodQuant}}</td>
    <td><img src="./resources/{{prod.prodId}}.jpg" height="100px" width="100px" /></td>
    <td><a href="add?prodId={{prod.prodId}}">Add to Cart</a></td>
  </tr>
</table>
</form:form>
</div>
</div>
 
 </div>
 
 <%@include file="CommonFooter.jsp" %>