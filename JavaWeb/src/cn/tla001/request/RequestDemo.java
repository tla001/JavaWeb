package cn.tla001.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo extends HttpServlet {

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
	 * 1.tomcat服务器接收到浏览器发送的请求数据，然后封装到HttpServletRequest对象
	 * 2.tomcat服务器调用doGet方法，然后把request对象传入到servlet中
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 设置编码表 此方法只能对请求实体内容的数据编码起作用，POST提交的数据在实体内容中，所以该方法对POST方法有效
		 * GET方法参数放在URI后面，对GET无效（只能手动解码）
		 */
		request.setCharacterEncoding("utf-8");
		System.out.println("request method: " + request.getMethod());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("http protocol version: " + request.getProtocol());
		String value = request.getQueryString();
		System.out.println(value);

		// 统一方便获取请求参数的方法
		String name = request.getParameter("name");
		// name = new String(name.getBytes("iso-8859-1"), "utf-8");// 方法一编码转换
		String passwd = request.getParameter("password");
		System.out.println(name + ":" + passwd);

		Enumeration<String> pnames = request.getParameterNames();
		while (pnames.hasMoreElements()) {
			String pname = pnames.nextElement();
			String pvalue = request.getParameter(pname);
			// getParameterValue可以获取同一标签多个值
			System.out.println(pname + ":" + pvalue);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 3.从request对象中取出请求数据
		 */
		System.out.println("request method: " + request.getMethod());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("http protocol version: " + request.getProtocol());

		// 请求头
		Enumeration<String> enums = request.getHeaderNames();
		while (enums.hasMoreElements()) {
			String headerName = enums.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ":" + headerValue);
		}

		// 请求实体内容
		InputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			String str = new String(buf, 0, len);
			System.out.println(str);
		}
	}
}
