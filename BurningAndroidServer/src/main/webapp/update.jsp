<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserDTO"%>
<%@page import="com.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
   
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
	String id = dto.getId();
	ArrayList<UserDTO> list = dao.oneselect(id);
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
					
					<nav id="Update">
					<div style="text-align: right; margin-right: 30px; margin-bottom: 40px;">
					<a href="select.jsp" class="button next scrolly">�ǵ��ư���</a></div>	
						<ul class="actions vertical"><br>
							<li><h1>������ ��������</h1></li>
								<form action="WebUpdateServiceCon.do" method="post">
									<%if(dto != null) {%>
										<li><h4><%=dto.getB_name()%> ������ ����</h4></li><br>
									<%}else{ %>
										<li>�α��� �� �̿��� �ּ���.</li>
									<%} %>
									<table style="width:70%; margin-left: auto; margin-right: auto;">
										<tr>
											<td>���̵�</td>
											<td align="left"><%=list.get(0).getId() %></td>
										</tr>
										<tr>
											<td>��й�ȣ</td>
											<td align="left"><input type="password" name="pw" placeholder="PW�� �Է��ϼ���"></td>
										</tr>
										<tr>
											<td>������ �̸�</td>
											<td align="left"><input type="text" name="name" placeholder="�̸��� �Է��ϼ���"></td>
										</tr>
										<tr>
											<td>����ó</td>
											<td align="left"><input type="text" name="tel" placeholder="��ȭ��ȣ�� �Է��ϼ���"></td>
										</tr>
										<tr>
											<td>�ǹ���</td>
											<td align="left"><%=list.get(0).getB_name() %> </td>
										</tr>
										<tr>
											<td>�ǹ� �ּ�</td>
											<td align="left"><%=list.get(0).getAddr() %> </td>
										</tr>
									</table>
									<input type="submit" value="��������" class="button scrolly">
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

