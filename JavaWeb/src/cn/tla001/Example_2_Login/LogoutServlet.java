package cn.tla001.Example_2_Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		/**
		 * ������ȫ�˳��� ɾ����session������ָ����loginName���Լ��ɣ�
		 */
		// 1.�õ�session����
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 2.ɾ������
			session.removeAttribute("loginName");
		}

		// 2.������¼ҳ��
		response.sendRedirect(request.getContextPath() + "/login.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
