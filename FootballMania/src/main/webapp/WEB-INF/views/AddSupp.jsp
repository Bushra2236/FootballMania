<%@include file="AdminHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script>
  var suppDisplay = ${SuppList};
  var ctr;
  angular.module('mySupp', []).controller('suppController', function($scope)
   {
                $scope.supplier=suppDisplay;
           
    });
  </script>
  
  
 <!-- update form -->
<c:choose>
<c:when test="${updateClicked==true}">
<div  class="container">
<div class="jumbotron">
 <p>Update Supplier Info here!</p> 
<form:form method="POST" action="updateSupptoDB" commandName="command" enctype="multipart/form-data"> 
  <div class="form-group inline col-sm-6">
    <form:label for="SuppID" path="supplierId">Enter Supplier's ID</form:label>
    <form:input type="text" class="form-control" path="supplierId" placeholder="Enter the ID provided to you" required="required" readonly="true"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppName" path="supplierName">Enter Supplier's Name</form:label>
    <form:input type="text" class="form-control" path="supplierName" placeholder="Enter the Supplier's Name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppAdd1" path="supplierAdd1">Enter Address Line 1</form:label>
    <form:input type="text" class="form-control" path="supplierAdd1" placeholder="Enter the Plot number/building name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppAdd2" path="supplierAdd2">Enter Address Line 2</form:label>
    <form:input type="text" class="form-control" path="supplierAdd2" placeholder="Enter the Street/Area Name" required="required"/>
  </div>
    <div class="form-group inline col-sm-6">
    <form:label for="SuppCity" path="supplierCity">Enter City Name</form:label>
    <form:input type="text" class="form-control" path="supplierCity" placeholder="Enter the City Name" required="required"/>
  </div>
<div class="form-group inline col-sm-6">
    <form:label for="SuppState" path="supplierState">Enter State Name</form:label>
    <form:input type="text" class="form-control" path="supplierState" placeholder="Enter the State Name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppPin" path="supplierPin">Enter PinCode</form:label>
    <form:input type="text" class="form-control" path="supplierPin" placeholder="Enter the Pincode" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppNumber" path="supplierNumber">Enter Supplier's Mobile Number</form:label>
    <form:input type="text" class="form-control" path="supplierNumber" placeholder="Enter Supplier's Mobile number" required="required"/>
  </div>
  <div class="form-group row" >
       <button type="submit">Update Supplier</button>
      </div>
</form:form>
</div>
</div>
</c:when>
 
 <c:otherwise>
   
  
  <!-- add form -->
<div  class="container">
<div class="jumbotron">
<p>Add Supplier Info!</p>
<form:form method="POST" action="addSupp" commandName="command"> 
  <div class="form-group inline col-sm-6">
    <form:label for="SuppID" path="supplierId">Enter Supplier's ID</form:label>
    <form:input type="text" class="form-control" path="supplierId" placeholder="Enter the ID provided to you" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppName" path="supplierName">Enter Supplier's Name</form:label>
    <form:input type="text" class="form-control" path="supplierName" placeholder="Enter the Supplier's Name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppAdd1" path="supplierAdd1">Enter Address Line 1</form:label>
    <form:input type="text" class="form-control" path="supplierAdd1" placeholder="Enter the Plot number/building name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppAdd2" path="supplierAdd2">Enter Address Line 2</form:label>
    <form:input type="text" class="form-control" path="supplierAdd2" placeholder="Enter the Street/Area Name" required="required"/>
  </div>
    <div class="form-group inline col-sm-6">
    <form:label for="SuppCity" path="supplierCity">Enter City Name</form:label>
    <form:input type="text" class="form-control" path="supplierCity" placeholder="Enter the City Name" required="required"/>
  </div>
<div class="form-group inline col-sm-6">
    <form:label for="SuppState" path="supplierState">Enter State Name</form:label>
    <form:input type="text" class="form-control" path="supplierState" placeholder="Enter the State Name" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppPin" path="supplierPin">Enter PinCode</form:label>
    <form:input type="text" class="form-control" path="supplierPin" placeholder="Enter the Pincode" required="required"/>
  </div>
  <div class="form-group inline col-sm-6">
    <form:label for="SuppNumber" path="supplierNumber">Enter Supplier's Mobile Number</form:label>
    <form:input type="text" class="form-control" path="supplierNumber" placeholder="Enter Supplier's Mobile number" required="required" pattern="[0-9]{10}" title="10-digit number"/>
  </div>
  <div class="form-group row" >
       <button type="submit">Add Supplier</button>
      </div>
</form:form>
</div>
</div>
</c:otherwise>
</c:choose>


<div class = "container" ng-app="mySupp" ng-controller="suppController">
<div id="teamDis" class="jumbotron">
<table class="table table-bordered">
<tr>
<th>Supplier ID</th>
<th>Supplier Names</th>
<th>Supplier Address Line 1</th>
<th>Supplier Address Line 1</th>
<th>Supplier City</th>
<th>Supplier State</th>
<th>Supplier Pincode</th>
<th>Supplier Mobile Number</th>
<th></th>
</tr>

  <tr ng-repeat="supp in supplier">
    <td>{{ supp.supplierId }}</td>
    <td>{{ supp.supplierName }}</td>
    <td>{{ supp.supplierAdd1 }}</td>
    <td>{{ supp.supplierAdd2 }}</td>
    <td>{{ supp.supplierCity }}</td>
    <td>{{ supp.supplierState }}</td>
    <td>{{ supp.supplierPin }}</td>
    <td>{{ supp.supplierNumber }}</td>
    <td>
    <a class="btn btn-default btn-xs" href="fetchSupplier?supplierId={{supp.supplierId}}"><span class="glyphicon glyphicon-pencil"></span></a>
 	<a class="btn btn-danger btn-xs" href="deleteSupplier?supplierId={{supp.supplierId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>   
    </td>
  </tr>
</table>
</div>
</div>
<%@include file="AdminFooter.jsp" %>

