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

@WebServlet("/MngJoinService")
public class MngJoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("요청 확인");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("adr");
		String b_name = request.getParameter("bdname");

		System.out.println("회원 정보" + id + "/" + pw + "/" + name + "/" + tel + "/" + addr + "/" + b_name);

		MemberDTO member = new MemberDTO(id, pw, name, tel, addr, b_name, 1);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.MngJoin(member);

		PrintWriter out = response.getWriter();

		if (cnt > 0) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

}
