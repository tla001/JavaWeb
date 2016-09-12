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
		// 1.得到session对象
		HttpSession session = request.getSession(false);
		if (session == null) {
			// 没有登录成功，跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		// 2.取出会话数据
		String loginName = (String) session.getAttribute("loginName");
		if (loginName == null) {
			// 没有登录成功，跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		html = "<html><body>欢迎回来，" + loginName + "，<a href='"
				+ request.getContextPath()
				+ "/LogoutServlet'>安全退出</a></body></html>";
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
