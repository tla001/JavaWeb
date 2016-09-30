package cn.tla001.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ����request����Ĵ���������
 * 
 * @author Jie.Yuan
 * 
 */
public class MyRequestListener implements ServletRequestListener {

	// ��������
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// ��ȡrequest�д�ŵ�����
		Object obj = sre.getServletRequest().getAttribute("cn");
		System.out.println(obj);
		System.out.println("MyRequestListener.requestDestroyed()");
	}

	// ���󴴽�
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyRequestListener.requestInitialized()");
	}
}
