package cn.tla001.servletTest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到SErvletContext对象
		ServletContext context = this.getServletContext();

		System.out.println("参数" + context.getInitParameter("AAA"));

		Enumeration<String> enums = context.getInitParameterNames();
		while (enums.hasMoreElements()) {
			String paramName = enums.nextElement();
			String paramValue = context.getInitParameter(paramName);
			System.out.println(paramName + "=" + paramValue);
		}

		// 尝试得到ConfigDemo中的servlet参数
		String path = this.getServletConfig().getInitParameter("path");
		System.out.println("path=" + path);
	}

}
