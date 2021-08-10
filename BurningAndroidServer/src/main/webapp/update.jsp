<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserDTO"%>
<%@page import="com.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
   
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
					
					<nav id="Update">
					<div style="text-align: right; margin-right: 30px; margin-bottom: 40px;">
					<a href="select.jsp" class="button next scrolly">되돌아가기</a></div>	
						<ul class="actions vertical"><br>
							<li><h1>관리자 정보수정</h1></li>
								<form action="WebUpdateServiceCon.do" method="post">
									<%if(dto != null) {%>
										<li><h4><%=dto.getB_name()%> 관리자 정보</h4></li><br>
									<%}else{ %>
										<li>로그인 후 이용해 주세요.</li>
									<%} %>
									<table style="width:70%; margin-left: auto; margin-right: auto;">
										<tr>
											<td>아이디</td>
											<td align="left"><%=list.get(0).getId() %></td>
										</tr>
										<tr>
											<td>비밀번호</td>
											<td align="left"><input type="password" name="pw" placeholder="PW를 입력하세요"></td>
										</tr>
										<tr>
											<td>관리자 이름</td>
											<td align="left"><input type="text" name="name" placeholder="이름을 입력하세요"></td>
										</tr>
										<tr>
											<td>연락처</td>
											<td align="left"><input type="text" name="tel" placeholder="전화번호를 입력하세요"></td>
										</tr>
										<tr>
											<td>건물명</td>
											<td align="left"><%=list.get(0).getB_name() %> </td>
										</tr>
										<tr>
											<td>건물 주소</td>
											<td align="left"><%=list.get(0).getAddr() %> </td>
										</tr>
									</table>
									<input type="submit" value="정보수정" class="button scrolly">
								</form>
						</ul>
					</nav>			
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

