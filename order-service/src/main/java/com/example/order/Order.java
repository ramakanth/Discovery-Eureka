package com.example.order;

public class Order {
	private long orderId;
	private long customerId;
	private String orderStatus;
	private double orderTotal;

	public Order(long orderId, long customerId, String orderStatus, double orderTotal) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

}
