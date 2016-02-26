<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="List - User Directory" />
    <c:param name="body">
		<h1>User List</h1>	
		
		<c:if test="${not empty message}">
			<div class="alert alert-success"><em>${message}</em></div>
		</c:if>
		
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Name</th>
					<th>Level</th>
					<th>Token</th>
					<c:if test="${loggedUser.level > 0}">
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.id}</td>
						<td>${user.login}</td>
						<td>${user.firstName} ${user.lastName}</td>
						<td>
							<c:choose>
							    <c:when test="${user.level >= 30}">
							    	Jedi
							    </c:when>
							    <c:when test="${user.level >= 20}">
							    	Admin
							    </c:when>
							    <c:when test="${user.level >= 10}">
							        Power User
							    </c:when>
							    <c:otherwise>
							        User
						    	</c:otherwise>
							</c:choose>
						</td>
						<td>${user.securityToken}</td>
						<c:if test="${loggedUser.level > 0}">
							<td>
							<c:if test="${loggedUser.id != user.id && loggedUser.level >= user.level}">
								<a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
							</c:if>
							</td>
							<td>
							<c:if test="${loggedUser.id != user.id && loggedUser.level >= user.level}">
								<a href="${pageContext.request.contextPath}/delete/${user.id}">Delete</a>
							</c:if>
							</td>
							<td>
							<c:if test="${loggedUser.id != user.id && loggedUser.level == 30 && !empty user.securityToken}">
								<a href="${pageContext.request.contextPath}/kick/${user.id}">Kick</a>
							</c:if>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:param>
</c:import>