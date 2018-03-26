package com.kaishengit.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ��ȡ���ص��ļ���
		String fileName = req.getParameter("fileName");
		String name = req.getParameter("name"); // �ҵ���Ƭ
		// get������������
//		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		
		File saveDir = new File("d:/upload");
		File file = new File(saveDir, fileName);
		
		if(file.exists()) {
			// �����ļ�
			// ��ȡ�ļ�������
			InputStream in = new FileInputStream(file);
			// ��ȡ����� (��Ӧ�����)
			OutputStream out = resp.getOutputStream();
			// name��Ϊ�� ����
			if(StringUtils.isNotEmpty(name)) {
				// ����MIME����
				resp.setContentType("application/octet-stream");
				// �����ļ���
				name = new String(name.getBytes("UTF-8"),"ISO8859-1");
				resp.addHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
				// �����ļ��ܴ�С
				resp.setContentLengthLong(file.length());
			}
			
			IOUtils.copy(in, out);
			out.flush();
			out.close();
			in.close();
			
		} else {
			resp.sendError(404, "�����쳣");
		}
	}
	
}
