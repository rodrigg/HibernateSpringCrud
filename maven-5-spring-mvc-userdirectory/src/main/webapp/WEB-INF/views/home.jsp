<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="Home - User Directory" />
    <c:param name="body">
		<h1>
			Welcome
		</h1>
		<p>The time on the server is ${serverTime}</p>
	</c:param>
</c:import>