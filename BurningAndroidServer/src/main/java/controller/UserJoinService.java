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
		
		//���ڵ�
		response.setContentType("text/plain; charset=euc-kr");
		
		System.out.println("��û Ȯ��");
		
		String code = request.getParameter("join_c");
		String id = request.getParameter("join_id");
		String pw = request.getParameter("join_pw");
		String name = request.getParameter("join_name");
		String tel = request.getParameter("join_tel");
		String gen = request.getParameter("join_gen");
		String bir = request.getParameter("join_birth");
		
		System.out.println("ȸ�� ����"+id+"/"+pw+"/"+name+"/"+tel+"/"+gen+"/"+bir+"/"+code);
		
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
