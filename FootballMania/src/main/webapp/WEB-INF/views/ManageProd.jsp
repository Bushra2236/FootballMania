<%@include file="AdminHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

<script>
  var prodDisplay = ${ProdList};
  var catDisplay = ${CategoryList};
  var suppDisplay =${SuppList};
  angular.module('myProd', []).controller('prodController', function($scope)
   {
                $scope.prods=prodDisplay;
           		$scope.cate= catDisplay;
           		$scope.supp = suppDisplay;
    });
  </script>




<div class= "container" ng-app="myProd">

<!-- update form -->
<c:choose>
<c:when test="${updateClicked==true}">
<div>
<div class="jumbotron">
<p>Update your Product here!</p>
<form:form ng-controller="prodController" method="POST" action="updateProdtoDB" commandName="command" enctype="multipart/form-data"> 
  <div class="form-group inline col-sm-6">
    <form:label for="ProdID" path="prodId">Enter Product ID</form:label>
    <form:input type="text" class="form-control" path="prodId" placeholder="Enter the ID provided to you" required="required" readonly="true"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="ProdName" path="prodName">Enter Product Name</form:label>
    <form:input type="text" class="form-control" path="prodName" placeholder="Enter the Product Name" required="required"/>
  </div>
  	
  	<!-- category drop down -->
  	<div class="form-group inline col-sm-6">
    <form:label path="prodCat">Product Category</form:label>
	<form:select path="prodCat" class="form-control input-sm">
	<option ng-repeat="cat in cate" value="{{cat.catId}}">{{cat.catName}}</option></form:select>
	</div>
	
	<!-- Supplier Drop down -->
	<div class="form-group inline col-sm-6">
    <form:label path="prodSupp">Product Supplier</form:label>
	<form:select path="prodSupp" class="form-control input-sm">
	<option ng-repeat="s1 in supp" value="{{s1.supplierId}}">{{s1.supplierName}}</option></form:select>
	</div>
  <div class="form-group inline col-sm-6">
    <form:label for="ProdQuant" path="prodQuant">Enter Product Quantity</form:label>
    <form:input type="number" class="form-control" path="prodQuant" placeholder="Enter the Product Name" required="true" pattern=".{2,}" title="Two or more characters"/>
  </div>
  <div class="form-group inline col-sm-6">
  
    <form:label for="ProdPrice" path="prodPrice">Enter Product Price</form:label>
    <form:input type="number" class="form-control" path="prodPrice" placeholder="Enter the Color" required="required"/>
  
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="ProdColor" path="prodColor">Enter Product Color</form:label>
    <form:input type="text" class="form-control" path="prodColor" placeholder="Enter the Color" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label  path="prodSize">Select Size</form:label>
    <form:select class="form-control" path="prodSize">
    <option value="small">Small</option>
    <option value="medium">Medium</option>
    <option value="large">Large</option>
   
    </form:select>
  </div>  
  <div class="form-group inline col-sm-6">
    <form:label  path="prodImage">Upload Image</form:label>
    <form:input type="file" class="form-control" path="prodImage"/>
  </div>
  
  <div class="form-group row">
       <button type="submit">Update Product</button>
      </div>
</form:form>
</div>
</div>
 </c:when>
  <c:otherwise>
  
  
  <!-- add form -->
<div>
<div class="jumbotron">
<p>Add your Product here!</p>
<form:form ng-controller="prodController" method="POST" action="addProd" commandName="command" enctype="multipart/form-data"> 
  <div class="form-group inline col-sm-6">
    <form:label for="ProdID" path="prodId">Enter Product ID</form:label>
    <form:input type="text" class="form-control" path="prodId" placeholder="Enter the ID provided to you" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="ProdName" path="prodName">Enter Product Name</form:label>
    <form:input type="text" class="form-control" path="prodName" placeholder="Enter the Product Name" required="required"/>
  </div>
  	
  	<!-- category drop down -->
  	<div class="form-group inline col-sm-6">
    <form:label path="prodCat">Product Category</form:label>
	<form:select path="prodCat" class="form-control input-sm">
	<option ng-repeat="cat in cate" value="{{cat.catId}}">{{cat.catName}}</option></form:select>
	</div>  
	<!-- Supplier Drop down -->
	<div class="form-group inline col-sm-6">
    <form:label path="prodSupp">Product Supplier</form:label>
	<form:select path="prodSupp" class="form-control input-sm">
	<option ng-repeat="s1 in supp" value="{{s1.supplierId}}">{{s1.supplierName}}</option></form:select>
	</div>
	<div class="form-group inline col-sm-6">
    <form:label for="ProdQuant" path="prodQuant">Enter Product Quantity</form:label>
    <form:input type="number" class="form-control" path="prodQuant" placeholder="Enter the Product Name" required="true" pattern=".{2,}" title="Two or more characters"/>
  </div>
  <div class="form-group inline col-sm-6">
  
    <form:label for="ProdPrice" path="prodPrice">Enter Product Price</form:label>
    <form:input type="number" class="form-control" path="prodPrice" placeholder="Enter the Color" required="required"/>
  
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="ProdColor" path="prodColor">Enter Product Color</form:label>
    <form:input type="text" class="form-control" path="prodColor" placeholder="Enter the Color" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label  path="prodSize">Select Size</form:label>
    <form:select class="form-control" path="prodSize">
    <option value="small">Small</option>
    <option value="medium">Medium</option>
    <option value="large">Large</option>
   
    </form:select>
  </div>  
  <div class="form-group inline col-sm-6">
    <form:label  path="prodImage">Upload Image</form:label>
    <form:input type="file" class="form-control" path="prodImage"/>
  </div>
  
  <div class="form-group row">
       <button type="submit">Add Product</button>
      </div>
</form:form>
</div>
</div>
</c:otherwise>
</c:choose>




<!--Table  -->
<div ng-controller="prodController">
<div id="teamDis" class="jumbotron">
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
    <td><img src="./resources/{{prod.prodId}}.jpg" height="50px" width="50px" /></td>
    <td>
    <a class="btn btn-default btn-xs" href="fetchProduct?prodId={{prod.prodId}}"><span class="glyphicon glyphicon-pencil"></span></a>
 	<a class="btn btn-danger btn-xs" href="deleteProduct?prodId={{prod.prodId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>   
    </td>
  </tr>
</table>
</div>
</div>
</div>
<%@include file="AdminFooter.jsp" %>


