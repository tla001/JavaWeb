package cn.tla001.Example_2_Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");

		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");

		if ("rose".equals(name) && "123456".equals(pwd)) {
			/**
			 * һ����¼�ɹ��󣬰��û����ݱ���session������
			 */
			// 1.����session����
			HttpSession session = request.getSession();
			// 2.�����ݱ��浽session����
			session.setAttribute("loginName", name);
			// 3.��ת���û���ҳ
			response.sendRedirect(request.getContextPath() + "/IndexServlet");
		} else {
			response.sendRedirect(request.getContextPath() + "/fail.html");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
