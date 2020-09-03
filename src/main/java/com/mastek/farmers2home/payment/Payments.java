package com.mastek.farmers2home.payment;

import javax.persistence.Entity;

@Entity
public class Payments {
	int PaymentId;
	double TotalPaid;
	PaymentType PaymentType;
	String PaymentDate;
	long CardNumber;
	int SortCode;
	long AccountNumber;

}
