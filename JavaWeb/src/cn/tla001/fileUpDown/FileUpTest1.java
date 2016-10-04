package cn.tla001.fileUpDown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
 * �ļ��ϴ������ʹ��
 */
public class FileUpTest1 extends HttpServlet {

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.�����ļ��ϴ�������
		FileItemFactory fac = new DiskFileItemFactory();
		// 2�����ļ��ϴ����������
		ServletFileUpload upload = new ServletFileUpload(fac);
		// һ�����õ����ļ���������Ĵ�С�� 30M
		upload.setFileSizeMax(30 * 1024 * 1024);
		// ���������ļ��ϴ���������ܴ�С: 80M
		upload.setSizeMax(80 * 1024 * 1024);
		// ���� �����ϴ����ļ����ı���
		// �൱�ڣ�request.setCharacterEncoding("UTF-8");
		upload.setHeaderEncoding("UTF-8");

		// �жϣ���ǰ���Ƿ�Ϊ�ļ��ϴ���
		if (upload.isMultipartContent(request)) {
			// 3.����������ת��ΪFileItem����ļ���
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> list = upload.parseRequest(request);
				// �������õ�ÿһ���ϴ���
				for (FileItem item : list) {
					// �ж�����ͨ�������ļ��ϴ���
					if (item.isFormField()) {
						// ��ͨ��
						String fieldName = item.getFieldName();// �ı�������
						String string = item.getString(); // �ı���ֵ
						System.out.println(fieldName + "\t" + string);
					}
					// �ϴ��ļ�(�ļ���) ----> �ϴ���uploadĿ¼��
					else {
						// �ļ��ϴ���
						String fieldName = item.getFieldName();// �ı�������
						String contentType = item.getContentType();// �ļ�����
						String content = item.getString(); // ��Ԫ�����ƣ� ��Ӧ������
						String name = item.getName();// �ļ���
						InputStream inputStream = item.getInputStream();// �ļ���
						System.out.println(inputStream);
						/*
						 * �ġ��ļ������� ���ڲ�ͬ�û�readme.txt�ļ�����ϣ�����ǣ� ��̨���� ���û����һ��Ψһ���!
						 */
						// a. �������һ��Ψһ���
						String id = UUID.randomUUID().toString();
						// b. ���ļ���ƴ��
						name = id + "#" + name;

						// ��ȡ�ϴ���·��
						String path = getServletContext()
								.getRealPath("/upload");
						// ����Ŀ���ļ�
						File file = new File(path, name);

						// �����࣬�ļ��ϴ�
						item.write(file);
						item.delete(); // ɾ��ϵͳ��������ʱ�ļ�

						System.out.println();

					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("��ǰ�������ļ��ϴ�����������");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
