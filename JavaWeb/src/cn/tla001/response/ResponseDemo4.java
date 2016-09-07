package cn.tla001.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo4 extends HttpServlet {

	/**
	 * content-type的作用
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 服务器给浏览器发送的数据的类型
		// response.setContentType("text/xml");
		// response.getWriter().write(
		// "<html><title>this is a title</title></html>");
		// File t = new File("a.txt");
		// System.out.println(t.getPath());
		// System.out.println(t.getAbsolutePath());
		// 发送图片
		// response.setContentType("image/jpg");
		// FileInputStream in = new FileInputStream(new File("e:/1.jpg"));
		// byte[] buf = new byte[1024];
		// int len;
		// while ((len = in.read(buf)) != -1) {
		// response.getOutputStream().write(buf);
		// }
		// 下载方式打开
		File file = new File("e:/1.jpg");
		response.setHeader("content-Disposition",
				"attachment;filenam=" + file.getName());
		byte[] buf = new byte[1024];
		int len;
		FileInputStream in = new FileInputStream(file);
		while ((len = in.read(buf)) != -1) {
			response.getOutputStream().write(buf);
		}
	}
}
