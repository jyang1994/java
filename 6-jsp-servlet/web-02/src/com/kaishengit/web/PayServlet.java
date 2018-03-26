package com.kaishengit.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ȫ��Ψһ��tokenֵ
		String token = UUID.randomUUID().toString();
		
		// ���͵�jsp����
		req.setAttribute("token", token);
		
		// session�д洢
		HttpSession session = req.getSession();
		session.setAttribute("token", token);
				
		req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String money = req.getParameter("money");
		String token = req.getParameter("token");
		
		HttpSession session = req.getSession();
		String sessionToken = (String)session.getAttribute("token");
		if(sessionToken != null && sessionToken.equals(token)) {
			System.out.println("֧����" + money + "Ԫ");
			// ɾ��session�е�tokenֵ
			session.removeAttribute("token");
			req.getRequestDispatcher("/WEB-INF/views/paySuccess.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/payError.jsp").forward(req, resp);
		}	
		
		
	}
	
	
	
}
