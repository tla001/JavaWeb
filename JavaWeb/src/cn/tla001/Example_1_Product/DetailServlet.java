package cn.tla001.Example_1_Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.��ȡ���
		String id = request.getParameter("id");

		// 2.�����ݿ��в�ѯ��Ӧ��ŵ���Ʒ
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);

		// 3.��ʾ�������
		PrintWriter writer = response.getWriter();
		String html = "";

		html += "<html>";
		html += "<head>";
		html += "<title>��ʾ��Ʒ��ϸ</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='300px'>";
		if (product != null) {
			html += "<tr><th>���:</th><td>" + product.getProId() + "</td></tr>";
			html += "<tr><th>��Ʒ����:</th><td>" + product.getProName()
					+ "</td></tr>";
			html += "<tr><th>��Ʒ�ͺ�:</th><td>" + product.getProType()
					+ "</td></tr>";
			html += "<tr><th>��Ʒ�۸�:</th><td>" + product.getProPrice()
					+ "</td></tr>";
		}

		html += "</table>";
		html += "<center><a href='" + request.getContextPath()
				+ "/listservlet'>[�����б�]</a></center>";
		html += "</body>";
		html += "</html>";

		writer.write(html);

		/**
		 * ����cookie��������
		 */
		// 1.����cookie
		Cookie cookie = new Cookie("prodHist", createValue(request, id));
		cookie.setMaxAge(1 * 30 * 24 * 60 * 60);// һ����
		// 2.����cookie
		response.addCookie(cookie);
	}

	private String createValue(HttpServletRequest request, String id) {

		Cookie[] cookies = request.getCookies();
		String prodHist = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("prodHist")) {
					prodHist = cookie.getValue();
					break;
				}
			}
		}

		// null��û��prodHist
		if (cookies == null || prodHist == null) {
			// ֱ�ӷ��ش����id
			return id;
		}

		// 3,21 2
		// String -> String[] -> Collection :Ϊ�˷����ж��ظ�id
		String[] ids = prodHist.split(",");
		Collection colls = Arrays.asList(ids); // <3,21>
		// LinkedList ����ز�������ɾ��Ԫ�أ�����
		// Collection -> LinkedList
		LinkedList list = new LinkedList(colls);

		// ������3��
		if (list.size() < 3) {
			// id�ظ�
			if (list.contains(id)) {
				// ȥ���ظ�id���Ѵ����id����ǰ��
				list.remove(id);
				list.addFirst(id);
			} else {
				// ֱ�ӰѴ����id����ǰ��
				list.addFirst(id);
			}
		} else {
			// ����3��
			// id�ظ�
			if (list.contains(id)) {
				// ȥ���ظ�id���Ѵ����id����ǰ��
				list.remove(id);
				list.addFirst(id);
			} else {
				// ȥ����id���Ѵ����id����ǰ��
				list.removeLast();
				list.addFirst(id);
			}
		}

		// LinedList -> String
		StringBuffer sb = new StringBuffer();
		for (Object object : list) {
			sb.append(object + ",");
		}
		// ȥ�����Ķ���
		String result = sb.toString();
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
