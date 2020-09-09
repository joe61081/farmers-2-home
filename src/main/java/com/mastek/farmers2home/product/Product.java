package com.mastek.farmers2home.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.farmer.Farmer;
import com.mastek.farmers2home.order.OrderItem;

@Entity
@Table(name="Products")
public class Product {
	int productId;
	String productName;
	String productDesc;
	ProductCat productCat;
	double productPrice;
	int stockQuantity;
	
	Set <OrderItem> orderItemAssigned = new HashSet<>();
	Set <Farmer> farmerAssigned = new HashSet<>();
	
	@ManyToMany(mappedBy="productAssigned")
	@XmlTransient
	public Set<Farmer> getFarmerAssigned() {
		return farmerAssigned;
	}
	public void setFarmerAssigned(Set<Farmer> farmerAssigned) {
		this.farmerAssigned = farmerAssigned;
	}
	@OneToMany(mappedBy = "assignedProduct", cascade = CascadeType.ALL)
	@XmlTransient
	public Set<OrderItem> getOrderItemAssigned() {
		return orderItemAssigned;
	}
	public void setOrderItemAssigned(Set<OrderItem> orderItemAssigned) {
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
		Product other = (Product) obj;
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