package com.mastek.farmers2home.payment;

import com.mastek.farmers2home.order.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	private int PaymentId;
	private double TotalPaid;
	private PaymentType PaymentType;
	private String PaymentDate;
	private long CardNumber;
	private int SortCode;
	private long AccountNumber;
	
	private Order orderAssigned;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_order_id")
	public Order getOrderAssigned() {
		return orderAssigned;
	}
	public void setCurrentorder(Order currentorder) {
		this.orderAssigned = currentorder;
	}
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}
	public double getTotalPaid() {
		return TotalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		TotalPaid = totalPaid;
	}
	@Enumerated(EnumType.STRING)
	public PaymentType getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		PaymentType = paymentType;
	}
	public String getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	public long getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(long cardNumber) {
		CardNumber = cardNumber;
	}
	public int getSortCode() {
		return SortCode;
	}
	public void setSortCode(int sortCode) {
		SortCode = sortCode;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PaymentId;
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
		if (PaymentId != other.PaymentId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Payment [PaymentId=" + PaymentId + ", TotalPaid=" + TotalPaid + ", PaymentType=" + PaymentType
				+ ", PaymentDate=" + PaymentDate + ", CardNumber=" + CardNumber + ", SortCode=" + SortCode
				+ ", AccountNumber=" + AccountNumber + "]";
	}
	
}
