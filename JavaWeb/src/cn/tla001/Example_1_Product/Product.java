package cn.tla001.Example_1_Product;

public class Product {
	private String proId;
	private String proName;
	private String proType;
	private double proPrice;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String proId, String proName, String proType, double proPrice) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proType = proType;
		this.proPrice = proPrice;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public double getProPrice() {
		return proPrice;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName
				+ ", proType=" + proType + ", proPrice=" + proPrice + "]";
	}
}
