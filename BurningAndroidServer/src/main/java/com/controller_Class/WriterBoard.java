package com.controller_Class;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.model.FrfinfoDAO;
import com.model.FrfinfoDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriterBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;

		// title, writer, content 인코딩
		response.setContentType("text/html; charset=EUC-KR");
		
		// 웹 서버 컨테이너 경로
		String root = request.getSession().getServletContext().getRealPath("/uploadFreeboard");
		//저장할 폴더가 없는 경우 새 폴더 생성
		File folder = new File(root);
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		//최대 파일 크기 지정(15mb)
		int maxSize = 15*1024*1024;
		
		//사진이름 인코딩 설정
		String encoding = "EUC-KR";
		
		//cos.jar 파일안에 있는 클래스 사용
		//요청, 저장경로, 최대크기, 인코딩 방식, DefaultFileRenamePolicy : 이미지 파일 중복제거
		MultipartRequest multi;
		try {
			
			multi = new MultipartRequest(request, root, maxSize, encoding, new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();

			String uploadPath = root + File.separator + multi.getFilesystemName(str);

			//데이터 베이스에 저장하기위해서 fileName, title, content 등의 정보 가져오기
			String frf_tlt = multi.getParameter("title");
			String frf_cnt = multi.getParameter("content");
			String frf_file = URLEncoder.encode(multi.getFilesystemName("frf_file"), "EUC-KR");
			
			System.out.println(frf_tlt);
			System.out.println(frf_cnt);
			System.out.println(frf_file);
			
			FrfinfoDTO dto = new FrfinfoDTO(frf_tlt, frf_cnt, frf_file);
			FrfinfoDAO dao = new FrfinfoDAO();
			
			int cnt = dao.upload(dto);
			
			if(cnt>0) {
				System.out.println("파일 업로드 성공");
			}else {
				System.out.println("파일 업로드 실패");
			}
			moveURL = "boardMain.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return moveURL;
	}

}
