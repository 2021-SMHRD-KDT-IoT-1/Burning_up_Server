package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/UserSelectService")
public class UserSelectService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		response.setContentType("application/json; charset=euc-kr");
		String id = request.getParameter("login_id");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		dao.select(id);
		ArrayList<MemberDTO> members = new ArrayList<MemberDTO>(dao.select(id));
		
		Gson gson = new Gson();
		
		//Java 객체 -> JSON 문자열 변환
		String jsonArray = gson.toJson(members);
		
		System.out.println(jsonArray);
		
		//요청한 곳으로 데이터 전송
		out.print(jsonArray);
		
		
		
	}

}
