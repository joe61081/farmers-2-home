package com.mastek.farmers2home.farmer;

public class Farmers {

	int farmerId;
	String farmerFirstName;
	String farmerLastName;
	String location;
	long contactNumber;
	
	public Farmers() {
	}
	
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
		Farmers other = (Farmers) obj;
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
