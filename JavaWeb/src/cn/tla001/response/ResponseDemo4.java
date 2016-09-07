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
	 * content-type������
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������������͵����ݵ�����
		// response.setContentType("text/xml");
		// response.getWriter().write(
		// "<html><title>this is a title</title></html>");
		// File t = new File("a.txt");
		// System.out.println(t.getPath());
		// System.out.println(t.getAbsolutePath());
		// ����ͼƬ
		// response.setContentType("image/jpg");
		// FileInputStream in = new FileInputStream(new File("e:/1.jpg"));
		// byte[] buf = new byte[1024];
		// int len;
		// while ((len = in.read(buf)) != -1) {
		// response.getOutputStream().write(buf);
		// }
		// ���ط�ʽ��
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
