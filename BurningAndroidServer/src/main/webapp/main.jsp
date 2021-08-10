<%@page import="com.model.UserDAO"%>
<%@page import="com.model.UserDTO"%>
<%@page import="java.util.ArrayList"%>

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

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>�α���</h5></li>
								<form action="WebLoginServiceCon.do" method="post">
									<li><input type="text" placeholder="ID�� �Է��ϼ���" name="id"></li>
									<li><input type="password"  placeholder="PW�� �Է��ϼ���" name="pw"></li>
									<li><input type="submit" value="�α���" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<li><h5>ȸ������</h5></li>
								<form action="WebJoinServiceCon.do" method="post">
									<li><input type="text"  placeholder="ID�� �Է��ϼ���" name="id"></li>
									<li><input type="password"  placeholder="PW�� �Է��ϼ���" name="pw"></li>
									<li><input type="text"  placeholder="�̸��� �Է��ϼ���" name="name"></li>
									<li><input type="text"  placeholder="��ȭ��ȣ�� �Է��ϼ���" name="tel"></li>
									<li><input type="text"  placeholder="�ǹ��ּҸ� �Է��ϼ���" name="addr"></li>
									<li><input type="text"  placeholder="�ǹ����� �Է��ϼ���" name="b_name"></li>
									<li><input type="submit" value="�����ϱ�" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<%if(dto != null) {%>
										<h1><%=dto.getB_name()%>��<br> ȯ���մϴ�.</h1>
								<%}else{ %>
										<h1>GIFTLIFE�� ���Ű� ȯ���մϴ�</h1>
								<%} %>
							</header>
							
							<%if(dto != null) {%>
							<form method="post" action="#">
								<div class="row gtr-uniform">
									<div class="col-12">
										<select name="demo-category" id="demo-category" style="background: rgba(40, 47, 75, 3); margin-bottom: 20px;">
											<option value="">&nbsp;&nbsp;&nbsp;�� ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;</option>
											<option value="1">&nbsp;&nbsp;1��</option>
											<option value="1">&nbsp;&nbsp;2��</option>
											<option value="1">&nbsp;&nbsp;3��</option>
										</select>
									</div>
									<div class="col-12">
										<ul class="actions">
											<li><input type="submit" value="ȭ�� �˸�" class="primary" /></li>
											<li><a href="#" class="button next scrolly">����� ����</a></li>
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
										<h2>�˸��޼���</h2>
									</header>
									<table style="width:80%;">
										<tr align="center">
											<th style="width:30%; text-align: center;"> ��ȣ </th>
											<th style="width:40%; text-align: center;"> ��ȭ�� ��ȣ </th>
											<th style="width:30%; text-align: center;"> �ð� </th>
										</tr>
										<%-- <%for(int i = 0; i<list_message.size(); i++){ %>
										<tr>
											<td> <%=i+1 %></td>
											<td> <%=list_message.get(i).getSendName() %></td>
											<td> <%=list_message.get(i).getMessage() %></td>
											<td> <%=list_message.get(i).getM_date()%></td>
											<td> <a href="MessageDeleteOneServiceCon.do?num=<%=list_message.get(i).getNum() %>">����</a></td>
										</tr>
										<%} %> --%>
									</table>
								</div>
							</section>
						<%} %>
					</div>

						<!-- ���� �޴� -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="FinfoMain.jsp" class="link">��ȭ�� ����</a></h3>
										<p>��ȭ�� ���� ��Ȳ</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">��ȭ�� ���</a></h3>
										<p>HTML�� ���������ִ� ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="bmngMain.jsp" class="link">�ǹ� ����</a></h3>
										<p>Java�� �⺻���� �� �� ���α׷��� ���/��ũ��Ʈ ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="boardMain.jsp" class="link">��������</a></h3>
										<p>�ҹ� ���� ����</p>
									</header>
								</article>
							<%--	<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>�� ������Ʈ �� ���� ���� ����ϴ� ����������</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>�������� ����������Ʈ�� �� ����� Ȱ���ϼ���!</p>
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

