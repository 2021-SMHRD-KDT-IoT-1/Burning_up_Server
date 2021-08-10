package com.controller_Class;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.model.B_MngDAO;
import com.model.B_MngDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BmngWriter")
public class WebBmngWriter implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String moveURL = null;

		// title, writer, content 인코딩
		response.setContentType("text/html; charset=EUC-KR");

		// 웹 서버 컨테이너 경로
		String savePath = request.getServletContext().getRealPath("img");
		
		System.out.println(savePath);
		
		// 저장할 폴더가 없는 경우 새 폴더 생성
		File folder = new File(savePath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// 최대 파일 크기 지정(10mb)
		int maxSize = 1024 * 1024 * 10;;

		// 사진이름 인코딩 설정
		String encoding = "EUC-KR";
		
		String filename="";
		String originalFileName="";

		// cos.jar 파일안에 있는 클래스 사용
		// 요청, 저장경로, 최대크기, 인코딩 방식, DefaultFileRenamePolicy : 이미지 파일 중복제거
		MultipartRequest multi;
		try {

			multi = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());

			//이름 반환
			Enumeration files = multi.getFileNames();
			//자료가 많은 경우 while문 사용
			String str = (String) files.nextElement();
			
			//파일 이름 얻기
			filename= multi.getFilesystemName(str);
			
			//원래 이름 가져오기
			originalFileName = multi.getOriginalFileName(str);

			String userName="";
			String uploadPath = savePath + File.separator + multi.getFilesystemName(str);

			// 데이터 베이스에 저장하기위해서 정보 가져오기
			String bld_flr = multi.getParameter("bld_flr");
			String bld_dwg = URLEncoder.encode(multi.getFilesystemName("bld_dwg"), "EUC-KR");

			System.out.println(bld_flr);
			System.out.println(bld_dwg);

			B_MngDTO dto = new B_MngDTO(bld_flr, bld_dwg);
			B_MngDAO dao = new B_MngDAO();

			int cnt = dao.Bupload(dto);

			if (cnt > 0) {
				System.out.println("파일 업로드 성공");
				moveURL = "bmngMain.jsp";
			} else {
				System.out.println("파일 업로드 실패");
				moveURL = "bmngWrite.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return moveURL;
	}
}
