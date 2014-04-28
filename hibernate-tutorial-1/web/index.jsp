<%@ page import="java.util.List" %>
<%@ page import="com.rodionbykov.hibernate.entity.Car" %>
<%@ page import="com.rodionbykov.hibernate.CarService" %>
<%--
  Created by IntelliJ IDEA.
  User: Rodion Bykov
  Date: 26.04.2014
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
<%
    CarService service = new CarService();

    List<Car> cars = service.getAll();

    for(Car c : cars){
        %>
    <li><%=c.getName()%></li>
        <%
    }

%>

  </body>
</html>
