package ch01;

public class Product {
	
	private String prdtNm;
	private int prdtCost;
	
	public Product(String prdtNm, int prdtCost) {
		this.prdtNm = prdtNm;
		this.prdtCost = prdtCost;
	}
	
	
	public String getPrdtNm() {
		return prdtNm;
	}
	
	public void setPrdtNm(String prdtNm) {
		this.prdtNm = prdtNm;
	}
	
	public int getPrdtCost() {
		return prdtCost;
	}
	public void setPrdtCost(int prdtCost) {
		this.prdtCost = prdtCost;
	}
}
