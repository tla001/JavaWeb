package cn.tla001.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1创建Cookie对象
		Cookie ck = new Cookie("name", "tao");
		Cookie ck1 = new Cookie("emile", "tla001@qq.com");

		// 可以设置cookie的保存路径，默认是web应用目录
		ck1.setPath("/tla001");

		// 设置有效时间
		// 正数表示保存至硬盘，有效时间s；负数保存在内存，浏览器关闭失效(会话cookie)；0表示删除
		ck.setMaxAge(0);
		ck1.setMaxAge(4);

		// 2把cookie数据发送到浏览器（通过响应头发送：set-cookie）
		// response.setHeader("set-cookie",
		// ck.getName()+"="+ck.getValue());//手动方式
		response.addCookie(ck);// 自动方式
		response.addCookie(ck1);

		// 3接受浏览器发送的cookie信息
		// String name = request.getHeader("cookie");
		// System.out.println(name);
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (Cookie c : cks) {
				String name = c.getName();
				String value = c.getValue();
				System.out.println(name + "=" + value);
			}
		}
	}

}
