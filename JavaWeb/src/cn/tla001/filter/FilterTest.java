package cn.tla001.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("6. 销毁过滤器实例");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("3. 执行过滤器业务处理方法");
		// 放行 (去到Servlet)
		// 如果有下一个过滤器，进入下一个过滤器，否则就执行访问servlet
		chain.doFilter(request, response);

		System.out.println("5. Servlet处理完成，又回到过滤器");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// 获取过滤器在web.xml中配置的初始化参数
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);

		// 获取过滤器在web.xml中配置的初始化参数 的名称
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while (enums.hasMoreElements()) {
			// 获取所有参数名称：encoding、path
			String name = enums.nextElement();
			// 获取名称对应的值
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + "\t" + value);
		}
	}

}
