<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="New User" />
    <c:param name="body">
		<h1>
			User Directory
		</h1>
		<p>The time on the server is ${serverTime}</p>
	</c:param>
</c:import>
