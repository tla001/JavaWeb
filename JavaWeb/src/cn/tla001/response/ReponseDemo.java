package cn.tla001.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReponseDemo extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	/**
	 * 1、tomcat服务器把请求信息封装到HttpServletRequest对象，且把相应信息封装到HttpServletResponse
	 * 2、tomcat服务器调用doGet方法，传入Request和reponse对象
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通过reponse对象改变响应信息
		// 1响应行
		// response.setStatus(404);

		// 2响应头
		response.setHeader("Server", "tla001");

		// 3实体内容，浏览器可以直接看到的信息
		response.getWriter().write("hello world");// 字符
		// response.getOutputStream().write("nihao".getBytes());// 字节

	}

}
