package com.mastek.farmers2home.order;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.product.Products;

public class Orders {
	
	OrderItem orderItemAssigned;
	
	Products productAssigned;
	
	int quantityOrdered;

	@ManyToOne
	@Column(name = "fk_orderId", unique = true)
	@Transient
	@XmlTransient
	public OrderItem getOrderItemAssigned() {
		return orderItemAssigned;
	}

	public void setOrderItemAssigned(OrderItem orderItemAssigned) {
		this.orderItemAssigned = orderItemAssigned;
	}

	@ManyToOne
	@Column(name = "fk_productId", unique = true)
	@Transient
	@XmlTransient
	public Products getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Products productAssigned) {
		this.productAssigned = productAssigned;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

}
