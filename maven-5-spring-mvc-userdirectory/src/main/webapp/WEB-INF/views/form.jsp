<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="New - User Directory" />
    <c:param name="body">
		<h1>New User</h1>
		<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/create">
			<table>
				<tbody>
					<tr>
						<td>Login:</td>
						<td><form:input path="login" /></td>
						<td><form:errors path="login" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:password path="passwd" /></td>
						<td><form:errors path="passwd" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>First name:</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Level</td>
						<td>
							<form:select path="level" id="level">
					        	<form:option value="0">User</form:option>
					        	<form:option value="10">Power User</form:option>
					        	<form:option value="20">Admin</form:option>
					        	<form:option value="30">Jedi</form:option>
					        </form:select>
						</td>
						<td><form:errors path="level" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Create" /></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</c:param>
</c:import>