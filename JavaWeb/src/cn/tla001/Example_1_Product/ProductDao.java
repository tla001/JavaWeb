package cn.tla001.Example_1_Product;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator 该类中存放Product增删改方法
 * 
 */
public class ProductDao {
	// 模拟数据库
	private static List<Product> data = new ArrayList<Product>();
	/*
	 * 初始化商品，静态代码块只执行一次
	 */
	static {
		for (int i = 1; i <= 10; i++) {
			data.add(new Product("" + i, "笔记本" + i, "LN00" + i, 34.0 + i));
		}
	}

	/**
	 * 提供查询所有商品的方法
	 */
	public List<Product> findAll() {
		return data;
	}

	/**
	 * 提供根据编号查询商品的方法
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
