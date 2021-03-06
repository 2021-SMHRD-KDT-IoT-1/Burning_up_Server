<%@page import="com.model.UserDTO"%>
<%@page import="com.model.FrfinfoDTO"%>
<%@page import="com.model.FrfinfoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>GIFTLIFE</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assetsBoard/css/main.css" />
		<link rel="stylesheet" href="assetsBoard/css/board.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
</head>
<body>

<%
FrfinfoDAO dao = new FrfinfoDAO();
ArrayList<FrfinfoDTO> list = dao.showBoard();
UserDTO dto = (UserDTO)session.getAttribute("dto");
%>
		
		
			<div id="board">
				<table id = "list">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>등록일</td>
					</tr>
					
					<%for(int i=0; i<list.size();i++){ %>
						<tr>
							<td> <%=list.get(i).getFrf_num() %> </td>
							<td> <a href="viewBoard.jsp?frf_num=<%= list.get(i).getFrf_num() %>"><%=list.get(i).getFrf_tlt() %> </a></td>
							<td> <%=dto.getName() %> </td>
							<td> <%=list.get(i).getFrf_dt() %> </td>
						</tr>
					<%} %>	
				</table>
				
				<a href="main.jsp"><button id="writer">홈으로가기</button></a>
				<a href="WriterBoard.jsp"><button id="writer">작성하러가기</button></a>
			</div>


			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
</body>
</html>