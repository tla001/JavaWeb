package cn.tla001.servletTest;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.�õ�ServletContext����
		// ServletContext context = this.getServletConfig().getServletContext();
		ServletContext context = this.getServletContext();
		// 2.�õ�webӦ��·�� ����tomcat�����������е�webӦ������
		String contextPath = context.getContextPath();
		System.out.println(contextPath);
	}

}
