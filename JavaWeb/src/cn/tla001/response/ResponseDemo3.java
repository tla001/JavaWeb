package cn.tla001.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet {

	/**
	 * ��ʱˢ�� �������ʶrefreshͷ���õ�refresh֮������������Դ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setHeader("refresh", "1");

		// ��������֮���Զ���ת
		response.setHeader("refresh", "3;url=testImg.html");
	}

}
