package com.mastek.farmers2home.basket;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

import com.mastek.farmers2home.product.Product;

@XmlRootElement
@Entity // declares the class as entity, to be managed by JPA
@Table(name = "basket")
public class Basket {

	//

	@FormParam("basketId")
	int basketId;

	@FormParam("basketAmount")
	int basketAmount;

	Set<Product> productAssigned = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL) // configure many to many association for entities
	@JoinTable(name = "Basket_Products", // provide the join table name
			joinColumns = { @JoinColumn(name = "fk_basketID") }, inverseJoinColumns = {
					@JoinColumn(name = "fk_productId") } // foreign key column for collection type
	)
	@Transient // ignore this property when storing employee data in MongoDB
	@XmlTransient // ignore the association property when shared via Service

	public int getBasketId() {
		return basketId;
	}

	public void setBasketID(int basketId) {
		this.basketId = basketId;
	}

	public int getBasketAmount() {
		return basketAmount;
	}

	public void setBasketAmount(int basketAmount) {
		this.basketAmount = basketAmount;
	}

	public Set<Product> getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Set<Product> productAssigned) {
		this.productAssigned = productAssigned;
	}

	@Override
	public String toString() {
		return "Basket [basketId=" + basketId + ", basketAmount=" + basketAmount + ", productAssigned="
				+ productAssigned + "]";
	}
}