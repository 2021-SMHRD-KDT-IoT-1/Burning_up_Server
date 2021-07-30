package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/UserUpdateService")
public class UserUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("dto");
		
		String id = dto.getId();
		String pw = request.getParameter("join_pw");
		String name = request.getParameter("join_naem");
		String tel = request.getParameter("join_tel");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO UpdateDto = new MemberDTO(id, pw, name, tel);
		int cnt = dao.UserUpdate(UpdateDto);
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
