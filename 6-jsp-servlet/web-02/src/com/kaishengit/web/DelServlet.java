package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//���տͻ�������
		String id = req.getParameter("id");
		System.out.println("hello");
		BookService bookService = new BookService();
		
		// ����service����ɾ��
		try {
			bookService.delBook(id);
			// �ض�����ת��/list
			resp.sendRedirect("/list");
		} catch(ServiceException e) {
			// �ֶ�����404
			resp.sendError(404, e.getMessage());
		}
	}

}
