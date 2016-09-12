package cn.tla001.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			Cookie ck1 = null;
			Cookie ck2 = null;
			for (Cookie c : cks) {
				String name = c.getName();
				String value = c.getValue();
				if (name.equals("lasttime")) {
					ck1 = c;
				}
				if (name.equals("num")) {
					ck2 = c;
				}
				if (ck1 != null && ck2 != null) {
					System.out.println("This is your " + ck2.getValue()
							+ " times to log, the last time is "
							+ ck1.getValue() + " .Welcome !");
					// response.getWriter().flush();
					response.getWriter().write(
							"This is your " + ck2.getValue()
									+ " times to log, the last time is "
									+ ck1.getValue() + " .Welcome !");
					int nu = Integer.parseInt(ck2.getValue());
					// System.out.println(nu);
					nu++;
					ck2.setValue(Integer.toString(nu));
					ck1.setValue(new Date().toString());
					response.addCookie(ck1);
					response.addCookie(ck2);
					break;
				}
				if (ck1 == null && ck2 == null) {
					System.out
							.println("This is the first time you log,welcome !");
					// response.getWriter().flush();
					response.getWriter().write(
							"This is the first time you log,welcome !");
					Cookie ck3 = new Cookie("lasttime", new Date().toString());
					Cookie ck4 = new Cookie("num", "2");
					response.addCookie(ck3);
					response.addCookie(ck4);
				}
			}
		} else {
			System.out.println("This is the first time you log,welcome !");
			Cookie ck1 = new Cookie("lasttime", new Date().toString());
			Cookie ck2 = new Cookie("num", "1");
			response.addCookie(ck1);
			response.addCookie(ck2);
		}
	}

}
