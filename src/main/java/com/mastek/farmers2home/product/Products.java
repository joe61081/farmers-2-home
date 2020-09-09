package com.mastek.farmers2home.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.order.Orders;

@Table(name="Products")
public class Products {
	int productId;
	String productName;
	String productDesc;
	ProductCat productCat;
	double productPrice;
	int stockQuantity;
	
	Set <Orders> orderItemAssigned = new HashSet<>();
	
	@OneToMany(mappedBy = "orderAssigned", cascade = CascadeType.ALL)
	@XmlTransient
	public Set<Orders> getOrderItemAssigned() {
		return orderItemAssigned;
	}
	public void setOrderItemAssigned(Set<Orders> orderItemAssigned) {
		this.orderItemAssigned = orderItemAssigned;
	}
	@Id
	@Column(name="productId")
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public ProductCat getProductCat() {
		return productCat;
	}
	public void setProductCat(ProductCat productCat) {
		this.productCat = productCat;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		Products other = (Products) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productCat=" + productCat + ", productPrice=" + productPrice + ", stockQuantity=" + stockQuantity
				+ "]";
	}
	
}
