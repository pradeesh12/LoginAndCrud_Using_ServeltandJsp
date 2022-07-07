<%@page import="org.company.entities.Emp" isELIgnored="false"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    if(session.getAttribute("user")!=null)
    {
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
`	<h1>Welcome to home page</h1>
	<a href="./employess">Get Employees</a>
	<a href="addEmployee.jsp">Add Employees</a>
	<hr>
<table>
	<tr>
		<td>Eno</td>
		<td>Name</td>
		<td>Address</td>
	</tr>
	<%
		List<Emp> employees=(List<Emp>)request.getAttribute("employees");
		if(employees!=null)
		{
			for(Emp e:employees)
			{
	%>
	<tr>	
			<td><%=e.getEno() %></td>
			<td><%=e.getName() %></td>
			<td><%=e.getAddress() %></td>
			<td><a href="./delete?eno=<%=e.getEno()%>">Delete</a></td>
			<td><a href="./update?eno=$eno=${e.eno}">Update</a></td>
	</tr>
	<%
	}} %>
</table>
</body>
</html>
<%}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("msg","Please Login first");
	rd.forward(request,response);
}
%>