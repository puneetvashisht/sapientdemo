<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Declaration -->
<%! int count = 0; %>
<!-- Java Code  -->

<p>Visit Count: <%=++count %></p>

<table border="1">
<%
	for (int i=0;i<10;i++){
		
	
%>
<tr><td>Row Data <%=i%></td></tr>

<%
	}
%>
</table>

</body>
</html>