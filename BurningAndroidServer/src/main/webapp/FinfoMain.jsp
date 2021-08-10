<%@page import="com.model.F_ChckDAO"%>
<%@page import="com.model.F_ChckDTO"%>
<%@page import="com.model.F_InfoDTO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<F_InfoDTO> Flist = dao.FinfoShow();
	UserDTO dto = (UserDTO)session.getAttribute("dto");
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
								<h1>Landing</h1>
							</header>
							<div class="content">
								<p>Lorem ipsum dolor sit amet nullam consequat<br />
								sed veroeros. tempus adipiscing nulla.</p>
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
												<h3>Orci maecenas</h3>
											</header>
											<form method="post" action="#">
												<div class="row gtr-uniform">
													<div class="col-12">
														<select name="demo-category" id="demo-category" style="background: rgba(40, 47, 75, 3); margin-bottom: 20px;">
															<option value="">&nbsp;&nbsp;&nbsp;층 선택&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▼&nbsp;&nbsp;</option>
															<option value="1">&nbsp;&nbsp;1층</option>
															<option value="1">&nbsp;&nbsp;2층</option>
															<option value="1">&nbsp;&nbsp;3층</option>
														</select>
													</div>
													<div class="col-12">
														<ul class="actions">
															<li><input type="submit" value="화재 알림" class="primary" /></li>
														</ul>
													</div>
												</div>
											</form>
											<table>
												<tr>
													<td>층</td>
													<td>설치장소</td>
													<td>설치일</td>
												</tr>
												
												<%for(int i=0; i<Flist.size();i++){ %>
													<tr>
														<td><%=Flist.get(i).getBld_flr() %>층</td>
														<td> <a href="FinfoView.jsp?f_nick=<%= Flist.get(i).getF_nick() %>"><%=Flist.get(i).getF_nick()%></a></td>
														<td><%=Flist.get(i).getNfc_regi() %></td>
												<%} %>	
											</table>
											<a href="main.jsp"><button id="writer">홈으로가기</button></a>
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