package org.dnyanyog.dto;

public class OrderRequest {
	private int productId;
	private double pice;
	private int quantity;
	private int orderId;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPice() {
		return pice;
	}
	public void setPice(double pice) {
		this.pice = pice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

}


