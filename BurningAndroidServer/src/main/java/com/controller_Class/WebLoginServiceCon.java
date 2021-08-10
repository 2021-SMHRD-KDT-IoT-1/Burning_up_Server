package com.controller_Class;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.UserDAO;
import com.model.UserDTO;

public class WebLoginServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO(id, pw);

		UserDTO resultDTO = dao.login(dto); 
		
		if(resultDTO != null) {
			System.out.println("로그인 성공!");
			
			HttpSession session = request.getSession();
			session.setAttribute("dto", resultDTO);
		}else {
			System.out.println("로그인 실패!");
			HttpSession session = request.getSession();
			session.removeAttribute("dto");
		}
		
		moveURL = "main.jsp";
		
		return moveURL;
	}

}
