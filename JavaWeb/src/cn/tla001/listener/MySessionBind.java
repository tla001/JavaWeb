package cn.tla001.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBind implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�����Ѿ�����session");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�����Ѿ��Ƴ�session");
	}

}
