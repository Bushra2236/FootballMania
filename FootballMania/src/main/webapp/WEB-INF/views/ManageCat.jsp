<%@include file="AdminHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script>
  var catDisplay = ${CatList};
  var ctr;
  angular.module('myCategory', []).controller('catController', function($scope)
   {
                $scope.cate=catDisplay;
           
    });
  </script>
  
  
  <!-- update form -->
<c:choose>
<c:when test="${updateClicked==true}">
<div  class="container col-sm-6">
<div class="jumbotron">
<p>Update Category!</p>
<form:form method="POST" action="updateCattoDB" commandName="command"> 
  <div class="form-group row">
    <form:label for="CatID" path="catId">Enter Category ID</form:label>
    <form:input type="text" class="form-control" path="catId" placeholder="Enter the ID provided to you" required="required" readonly="true"/>
  </div>
  <div class="form-group row">
    <form:label for="CatName" path="catName">Enter Category Name</form:label>
    <form:input type="text" class="form-control" path="catName" placeholder="Enter the final Team Name" required="required"/>
  </div>
  <div class="form-group row" >
       <button type="submit">Update Category</button>
      </div>
</form:form>
</div>
</div>
 </c:when>
  
 <c:otherwise>
  <!-- add form -->
<div  class="container col-sm-6">
<div class="jumbotron">
<p>Add Category!</p>
<form:form method="POST" action="addCat" commandName="command"> 
  <div class="form-group row">
    <form:label  path="CatId">Enter Category ID</form:label>
    <form:input type="text" class="form-control" path="catId" placeholder="Enter the ID provided to you" required="required"/>
  </div>
  <div class="form-group row">
    <form:label  path="CatName">Enter Category Type</form:label>
    <form:input type="text" class="form-control" path="catName" placeholder="Enter the Category type" required="required"/>
  </div>
  <div class="form-group row" >
       <button type="submit">Add Category</button>
      </div>
</form:form>
</div>
</div>
</c:otherwise>
</c:choose>
  
  
 <!--Table  -->
<div class = "container col-sm-6" ng-app="myCategory" ng-controller="catController">
<div id="teamDis" class="jumbotron" >
Categories
<table class="table table-bordered">
<tr>
<th>Category ID</th>
<th>Category Type</th>
<th></th>
</tr>
  <tr ng-repeat="cat in cate">
    <td>{{ cat.catId }}</td>
    <td>{{ cat.catName }}</td>
    <td>
    <a class="btn btn-default btn-xs" href="fetchCategory?catId={{cat.catId}}"><span class="glyphicon glyphicon-pencil"></span></a>
 	<a class="btn btn-danger btn-xs" href="deleteCategory?catId={{cat.catId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>   
    </td>
  </tr>
</table>
</div>
</div>
<%@include file="AdminFooter.jsp" %>


  
