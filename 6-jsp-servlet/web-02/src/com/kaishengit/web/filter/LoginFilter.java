package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;

public class LoginFilter extends AbstractFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// ��ȡ����·��
		String uri = req.getRequestURI();
		// ���������·����Դ����ֱ��ͨ��������У���Ƿ��¼
		if("/".equals(uri) || "/login".equals(uri) || "/index.jsp".equals(uri) 
				|| uri.startsWith("/static") ) {
			chain.doFilter(req, resp);
		} else {
			// ���������/add /list����Դ��Ҫ�ж��Ƿ��¼�����session����admin�������Ѿ���¼����ֱ��ͨ��������
			// ������Ϊ��û�е�¼���ض��򵽵�¼ҳ��
			HttpSession session = req.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			if(admin != null) {
				chain.doFilter(req, resp);
			}else {
				resp.sendRedirect("/login?callback=" + uri);
			}
		}
		
		
	}

}
