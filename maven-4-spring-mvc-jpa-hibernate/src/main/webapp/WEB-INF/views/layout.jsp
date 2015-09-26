<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${param.title} - User Directory</title>
	</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/">Home page</a> | 
		<a href="${pageContext.request.contextPath}/create">Create New User</a> | 
	    <a href="${pageContext.request.contextPath}/list">List Users</a>
	</p>
	${param.body}
</body>
</html>