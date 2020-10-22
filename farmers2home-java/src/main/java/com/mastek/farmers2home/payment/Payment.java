
package com.mastek.farmers2home.payment;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.farmers2home.order.Order;

@Entity
@Table(name="payment")
public class Payment {

	private int paymentId;

	@FormParam("firstName")
	private String firstName;

	@FormParam("lastName")
	private String lastName;

	@FormParam("email")
	private String email;

	@FormParam("address")
	private String address;

	@FormParam("city")
	private String city;

	@FormParam("county")
	private String county;

	@FormParam("postCode")
	private String postCode;

	@FormParam("nameOnCard")
	private String nameOnCard;

	@FormParam("cardNumber")
	private String cardNumber;

	@FormParam("expiryMonth")
	private String expiryMonth;

	@FormParam("expiryYear")
	private String expiryYear;

	@FormParam("cvv")
	private String cvv;

	@FormParam("shippingMethod")
	private String shippingMethod;

	@FormParam("paymentType")
	PaymentType paymentType;

	@FormParam("totalPaid")
	private int totalPaid;

	//RELATIONSHIPS 

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public int getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}

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


	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
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


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
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
				+ ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", expiryMonth=" + expiryMonth
				+ ", expiryYear=" + expiryYear + ", cvv=" + cvv + ", shippingMethod=" + shippingMethod
				+ ", orderAssigned=" + orderAssigned + "]";
	}




}



