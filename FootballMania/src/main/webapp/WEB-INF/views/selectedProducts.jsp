<%@include file="CommonHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="resources/customQuery.js"></script>

<script>
var cartDisplay = ${cart};
</script>

<div class= "container">
 
 <div>
<div id="teamDis" class="jumbotron">
<div ng-controller="cartController">
 <table class="table table-bordered">
 <tr>
<th>Product Names</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th></th>
</tr>
 <tr ng-repeat="carts in cart">
 <td>{{carts.productName}}</td>
 <td>{{carts.price}}</td>
 <td>
 <input type="text" style="color:black;" value="{{carts.quantity}}" ng-model="carts.quantity"><input>
 <a class="btn btn-default btn-xs" href="updateQuantity?cartId={{carts.cartId}}&quantity={{carts.quantity}}"><span class="glyphicon glyphicon-pencil"></span></a>
 </td>
  
 <td>
 	<a class="btn btn-danger btn-xs" href="deleteFromCart?cartId={{carts.cartId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>   
    </td>
 </tr>
 </table>
</div>
<div><a href="CartCheckout">CheckOut</a></div>
 </div>

 </div>

 </div>
 
<%@include file="CommonFooter.jsp" %>