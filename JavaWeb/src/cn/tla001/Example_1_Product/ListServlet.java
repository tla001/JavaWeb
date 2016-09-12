package cn.tla001.Example_1_Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 ��ȡ���ݿ⣬��ѯ��Ʒ�б�
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAll();

		// 2.����Ʒ��ʾ�������
		response.setCharacterEncoding("gbk");
		PrintWriter writer = response.getWriter();
		String html = "";

		html += "<html>";
		html += "<head>";
		html += "<title>��ʾ��Ʒ�б�</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='600px'>";
		html += "<tr>";
		html += "<th>���</th><th>��Ʒ����</th><th>��Ʒ�ͺ�</th><th>��Ʒ�۸�</th>";
		html += "</tr>";
		// ������Ʒ
		if (list != null) {
			for (Product p : list) {
				html += "<tr>";
				// /day11_hist/DetailServlet?id=1 ����DetailSErvlet��servlet����ͬʱ����
				// ��Ϊid��ֵΪ1 �Ĳ���
				html += "<td>" + p.getProId() + "</td><td><a href='"
						+ request.getContextPath() + "/detailservlet?id="
						+ p.getProId() + "'>" + p.getProName()
						+ "</a></td><td>" + p.getProType() + "</td><td>"
						+ p.getProPrice() + "</td>";
				html += "<tr>";
			}
		}
		html += "</table>";

		/**
		 * ��ʾ���������Ʒ
		 */
		html += "������������Ʒ��<br/>";
		// ȡ��prodHist��cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("prodHist")) {
					String prodHist = cookie.getValue(); // 3,2,1
					String[] ids = prodHist.split(",");
					// �������������Ʒid
					for (String id : ids) {
						// ��ѯ���ݿ⣬��ѯ��Ӧ����Ʒ
						Product p = dao.findById(id);
						// ��ʾ�������
						html += "" + p.getProId() + "&nbsp;" + p.getProName()
								+ "&nbsp;" + p.getProPrice() + "<br/>";
					}
				}
			}
		}

		html += "</body>";
		html += "</html>";

		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
