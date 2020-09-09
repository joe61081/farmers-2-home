package com.mastek.farmers2home.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mastek.farmers2home.order.Order;

@Entity
@Table(name="payment")
public class Payment {
	
	int PaymentId;
	double TotalPaid;
	PaymentType PaymentType;
	String PaymentDate;
	long CardNumber;
	int SortCode;
	long AccountNumber;
	
	Order currentorder;
	
	@OneToOne
	@JoinColumn(name ="fk_order_id")
	
	public Order getCurrentorder() {
		return currentorder;
	}

	public void setCurrentorder(Order currentorder) {
		this.currentorder = currentorder;
	}
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public String toString() {
		return "Payment [PaymentId=" + PaymentId + ", TotalPaid=" + TotalPaid + ", PaymentType=" + PaymentType
				+ ", PaymentDate=" + PaymentDate + ", CardNumber=" + CardNumber + ", SortCode=" + SortCode
				+ ", AccountNumber=" + AccountNumber + "]";
	}
	
	
	
	
	

}
