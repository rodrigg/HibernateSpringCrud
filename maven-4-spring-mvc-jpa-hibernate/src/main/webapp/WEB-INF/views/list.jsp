<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="User List" />
    <c:param name="body">
    	<h1>User List</h1>
		<p><em>${message}</em></p>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Name</th>
					<th>Level</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.id}</td>
						<td>${user.login}</td>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.level}</td>
						<td>
							<a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/delete/${user.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="search" method="get"><input type="text" name="searchstring" value="" /><input type="submit" value="Search" /></form>
	</c:param>
</c:import>