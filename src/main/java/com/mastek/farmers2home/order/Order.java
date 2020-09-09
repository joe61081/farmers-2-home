package com.mastek.farmers2home.order;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.product.Product;

@Entity
@Table(name="ProductOrderJoin")
public class Order {
	
	OrderItem orderItemAssigned;
	
	Product productAssigned;
	
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
	public Product getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Product productAssigned) {
		this.productAssigned = productAssigned;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

}
