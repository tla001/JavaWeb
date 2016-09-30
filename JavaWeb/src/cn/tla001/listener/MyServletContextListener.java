package cn.tla001.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ����ServletContext���󴴽�������
 * 
 * @author Jie.Yuan
 * 
 */
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextDestroyed()");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out
				.println("1..........MyServletContextListener.contextInitialized()");
	}

}
