package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Frf_InfDAO;
import model.Frf_InfDTO;


@WebServlet("/BoardService")
public class BoardUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String title = request.getParameter("");
			String writer = request.getParameter("");
			String content = request.getParameter("");

			System.out.println("title");
			System.out.println("writer");
			System.out.println("content");

			Frf_InfDTO dto = new Frf_InfDTO(title, writer, content);
			Frf_InfDAO dao = new Frf_InfDAO();

			int cnt = dao.upload(dto);
			
			PrintWriter out = response.getWriter();

			if (cnt > 0) {
				System.out.println("파일 업로드 성공!");
				out.print(1);
			} else {
				System.out.println("파일 업로드 실패!");
				out.print(0);
			}

	}

}
