package com.mastek.farmers2home.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	int OrderId;
	double OrderPrice;
	orderStatus OrderStatus;
	Date OrderDate;
	boolean subscription;
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	public orderStatus getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(orderStatus orderStatus) {
		OrderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public boolean isSubscription() {
		return subscription;
	}
	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", OrderPrice=" + OrderPrice + ", OrderStatus=" + OrderStatus
				+ ", OrderDate=" + OrderDate + ", subscription=" + subscription + "]";
	}
	
	
	

}
