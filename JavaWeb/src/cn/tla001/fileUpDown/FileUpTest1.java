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
 * 文件上传组件的使用
 */
public class FileUpTest1 extends HttpServlet {

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.创建文件上传工厂类
		FileItemFactory fac = new DiskFileItemFactory();
		// 2创建文件上传核心类对象
		ServletFileUpload upload = new ServletFileUpload(fac);
		// 一、设置单个文件允许的最大的大小： 30M
		upload.setFileSizeMax(30 * 1024 * 1024);
		// 二、设置文件上传表单允许的总大小: 80M
		upload.setSizeMax(80 * 1024 * 1024);
		// 三、 设置上传表单文件名的编码
		// 相当于：request.setCharacterEncoding("UTF-8");
		upload.setHeaderEncoding("UTF-8");

		// 判断，当前表单是否为文件上传表单
		if (upload.isMultipartContent(request)) {
			// 3.把请求数据转换为FileItem对象的集合
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> list = upload.parseRequest(request);
				// 遍历，得到每一个上传项
				for (FileItem item : list) {
					// 判断是普通表单哈市文件上传表单
					if (item.isFormField()) {
						// 普通表单
						String fieldName = item.getFieldName();// 文本框名称
						String string = item.getString(); // 文本框值
						System.out.println(fieldName + "\t" + string);
					}
					// 上传文件(文件流) ----> 上传到upload目录下
					else {
						// 文件上传表单
						String fieldName = item.getFieldName();// 文本框名称
						String contentType = item.getContentType();// 文件类型
						String content = item.getString(); // 表单元素名称， 对应的数据
						String name = item.getName();// 文件名
						InputStream inputStream = item.getInputStream();// 文件流
						System.out.println(inputStream);
						/*
						 * 四、文件名重名 对于不同用户readme.txt文件，不希望覆盖！ 后台处理： 给用户添加一个唯一标记!
						 */
						// a. 随机生成一个唯一标记
						String id = UUID.randomUUID().toString();
						// b. 与文件名拼接
						name = id + "#" + name;

						// 获取上传基路径
						String path = getServletContext()
								.getRealPath("/upload");
						// 创建目标文件
						File file = new File(path, name);

						// 工具类，文件上传
						item.write(file);
						item.delete(); // 删除系统产生的临时文件

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
			System.out.println("当前表单不是文件上传表单，不处理");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
