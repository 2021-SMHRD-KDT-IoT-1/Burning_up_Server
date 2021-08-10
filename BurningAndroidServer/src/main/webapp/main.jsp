<%@page import="com.model.UserDAO"%>
<%@page import="com.model.UserDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
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
	
/* 	ArrayList<WebMessageDTO> list_message = new ArrayList<WebMessageDTO>();
	if (dto != null) {
		list_message = dao.showMessage(dto.getEmail());
	} */
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
							<li><h5>로그인</h5></li>
								<form action="WebLoginServiceCon.do" method="post">
									<li><input type="text" placeholder="ID를 입력하세요" name="id"></li>
									<li><input type="password"  placeholder="PW를 입력하세요" name="pw"></li>
									<li><input type="submit" value="로그인" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<li><h5>회원가입</h5></li>
								<form action="WebJoinServiceCon.do" method="post">
									<li><input type="text"  placeholder="ID를 입력하세요" name="id"></li>
									<li><input type="password"  placeholder="PW를 입력하세요" name="pw"></li>
									<li><input type="text"  placeholder="이름을 입력하세요" name="name"></li>
									<li><input type="text"  placeholder="전화번호를 입력하세요" name="tel"></li>
									<li><input type="text"  placeholder="건물주소를 입력하세요" name="addr"></li>
									<li><input type="text"  placeholder="건물명을 입력하세요" name="b_name"></li>
									<li><input type="submit" value="가입하기" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<%if(dto != null) {%>
										<h1><%=dto.getB_name()%>님<br> 환영합니다.</h1>
								<%}else{ %>
										<h1>GIFTLIFE에 오신걸 환영합니다</h1>
								<%} %>
							</header>
							
							<%if(dto != null) {%>
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
											<li><a href="#" class="button next scrolly">사용기록 보기</a></li>
										</ul>
									</div>
								</div>
							</form>
							<%} %>
						</div>
					</section>

				<!-- Main -->
					<div id="main">
					
					<!-- Two -->
						<%if(dto != null) {%>
							<section id="one">
								<div class="inner">
									<header class="major">
										<h2>알림메세지</h2>
									</header>
									<table style="width:80%;">
										<tr align="center">
											<th style="width:30%; text-align: center;"> 번호 </th>
											<th style="width:40%; text-align: center;"> 소화기 번호 </th>
											<th style="width:30%; text-align: center;"> 시간 </th>
										</tr>
										<%-- <%for(int i = 0; i<list_message.size(); i++){ %>
										<tr>
											<td> <%=i+1 %></td>
											<td> <%=list_message.get(i).getSendName() %></td>
											<td> <%=list_message.get(i).getMessage() %></td>
											<td> <%=list_message.get(i).getM_date()%></td>
											<td> <a href="MessageDeleteOneServiceCon.do?num=<%=list_message.get(i).getNum() %>">삭제</a></td>
										</tr>
										<%} %> --%>
									</table>
								</div>
							</section>
						<%} %>
					</div>

						<!-- 관리 메뉴 -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="FinfoMain.jsp" class="link">소화기 관리</a></h3>
										<p>소화기 관리 상황</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">소화기 폐기</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="bmngMain.jsp" class="link">건물 관리</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="boardMain.jsp" class="link">공지사항</a></h3>
										<p>소방 공지 사항</p>
									</header>
								</article>
							<%--	<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header> 
								</article> --%>
							</section>
					
				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="copyright">
								<li>&copy; GIFTLIFE</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

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

