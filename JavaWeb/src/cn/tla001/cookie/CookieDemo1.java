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
		// 1����Cookie����
		Cookie ck = new Cookie("name", "tao");
		Cookie ck1 = new Cookie("emile", "tla001@qq.com");

		// ��������cookie�ı���·����Ĭ����webӦ��Ŀ¼
		ck1.setPath("/tla001");

		// ������Чʱ��
		// ������ʾ������Ӳ�̣���Чʱ��s�������������ڴ棬������ر�ʧЧ(�Ựcookie)��0��ʾɾ��
		ck.setMaxAge(0);
		ck1.setMaxAge(4);

		// 2��cookie���ݷ��͵��������ͨ����Ӧͷ���ͣ�set-cookie��
		// response.setHeader("set-cookie",
		// ck.getName()+"="+ck.getValue());//�ֶ���ʽ
		response.addCookie(ck);// �Զ���ʽ
		response.addCookie(ck1);

		// 3������������͵�cookie��Ϣ
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
