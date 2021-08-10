<%@page import="com.model.UserDAO"%>
<%@page import="com.model.UserDTO"%>
<%@page import="com.model.FrfinfoDTO"%>
<%@page import="com.model.FrfinfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>GIFTLIFE Ȩ������</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

	<%
	UserDTO udto = (UserDTO) session.getAttribute("dto");
	UserDAO udao = new UserDAO();
	
	//get������� ���� num �޾ƿ���
	int frf_num = Integer.parseInt(request.getParameter("frf_num"));
	//Sting get_num = request.getParameter("get_num");
	//int num = Integer.parseInt(num);
	
	FrfinfoDAO dao = new FrfinfoDAO();
	FrfinfoDTO dto = dao.showOne(frf_num);
	%>

	<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="main.jsp" class="logo"><strong>GIFTLIFE</strong> 
						<span>�ʿ��� ����, �ҹ��� �Բ� �մϴ�.</span></a>
						<nav>
						
						<%if(dto != null){ %>
								<a href="select.jsp">����������</a>
								<a href="WebLogoutServiceCon.do">�α׾ƿ�</a>
						<%}else{ %>	
								<a href="#menu">�α���</a>
						<%} %>	
						</nav>
					</header>

				
			<div id = "board">
				<table id="list">
					<tr>
						<td>����</td>
						<td><%= dto.getFrf_tlt() %></td>
					</tr>
					<tr>
						<td>�ۼ���</td>
						<td><%= udto.getName() %></td>
					</tr>
					<tr>
						<td colspan="2">����</td>
					</tr>
					<tr>
						<td colspan="2">
						<%= dto.getFrf_cnt() %>
						<img src="img/<%= dto.getFrf_file() %>">
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="boardMain.jsp"><button>�ڷΰ���</button></a></td>
					</tr>
				</table>
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