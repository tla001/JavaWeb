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
	 * 1.tomcat���������յ���������͵��������ݣ�Ȼ���װ��HttpServletRequest����
	 * 2.tomcat����������doGet������Ȼ���request�����뵽servlet��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ���ñ���� �˷���ֻ�ܶ�����ʵ�����ݵ����ݱ��������ã�POST�ύ��������ʵ�������У����Ը÷�����POST������Ч
		 * GET������������URI���棬��GET��Ч��ֻ���ֶ����룩
		 */
		request.setCharacterEncoding("utf-8");
		System.out.println("request method: " + request.getMethod());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("http protocol version: " + request.getProtocol());
		String value = request.getQueryString();
		System.out.println(value);

		// ͳһ�����ȡ��������ķ���
		String name = request.getParameter("name");
		// name = new String(name.getBytes("iso-8859-1"), "utf-8");// ����һ����ת��
		String passwd = request.getParameter("password");
		System.out.println(name + ":" + passwd);

		Enumeration<String> pnames = request.getParameterNames();
		while (pnames.hasMoreElements()) {
			String pname = pnames.nextElement();
			String pvalue = request.getParameter(pname);
			// getParameterValue���Ի�ȡͬһ��ǩ���ֵ
			System.out.println(pname + ":" + pvalue);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 3.��request������ȡ����������
		 */
		System.out.println("request method: " + request.getMethod());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("http protocol version: " + request.getProtocol());

		// ����ͷ
		Enumeration<String> enums = request.getHeaderNames();
		while (enums.hasMoreElements()) {
			String headerName = enums.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ":" + headerValue);
		}

		// ����ʵ������
		InputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			String str = new String(buf, 0, len);
			System.out.println(str);
		}
	}
}
