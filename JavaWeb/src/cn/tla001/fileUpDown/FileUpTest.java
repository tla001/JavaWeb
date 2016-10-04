package cn.tla001.fileUpDown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUpTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream inputStream = request.getInputStream();
		InputStreamReader inReader = new InputStreamReader(inputStream);
		BufferedReader bf = new BufferedReader(inReader);

		String str = null;
		while ((str = bf.readLine()) != null) {
			System.out.println(str);
		}
		bf.close();
		inReader.close();
		inputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
