
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 <script src="/OSProc/resources/Angular/controllers.js"></script>

<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Items</h1>
				<p>Add Items</p>
			</div>
 		</div>
	</section>
<section class="container" ng-app="itemModule">
		<form:form  modelAttribute="item" class="form-horizontal" ng-controller="itemCtrl">
			<fieldset>
				<legend>Add new Item</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
		

				<div class="form-group">
					<label class="control-label col-lg-2" for="serialNo">Serial Number</label>
					<div class="col-lg-10">
						<form:input ng-model="serialNo" id="serialNo" path="serialNo" type="text" class="form:input-large"/>
						<form:errors path="serialNo" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input  id="name" path="name" type="text" class="form:input-large" ng-model="name" />
							<form:errors path="name" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category"></label>
					<div class="col-lg-10">
                                        
                                                <form:select path="category" id="catagoriesSelect">  
                                                    <c:forEach var="category" items="${categories}">
                                                        <form:option  value="${category}" id="${category.id}"> ${category.name}</form:option>  
                                                    </c:forEach>
                                                    
                                                </form:select>
                                            
					</div>
				</div>



				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input  type="button" id="btnAdd" class="btn btn-primary" ng-click="addItem()" value="Add" /> 
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>