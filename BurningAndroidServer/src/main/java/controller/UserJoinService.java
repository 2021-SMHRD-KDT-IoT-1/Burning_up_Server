package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/UserJoinService")
public class UserJoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		response.setContentType("text/plain; charset=euc-kr");
		
		System.out.println("요청 확인");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gen = request.getParameter("gen");
		String bir = request.getParameter("birth");
		
		System.out.println("회원 정보"+id+"/"+pw+"/"+name+"/"+tel+"/"+gen+"/"+bir);
		
		MemberDTO usermember = new MemberDTO(2, id, pw, name, tel, gen, bir);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.UserJoin(usermember);
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
