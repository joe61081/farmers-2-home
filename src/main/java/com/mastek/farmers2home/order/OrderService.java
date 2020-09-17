package com.mastek.farmers2home.order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.jvnet.hk2.config.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;


@Component
public class OrderService {

	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	public OrderService() {
		System.out.println("Order Service Created");
		
}
	@PostConstruct
		public void initializeService() {
		System.out.println("Order Service Initialized");
}

	@PreDestroy
		public void terminateService() {
		System.out.println("Order Service Terminated");
		
	}
	

	@Transactional
	public Order assignOrdertoPayment(int orderId, int paymentId) {
		Order order = orderDAO.findById(orderId).get();
		Payment payment = paymentDAO.findById(paymentId).get();
	
		order.getPaymentAssigned();
		orderDAO.save(order);
		return order;
}
}
