package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class OrdersData {
	private int productId;
	private double price;
	private int quantity;
	private int orderId;
	private String msg;
	private String staus;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderid() {
		return orderId;
	}
	public void setOrderid(int orderId) {
		this.orderId = orderId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStaus() {
		return staus;
	}
	public void setStaus(String staus) {
		this.staus = staus;
	}
	
	

}
