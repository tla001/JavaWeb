package cn.tla001.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {
	/**
	 * �����ض���
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ��ת ʹ�������ض���302��״̬��+location����Ӧͷ
		 */
		// response.setStatus(302);
		// response.setHeader("location", "testImg.html");
		// ��д��
		response.sendRedirect("testImg.html");
	}
}
