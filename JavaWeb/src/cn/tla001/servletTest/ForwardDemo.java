package cn.tla001.servletTest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ת��
		// ����ת����ǰwebӦ��֮�����Դ
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				this.getServletContext().getContextPath() + "/context1");
		rd.forward(request, response);
	}

}
