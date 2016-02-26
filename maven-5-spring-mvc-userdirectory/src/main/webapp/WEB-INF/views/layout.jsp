<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>${param.title}</title>
	    
	    <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">		
		
		<style>
			body {
			  padding-top: 50px;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">User Directory</a>
	        </div>
	        <div id="navbar" class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	            <c:if test="${loggedUser.id > 0}">
					<c:if test="${loggedUser.level > 10}">
						<li><a href="${pageContext.request.contextPath}/create">Create New User</a></li>
					</c:if> 
					<li><a href="${pageContext.request.contextPath}/list">List Users</a></li>
				</c:if>				
	          </ul>	          
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="${pageContext.request.contextPath}/about">About</a></li>
	            <c:if test="${loggedUser.id > 0}">
	          		<li><p class="navbar-text">Logged in as ${loggedUser.firstName} ${loggedUser.lastName}</p></li> 
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>
				<c:if test="${empty loggedUser}">
					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				</c:if>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	
	    <div class="container">
	
		${param.body}	    
		
		</div><!-- /.container -->
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    	
    	<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</body>
</html>