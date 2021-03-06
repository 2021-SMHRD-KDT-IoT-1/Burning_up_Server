<%@page import="com.model.F_ChckDTO"%>
<%@page import="com.model.F_InfoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.F_ChckDAO"%>
<%@page import="com.model.F_InfoDAO"%>
<%@page import="com.model.UserDAO"%>
<%@page import="com.model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
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
	
	F_InfoDAO dao = new F_InfoDAO();
	F_ChckDAO cdao = new F_ChckDAO();
	
	ArrayList<F_InfoDTO> Flist = dao.FinfoShow();
	ArrayList<F_ChckDTO> Fclist = cdao.FcinfoShow();
	UserDTO dto = (UserDTO)session.getAttribute("dto");
	
	//get방식으로 보낸 값 받아오기
	String f_nick = request.getParameter("f_nick");
		
	F_InfoDTO fdto = dao.FinfoShowOne(f_nick);
	
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
					<nav id="menu">
						<ul class="links">
							<li><a href="index.html">Home</a></li>
							<li><a href="landing.html">Landing</a></li>
							<li><a href="generic.html">Generic</a></li>
							<li><a href="elements.html">Elements</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="#" class="button primary fit">Get Started</a></li>
							<li><a href="#" class="button fit">Log In</a></li>
						</ul>
					</nav>

				<!-- Banner -->
				<!-- Note: The "styleN" class below should match that of the header element. -->
					<section id="banner" class="style2">
						<div class="inner">
							<span class="image">
								<img src="images/pic07.jpg" alt="" />
							</span>
							<header class="major">
								<h1>소화기 점검 내역</h1>
							</header>
							<div class="content">
								
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- Two -->
							<section id="two" class="spotlights">
								<section>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3><%=fdto.getF_nick() %></h3>
											</header>
											<table id="list">
												<tr>
													<td>점검 번호</td>
													<td>점검 날짜</td>
													<td>점검 결과</td>
												</tr>
												<%for(int i=0; i<Fclist.size();i++){ %>
													<%if(fdto.getF_nick().equals(Fclist.get(i).getF_nick())) {%>
														<tr>
															<td> <%=Fclist.get(i).getChck_num() %> </td>
															<td> <a href="FinfoDetailView.jsp?chck_date=<%= Fclist.get(i).getChck_date() %>"><%=Fclist.get(i).getChck_date() %> </a></td>
															<%if(Fclist.get(i).getChck_pwd().equals("정상")
																&&Fclist.get(i).getChck_press().equals("정상")
																&&Fclist.get(i).getChck_pin().equals("정상")
																&&Fclist.get(i).getChck_body().equals("정상")
																&&Fclist.get(i).getChck_lever().equals("정상")
																&&Fclist.get(i).getChck_hose().equals("정상")){ %>
																<td>정상</td>
															<%}else{ %>
																<td>비정상</td>
															<%} %>
														</tr>
													<%} %>
												<%} %>	
												<tr>
													<td colspan="2"><a href="FinfoMain.jsp"><button>뒤로가기</button></a></td>
												</tr>
											</table>
										</div>
									</div>
								</section>
					</div>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>