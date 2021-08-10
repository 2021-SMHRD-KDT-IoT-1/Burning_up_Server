package com.controller_Class;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.UserDAO;
import com.model.UserDTO;
public class WebUpdateServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
			
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("dto"); //로그인한 정보를 받아오는 DTO
		
		
		String id = dto.getId();
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String b_name = dto.getB_name();
		String addr = dto.getAddr();
		
		UserDTO updateDto = new UserDTO(id, pw, name, tel, addr, b_name);
		UserDAO dao = new UserDAO();
		
		int cnt = dao.update(updateDto);
		
		if(cnt>0) {
			System.out.println("회원정보 수정 성공!");
			moveURL = "select.jsp";
			//업데이트 한 값에 대한 세션으로 다시 적용
			session.setAttribute("dto", updateDto);
		}else {
			System.out.println("회원정보 수정 실패!");
			moveURL = "update.jsp";
		}
		
		return moveURL;
	}

}
