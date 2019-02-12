package com.leopard.mvc;

import java.util.List;

public class OrderCommand {
	private List<OrderItem> orderItems;
	private Address address;
	
	@Override
	public String toString() {
		return "OrderCommand [address=" + address + "]";
	}
	
	// getters & setters
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}