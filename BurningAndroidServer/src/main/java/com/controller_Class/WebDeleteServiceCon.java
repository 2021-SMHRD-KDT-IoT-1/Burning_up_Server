package com.controller_Class;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.UserDAO;
import com.model.UserDTO;

public class WebDeleteServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String moveURL = null;
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("dto"); 
		
		String id = dto.getId();
		String pw = request.getParameter("pw");
		
		UserDAO dao = new UserDAO();
		UserDTO deleteDto = new UserDTO(id, pw);
		int cnt = dao.delete(deleteDto);
		
		if(cnt>0) {
			System.out.println("È¸¿øÅ»Åð¼º°ø");
			//¼¼¼Ç»èÁ¦
			session.removeAttribute("dto");
			
			moveURL = "main.jsp";
		}else {
			System.out.println("È¸¿øÅ»Åð½ÇÆÐ");
			moveURL = "delete.jsp";
		}
		
		return moveURL;
	}

}
