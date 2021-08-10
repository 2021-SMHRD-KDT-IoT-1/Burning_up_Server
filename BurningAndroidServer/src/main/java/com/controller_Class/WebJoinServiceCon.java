package com.controller_Class;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.UserDAO;
import com.model.UserDTO;

public class WebJoinServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String b_name = request.getParameter("b_name");
		
		System.out.println(id +"/ "+pw+"/ "+name+"/ "+tel+"/ "+addr+"/ "+b_name);

		
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO(id, pw, name, tel, addr, b_name, null, null, 1);
		int cnt = dao.Join(dto);
		
		if(cnt>0) {
			System.out.println("회원가입 성공!");
			
			HttpSession session = request.getSession();
			session.setAttribute("b_name", b_name);
			
			moveURL = "join_success.jsp";
		}else {
			System.out.println("회원가입 실패!");
			moveURL = "main.jsp";
		}
		
		return moveURL;
	}

}
