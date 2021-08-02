<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Flask로부터 전달한 데이터 가져오기</h1>
	<%
		String data = request.getParameter("data");
		out.print(data);
	%>
</body>
</html>