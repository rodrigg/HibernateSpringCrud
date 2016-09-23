<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="Login - User Directory" />
    <c:param name="body">
		<h1>Login User</h1>
		
		<c:if test="${not empty message}">
			<div class="alert alert-success"><em>${message}</em></div>
		</c:if>
		
		<form method="post" action="${pageContext.request.contextPath}/login">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <div class="form-group">
		    <label for="login">Login</label>
		    <input type="text" class="form-control" id="login" name="login" placeholder="Login">
		  </div>
		  <div class="form-group">
		    <label for="passwd">Password</label>
		    <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-default">Login</button>
		</form>
	</c:param>
</c:import>