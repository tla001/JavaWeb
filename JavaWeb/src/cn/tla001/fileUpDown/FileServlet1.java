package cn.tla001.fileUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �����ļ��ϴ�������
 * 
 * @author Jie.Yuan
 * 
 */
public class FileServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ��������� ���ֲ�ͬ�Ĳ�������
		String method = request.getParameter("method");
		if ("upload".equals(method)) {
			// �ϴ�
			upload(request, response);
		}

		else if ("downList".equals(method)) {
			// ���������б�
			downList(request, response);
		}

		else if ("down".equals(method)) {
			// ����
			down(request, response);
		}
	}

	/**
	 * 1. �ϴ�
	 */
	private void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1. ������������
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. �ļ��ϴ����Ĺ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ���ô�С���Ʋ���
			upload.setFileSizeMax(10 * 1024 * 1024); // �����ļ���С����
			upload.setSizeMax(50 * 1024 * 1024); // ���ļ���С����
			upload.setHeaderEncoding("UTF-8"); // �������ļ����봦��

			// �ж�
			if (upload.isMultipartContent(request)) {
				// 3. ����������ת��Ϊlist����
				List<FileItem> list = upload.parseRequest(request);
				// ����
				for (FileItem item : list) {
					// �жϣ���ͨ�ı�����
					if (item.isFormField()) {
						// ��ȡ����
						String name = item.getFieldName();
						// ��ȡֵ
						String value = item.getString();
						System.out.println(value);
					}
					// �ļ�����
					else {
						/******** �ļ��ϴ� ***********/
						// a. ��ȡ�ļ�����
						String name = item.getName();
						// ----�����ϴ��ļ�����������----
						// a1. �ȵõ�Ψһ���
						String id = UUID.randomUUID().toString();
						// a2. ƴ���ļ���
						name = id + "#" + name;

						// b. �õ��ϴ�Ŀ¼
						String basePath = getServletContext().getRealPath(
								"/upload");
						// c. ����Ҫ�ϴ����ļ�����
						File file = new File(basePath, name);
						// d. �ϴ�
						item.write(file);
						item.delete(); // ɾ���������ʱ��������ʱ�ļ�
						downList(request, response);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 2. ���������б�
	 */
	private void downList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ʵ��˼·���Ȼ�ȡuploadĿ¼�������ļ����ļ������ٱ��棻��ת��down.jsp�б�չʾ

		// 1. ��ʼ��map����Map<����Ψһ��ǵ��ļ���, ����ļ���> ;
		Map<String, String> fileNames = new HashMap<String, String>();

		// 2. ��ȡ�ϴ�Ŀ¼�����������е��ļ����ļ���
		String bathPath = getServletContext().getRealPath("/upload");
		// Ŀ¼
		File file = new File(bathPath);
		// Ŀ¼�£������ļ���
		String list[] = file.list();
		// ��������װ
		if (list != null && list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				// ȫ��
				String fileName = list[i];
				// ����
				String shortName = fileName
						.substring(fileName.lastIndexOf("#") + 1);
				// ��װ
				fileNames.put(fileName, shortName);
			}
		}

		// 3. ���浽request��
		request.setAttribute("fileNames", fileNames);
		// 4. ת��
		request.getRequestDispatcher("/downlist.jsp")
				.forward(request, response);

	}

	/**
	 * 3. ��������
	 */
	private void down(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ�û����ص��ļ�����(url��ַ��׷������,get)
		String fileName = request.getParameter("fileName");
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");

		// �Ȼ�ȡ�ϴ�Ŀ¼·��
		String basePath = getServletContext().getRealPath("/upload");
		// ��ȡһ���ļ���
		InputStream in = new FileInputStream(new File(basePath, fileName));

		// ����ļ��������ģ���Ҫ����url����
		fileName = URLEncoder.encode(fileName, "UTF-8");
		// �������ص���Ӧͷ
		response.setHeader("content-disposition", "attachment;fileName="
				+ fileName);

		// ��ȡresponse�ֽ���
		OutputStream out = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);
		}
		// �ر�
		out.close();
		in.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
