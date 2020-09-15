package com.mastek.farmers2home.farmer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.product.Product;

@Entity
@Table(name="farmer")
public class Farmer {

	int farmerId;
	String farmerFirstName;
	String farmerLastName;
	String location;
	long contactNumber;
	
	Set<Product> productAssigned = new HashSet<>();

	public Farmer() {
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Farmer_To_Product_Assignments", //provide the join table name
			joinColumns= {@JoinColumn(name="fk_farmerId")}, //foreign key column for current class
			inverseJoinColumns = {@JoinColumn(name="fk_productId")} //foreign key column for collection
			)
	@XmlTransient //ignore the association property when shared via service
	public Set<Product> getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Set<Product> productAssigned) {
		this.productAssigned = productAssigned;
	}

	@Id
	@Column(name="farmer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getFarmerFirstName() {
		return farmerFirstName;
	}
	public void setFarmerFirstName(String farmerFirstName) {
		this.farmerFirstName = farmerFirstName;
	}
	public String getFarmerLastName() {
		return farmerLastName;
	}
	public void setFarmerLastName(String farmerLastName) {
		this.farmerLastName = farmerLastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + farmerId;
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
		Farmer other = (Farmer) obj;
		if (farmerId != other.farmerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Farmers [farmerId=" + farmerId + ", farmerFirstName=" + farmerFirstName + ", farmerLastName="
				+ farmerLastName + ", location=" + location + ", contactNumber=" + contactNumber + "]";
	}
}
