package cn.tla001.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.创建session对象
		HttpSession sn = request.getSession();

		// 2.保存会话数据
		sn.setAttribute("name", "rose");
		System.out.println("id= " + sn.getId());
		// 手动发送一个cookie保存session
		Cookie ck = new Cookie("JSESSIONID", sn.getId());
		response.addCookie(ck);
		// 销毁
		// sn.invalidate();
	}
}
