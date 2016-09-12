package cn.tla001.Example_2_Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		PrintWriter writer = response.getWriter();

		String html = "";
		// 1.�õ�session����
		HttpSession session = request.getSession(false);
		if (session == null) {
			// û�е�¼�ɹ�����ת����¼ҳ��
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		// 2.ȡ���Ự����
		String loginName = (String) session.getAttribute("loginName");
		if (loginName == null) {
			// û�е�¼�ɹ�����ת����¼ҳ��
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		html = "<html><body>��ӭ������" + loginName + "��<a href='"
				+ request.getContextPath()
				+ "/LogoutServlet'>��ȫ�˳�</a></body></html>";
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
