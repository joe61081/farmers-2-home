package com.mastek.farmers2home.order;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Orders {
	int OrderId;
	double OrderPrice;
	orderStatus OrderStatus;
	Date OrderDate;
	boolean subscription;
	

}
