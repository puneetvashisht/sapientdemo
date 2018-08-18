<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.cts.Course, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>




	<table border="1">
		<%
			List<Course> courses = (List<Course>) request.getAttribute("courses");
			for (Course course : courses) {
		%>
		<tr>
			<td><%=course.getId()%></td>
			<td><%=course.getName()%></td>
			<td><%=course.getSummary()%></td>
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>