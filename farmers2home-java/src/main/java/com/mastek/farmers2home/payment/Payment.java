package com.mastek.farmers2home.payment;


import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.order.Order;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="payment")
public class Payment {
	
	private int paymentId;
	
	@FormParam("First Name")
	private String firstName;
	
	@FormParam("Last Name")
	private String lastName;
	
	@FormParam("Email")
	private String email;
	
	@FormParam("Address")
	private String address;
	
	@FormParam("City")
	private String city;
	
	@FormParam("County")
	private String county;
	
	@FormParam("PostCode")
	private String postCode;
	
	@FormParam("Payment Type")
	private PaymentType paymentType;
	
	@FormParam("Name on Card")
	private String nameOnCard;
	
	@FormParam("Card Number")
	private long cardNumber;
	
	@FormParam("Expiry Month")
	private String expiryMonth;
	
	@FormParam("Expiry Year")
	private String expiryYear;
	
	@FormParam("Card Verification Value")
	private long cvv;
	
	@FormParam("Total Paid")
	private double totalPaid;
	
	@FormParam("Payment Date")
	private String paymentDate;
	
	@FormParam("Shipping Method")
	private Shippingmethod shippingMethod;
	
	//RELATIONSHIPS 
	
	private Order orderAssigned;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_order_id")
	@XmlTransient
	public Order getOrderAssigned() {
		return orderAssigned;
	}

	public void setOrderAssigned(Order orderAssigned) {
		this.orderAssigned = orderAssigned;
	}
	

	//GETTERS & SETTERS
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCounty() {
		return county;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Enumerated(EnumType.STRING)
	
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public long getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getExpiryMonth() {
		return expiryMonth;
	}
	
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	
	public String getExpiryYear() {
		return expiryYear;
	}
	
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public long getCvv() {
		return cvv;
	}
	
	public void setCvv(long cvv) {
		this.cvv = cvv;
	}
	
	public double getTotalPaid() {
		return totalPaid;
	}
	
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	
	public String getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public Shippingmethod getShippingMethod() {
		return shippingMethod;
	}
	@Enumerated(EnumType.STRING)
	public void setShippingMethod(Shippingmethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentId;
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
		Payment other = (Payment) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", city=" + city + ", county=" + county + ", postCode=" + postCode
				+ ", paymentType=" + paymentType + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cvv=" + cvv + ", totalPaid="
				+ totalPaid + ", paymentDate=" + paymentDate + ", shippingMethod=" + shippingMethod + "]";
}
}
	
