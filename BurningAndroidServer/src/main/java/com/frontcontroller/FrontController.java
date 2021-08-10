package com.frontcontroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.controller_Class.WebBmngWriter;
import com.controller_Class.WebDeleteServiceCon;
import com.controller_Class.WebJoinServiceCon;
import com.controller_Class.WebLoginServiceCon;
import com.controller_Class.WebLogoutServiceCon;
import com.controller_Class.WebUpdateServiceCon;
import com.controller_Class.WriterBoard;
import com.model.UserDAO;
import com.model.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		System.out.println("[FrontController]");
		
		Command command = null;
		
		String rqsURI = request.getRequestURI();
		System.out.println("어디서 왔느뇨~~ 저는 " +rqsURI+"에서 왔습니다요~~");
		
		String path = request.getContextPath();
		System.out.println("프로젝트 이름이 무엇인고~~ "+path+"이옵니다~");
		
		String resultURI = rqsURI.substring(path.length()+1);
		System.out.println("서블릿 이름을 대보아라~~ "+resultURI+"라고 하옵니다");
		
		
		if(resultURI.equals("WebLoginServiceCon.do")) {
			
			command = new WebLoginServiceCon();
			
		}else if(resultURI.equals("WebJoinServiceCon.do")) {
			
			command = new WebJoinServiceCon();
			
		}else if(resultURI.equals("WebLogoutServiceCon.do")) {

			command = new WebLogoutServiceCon();
			
		}else if(resultURI.equals("WebDeleteServiceCon.do")) {
			
			command = new WebDeleteServiceCon();
			
		}else if(resultURI.equals("WebUpdateServiceCon.do")) {
			
			command = new WebUpdateServiceCon();
			
		}else if(resultURI.equals("WebWriterBoard.do")) {
			
			command = new WriterBoard();
			
		}else if(resultURI.equals("WebBmngWriter.do")) {
			
			command = new WebBmngWriter();
		}
		
		String moveURL = command.execute(request, response);
		response.sendRedirect(moveURL);
		
	}

}
