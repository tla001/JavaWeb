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
			 * 一、登录成功后，把用户数据保存session对象中
			 */
			// 1.创建session对象
			HttpSession session = request.getSession();
			// 2.把数据保存到session域中
			session.setAttribute("loginName", name);
			// 3.跳转到用户主页
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
