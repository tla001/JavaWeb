package cn.tla001.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet {

	/**
	 * 定时刷新 浏览器认识refresh头，得到refresh之后重新请求资源
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setHeader("refresh", "1");

		// 隔多少秒之后，自动跳转
		response.setHeader("refresh", "3;url=testImg.html");
	}

}
