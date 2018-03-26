package com.kaishengit.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/upload")
public class FileuploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/fileupload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//������enctype��������Ϊmultipart/form-data֮��ᵼ���޷�ͨ��req.getparameter("name")����ȡ����ֵ
		String desc = req.getParameter("desc");
		System.out.println("desc:" + desc);
		
		//1.�����ļ��ϴ�·��
		File saveDir = new File("d:/upload");
		
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		
		File tempDir = new File("d:/temp");
		
		if(!tempDir.exists()) {
			tempDir.mkdir();
		}
		
		// �жϱ��Ƿ�����enctype����Ϊmutilpart/form-data
		if(ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			// ���û�������С
			itemFactory.setSizeThreshold(1024);
			// ������ʱ�ļ���
			itemFactory.setRepository(tempDir);
			
			ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
			// ��������ϴ��ļ���С
			servletFileUpload.setSizeMax(1024 * 1024 * 10);
			
			try {
				// ��ȡ���б�Ԫ�أ�������ͨԪ�غ��ļ�Ԫ�أ���װ��FileItem�����List����
				List<FileItem> itemList = servletFileUpload.parseRequest(req);
				for(FileItem item : itemList) {
					if(item.isFormField()) {
						// ��ͨԪ��
						System.out.println("fildName:" + item.getFieldName()); // ��ȡ��name������ֵ
						System.out.println("getString:" + item.getString("UTF-8")); // ��ȡ����ͨԪ�ص�valueֵ
					} else {
						// �ļ�Ԫ��
						System.out.println("fileName:" + item.getFieldName()); // ��ȡ���ļ�Ԫ�ص�name����ֵ
						System.out.println("name:" + item.getName()); // ��ȡ�ϴ��ļ����ļ���
				
						if(StringUtils.isNotEmpty(item.getName())) {

							// ����ļ�������
							InputStream in = item.getInputStream();
							// �ļ������
							// �������ļ�
							String fileName = item.getName(); // 1.jpg
							String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));// ef1a-fdf1.jpg
							
							OutputStream out = new FileOutputStream(new File(saveDir, newFileName)); // d:/upload/1.jpg
							
							IOUtils.copy(in, out);
							
							/*byte[] buffer = new byte[1024];
							int len = -1;
							while((len = in.read(buffer)) != -1) {
								out.write(buffer, 0, len);
							}*/
							
							out.flush();
							out.close();
							in.close();
						}
						
					}
				}
			} catch (FileUploadException e) {
				throw new RuntimeException("�ļ��ϴ��쳣");
			}
			
			
		} else {
			throw new RuntimeException("enctype�����쳣��");
		}
		
		
	}
	
}
