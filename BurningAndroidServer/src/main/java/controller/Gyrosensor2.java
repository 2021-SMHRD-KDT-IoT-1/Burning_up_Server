package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.F_AgnDAO;

@WebServlet("/Gyrosensor2")
public class Gyrosensor2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String agn = request.getParameter("value");
		System.out.println(agn);
		PrintWriter out = response.getWriter();
		F_AgnDAO dao = new F_AgnDAO();
		String value = dao.showGyro(agn);
		System.out.println(value+"¹ë·ù");
		if(value.equals("0")) {
		out.print(0);
		}else {
			out.print(1);
		}
	}

}
