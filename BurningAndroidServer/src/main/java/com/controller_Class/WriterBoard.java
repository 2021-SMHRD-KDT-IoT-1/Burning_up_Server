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

		// title, writer, content ���ڵ�
		response.setContentType("text/html; charset=EUC-KR");
		
		// �� ���� �����̳� ���
		String root = request.getSession().getServletContext().getRealPath("/uploadFreeboard");
		//������ ������ ���� ��� �� ���� ����
		File folder = new File(root);
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		//�ִ� ���� ũ�� ����(15mb)
		int maxSize = 15*1024*1024;
		
		//�����̸� ���ڵ� ����
		String encoding = "EUC-KR";
		
		//cos.jar ���Ͼȿ� �ִ� Ŭ���� ���
		//��û, ������, �ִ�ũ��, ���ڵ� ���, DefaultFileRenamePolicy : �̹��� ���� �ߺ�����
		MultipartRequest multi;
		try {
			
			multi = new MultipartRequest(request, root, maxSize, encoding, new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();

			String uploadPath = root + File.separator + multi.getFilesystemName(str);

			//������ ���̽��� �����ϱ����ؼ� fileName, title, content ���� ���� ��������
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
				System.out.println("���� ���ε� ����");
			}else {
				System.out.println("���� ���ε� ����");
			}
			moveURL = "boardMain.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return moveURL;
	}

}
