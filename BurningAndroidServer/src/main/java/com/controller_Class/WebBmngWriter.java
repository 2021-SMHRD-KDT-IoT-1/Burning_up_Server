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

		// title, writer, content ���ڵ�
		response.setContentType("text/html; charset=EUC-KR");

		// �� ���� �����̳� ���
		String savePath = request.getServletContext().getRealPath("img");
		
		System.out.println(savePath);
		
		// ������ ������ ���� ��� �� ���� ����
		File folder = new File(savePath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// �ִ� ���� ũ�� ����(10mb)
		int maxSize = 1024 * 1024 * 10;;

		// �����̸� ���ڵ� ����
		String encoding = "EUC-KR";
		
		String filename="";
		String originalFileName="";

		// cos.jar ���Ͼȿ� �ִ� Ŭ���� ���
		// ��û, ������, �ִ�ũ��, ���ڵ� ���, DefaultFileRenamePolicy : �̹��� ���� �ߺ�����
		MultipartRequest multi;
		try {

			multi = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());

			//�̸� ��ȯ
			Enumeration files = multi.getFileNames();
			//�ڷᰡ ���� ��� while�� ���
			String str = (String) files.nextElement();
			
			//���� �̸� ���
			filename= multi.getFilesystemName(str);
			
			//���� �̸� ��������
			originalFileName = multi.getOriginalFileName(str);

			String userName="";
			String uploadPath = savePath + File.separator + multi.getFilesystemName(str);

			// ������ ���̽��� �����ϱ����ؼ� ���� ��������
			String bld_flr = multi.getParameter("bld_flr");
			String bld_dwg = URLEncoder.encode(multi.getFilesystemName("bld_dwg"), "EUC-KR");

			System.out.println(bld_flr);
			System.out.println(bld_dwg);

			B_MngDTO dto = new B_MngDTO(bld_flr, bld_dwg);
			B_MngDAO dao = new B_MngDAO();

			int cnt = dao.Bupload(dto);

			if (cnt > 0) {
				System.out.println("���� ���ε� ����");
				moveURL = "bmngMain.jsp";
			} else {
				System.out.println("���� ���ε� ����");
				moveURL = "bmngWrite.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return moveURL;
	}
}
