package cn.tla001.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����Session���󴴽�������
 * 
 * @author Jie.Yuan
 * 
 */
public class MySessionListener implements HttpSessionListener {

	// ����
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("MySessionListener.sessionCreated()");
	}

	// ����
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MySessionListener.sessionDestroyed()");
	}

}
