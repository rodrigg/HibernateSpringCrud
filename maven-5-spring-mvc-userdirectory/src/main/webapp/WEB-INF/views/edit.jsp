<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="Edit - User Directory" />
    <c:param name="body">
		<h1>Edit User</h1>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger"><em>${error}</em></div>
		</c:if>
		
		<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/edit/${user.id}">
		  <div class="form-group">
		    <label for="login">Login</label>
		    <form:input path="login" class="form-control" />
		    <form:errors path="login" cssStyle="color: red;" />
		  </div>
		  <div class="form-group">
		    <label for="passwd">Password</label>
		    <form:password path="passwd" class="form-control" />
		    <form:errors path="passwd" cssStyle="color: red;" />
		  </div>
		  <div class="form-group">
		    <label for="firstName">First name</label>
		    <form:input path="firstName" class="form-control" />
		    <form:errors path="firstName" cssStyle="color: red;" />
		  </div>
		  <div class="form-group">
		    <label for="lastName">Last name</label>
		    <form:input path="lastName" class="form-control" />
		    <form:errors path="lastName" cssStyle="color: red;" />
		  </div>
		  <div class="form-group">
		    <label for="level">Level</label>
		    <form:select path="level" id="level" class="form-control">
	        	<form:option value="0">User</form:option>
	        	<form:option value="10">Power User</form:option>
	        	<form:option value="20">Admin</form:option>
	        	<form:option value="30">Jedi</form:option>
	        </form:select>
		    <form:errors path="level" cssStyle="color: red;" />
		  </div>
		  <button type="submit" class="btn btn-default">Update</button>
		</form:form>
		
	</c:param>
</c:import>