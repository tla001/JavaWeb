package cn.tla001.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {
	/**
	 * 请求重定向
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 跳转 使用请求重定向，302的状态码+location的响应头
		 */
		// response.setStatus(302);
		// response.setHeader("location", "testImg.html");
		// 简化写法
		response.sendRedirect("testImg.html");
	}
}
