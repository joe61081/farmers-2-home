package com.mastek.farmers2home.order;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.customer.Customer;

@Entity
@Table(name="customer_orders")
public class Order {
	
	int orderId;
	
	double orderPrice;
	
	orderStatus orderStatus;
	
	Date orderDate;
	
	boolean isSubscription;
	
	Set <OrderItem> orderItemAssigned = new HashSet<>();
	
	Customer customerAssigned;
	
	@ManyToOne
	@JoinColumn(name="fk_customerId")
	@XmlTransient
	public Customer getCustomerAssigned() {
		return customerAssigned;
	}
	public void setCustomerAssigned(Customer customerAssigned) {
		this.customerAssigned = customerAssigned;
	}	
	
	@OneToMany(mappedBy = "assignedOrder", cascade = CascadeType.ALL)
	@XmlTransient
	public Set<OrderItem> getOrderItemAssigned() {
		return orderItemAssigned;
	}
	public void setOrderItemAssigned(Set<OrderItem> orderItemAssigned) {
		this.orderItemAssigned = orderItemAssigned;
	}

	@Id
	@Column(name = "orderId")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public orderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(orderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isSubscription() {
		return isSubscription;
	}

	public void setSubscription(boolean isSubscription) {
		this.isSubscription = isSubscription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderPrice=" + orderPrice + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", isSubscription=" + isSubscription + "]";
	}
	
}