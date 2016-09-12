package cn.tla001.servletTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathDemo extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new File(".").getAbsolutePath());
		// getRealPath获取资源文件的绝对路径
		String path = this.getServletContext().getRealPath("/testImg.html");
		File file = new File(path);
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			response.getOutputStream().write(buf);
		}
		/**
		 * 2. getResourceAsStream() 得到资源文件，返回的是输入流
		 * 
		 * InputStream in = this.getServletContext().getResourceAsStream(
		 * "/WEB-INF/classes/db.properties");
		 * 
		 * 
		 * Properties prop = new Properties(); //读取资源文件 prop.load(in);
		 * 
		 * String user = prop.getProperty("user"); String password =
		 * prop.getProperty("password"); System.out.println("user="+user);
		 * System.out.println("password="+password);
		 */
	}
}
