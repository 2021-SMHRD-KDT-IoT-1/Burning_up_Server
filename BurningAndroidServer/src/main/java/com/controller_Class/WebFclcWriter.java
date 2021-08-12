package com.controller_Class;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.F_ClcDAO;
import com.model.F_ClcDTO;
import com.model.UserDAO;
import com.model.UserDTO;

@WebServlet("/WebFclcWriter")
public class WebFclcWriter implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String moveURL = null;
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("dto");
		
		String id = dto.getId();
		String nfc_num = request.getParameter("nfc_num");
		String clc_dt = request.getParameter("clc_dt");
		String clc_dsp = request.getParameter("clc_dsp");
		
		F_ClcDAO dao = new F_ClcDAO();
		F_ClcDTO clcldto = new F_ClcDTO(id,nfc_num, clc_dt, clc_dsp);
		int cnt = dao.ClcUpload(clcldto);
		
		if(cnt>0) {
			System.out.println("수거신청 성공!");
			moveURL = "FclcMain.jsp";
		}else {
			System.out.println("수거신청 실패!");
			moveURL = "FclcWrite.jsp";
		}
		
		return moveURL;
	}
}
