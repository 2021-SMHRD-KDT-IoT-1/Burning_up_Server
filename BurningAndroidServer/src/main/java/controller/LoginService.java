package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		response.setContentType("text/plain; charset=euc-kr");
		
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		
		MemberDAO dao = new MemberDAO();
		
		int code = dao.login(id, pw);
		
		PrintWriter out = response.getWriter();
		
		//코드가 1이나 2일 경우만 로그인 값을 넘겨줌
		if(code == 1 || code == 2) {
			out.print(code);
		}else {
			out.print(0);
		}
		
		
	}

}
