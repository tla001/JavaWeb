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
	 * 1��tomcat��������������Ϣ��װ��HttpServletRequest�����Ұ���Ӧ��Ϣ��װ��HttpServletResponse
	 * 2��tomcat����������doGet����������Request��reponse����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ͨ��reponse����ı���Ӧ��Ϣ
		// 1��Ӧ��
		// response.setStatus(404);

		// 2��Ӧͷ
		response.setHeader("Server", "tla001");

		// 3ʵ�����ݣ����������ֱ�ӿ�������Ϣ
		response.getWriter().write("hello world");// �ַ�
		// response.getOutputStream().write("nihao".getBytes());// �ֽ�

	}

}
