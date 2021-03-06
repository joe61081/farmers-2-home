package com.mastek.farmers2home.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

import com.mastek.farmers2home.basket.Basket;
import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.farmer.Farmer;
import com.mastek.farmers2home.order.OrderItem;

@Entity
@Table(name="Products")
public class Product {
	int productId;

	@FormParam(value = "productName")
	String productName;

	@FormParam(value = "productDesc")
	String productDesc;

	@FormParam(value = "productCat")
	ProductCat productCat;

	@FormParam(value = "productPrice")
	double productPrice;

	@FormParam(value = "stockQuantity")
	int stockQuantity;

	Set<Basket> basketProducts = new HashSet<>();

	@ManyToMany(mappedBy = "productsAssignedToBasket")
	@XmlTransient
	public Set<Basket> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(Set<Basket> basketProducts) {
		this.basketProducts = basketProducts;
	}

	Set<Customer> customerProducts = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_products", joinColumns = { @JoinColumn(name = "fk_customerId") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_productId") })

	@Transient
	@XmlTransient
	public Set<Customer> getCustomerProducts() {
		return customerProducts;
	}

	public void setCustomerProducts(Set<Customer> customerProducts) {
		this.customerProducts = customerProducts;
	}

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Enumerated(EnumType.STRING)
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