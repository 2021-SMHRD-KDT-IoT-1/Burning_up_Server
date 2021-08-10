package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.F_AgnDAO;

@WebServlet("/Gyrosensor")
public class Gyrosensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String number = request.getParameter("gyroox");
		if (number == null) {
		number = "1";
		}
		int num = Integer.parseInt(number);
		

		System.out.print("gyro :");
		System.out.println(num);

		F_AgnDAO dao = new F_AgnDAO();
		dao.Gyrosensor(num);
			
		}
	
		

	}


