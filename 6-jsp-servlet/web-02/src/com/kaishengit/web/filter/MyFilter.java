package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter extends AbstractFilter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("hello filter,before...");
		// FilterChain�ӿ��е�doFilter()�������������󾭹���������������������˺���Ӧ���˵ķָ�
		chain.doFilter(request, response);
		System.out.println("hello filter,after...");
	}

}
