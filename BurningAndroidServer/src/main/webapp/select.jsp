<%@page import="com.model.UserDTO"%>
<%@page import="com.model.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 1.request영역에 저장된 정보를 가져오시오. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>GIFTLIFE 홈페이지</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

	<%
	UserDTO dto = (UserDTO) session.getAttribute("dto");
	UserDAO dao = new UserDAO();
	String id = dto.getId();
	ArrayList<UserDTO> list = dao.oneselect(id);
	%>

	<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="main.jsp" class="logo"><strong>GIFTLIFE</strong> 
						<span>필요한 순간, 소방이 함께 합니다.</span></a>
						<nav>
						
						<%if(dto != null){ %>
								<a href="select.jsp">마이페이지</a>
								<a href="WebLogoutServiceCon.do">로그아웃</a>
						<%}else{ %>	
								<a href="#menu">로그인</a>
						<%} %>	
						</nav>
					</header>
					
				<!-- Menu -->
					<div style="text-align: right; margin-right: 30px; margin-bottom: 40px;">
					<a href="main.jsp" class="button next scrolly">홈으로 가기</a><br></div>
					<nav id="Update">	
							<caption>
							<h2><%=dto.getB_name()%><br> 
							관리자 정보</h2>
							</caption>
						
						<table style="width:70%; margin-left: auto; margin-right: auto;">
							<tr >
								<td >아이디</td>
								<td><%=list.get(0).getId() %></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><%=list.get(0).getPw() %></td>
							</tr>
							<tr>
								<td>관리자 이름</td>
								<td><%=list.get(0).getName() %> </td>
							</tr>
							<tr>
								<td>연락처</td>
								<td><%=list.get(0).getTel() %> </td>
							</tr>
							<tr>
								<td>건물명</td>
								<td><%=list.get(0).getB_name() %> </td>
							</tr>
							<tr>
								<td>건물 주소</td>
								<td><%=list.get(0).getAddr() %> </td>
							</tr>
						</table>
					</nav>		
					<a href="update.jsp" class="button next scrolly">관리자 정보수정</a>
					<a href="delete.jsp" class="button next scrolly">회원탈퇴</a>	
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

