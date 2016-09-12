package cn.tla001.Example_1_Product;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator �����д��Product��ɾ�ķ���
 * 
 */
public class ProductDao {
	// ģ�����ݿ�
	private static List<Product> data = new ArrayList<Product>();
	/*
	 * ��ʼ����Ʒ����̬�����ִֻ��һ��
	 */
	static {
		for (int i = 1; i <= 10; i++) {
			data.add(new Product("" + i, "�ʼǱ�" + i, "LN00" + i, 34.0 + i));
		}
	}

	/**
	 * �ṩ��ѯ������Ʒ�ķ���
	 */
	public List<Product> findAll() {
		return data;
	}

	/**
	 * �ṩ���ݱ�Ų�ѯ��Ʒ�ķ���
	 */
	public Product findById(String id) {
		for (Product p : data) {
			if (p.getProId().equals(id)) {
				return p;
			}
		}
		return null;
	}

}
