package com.mastek.farmers2home.payment;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.order.Order;
import com.mastek.farmers2home.order.OrderJPADAO;


@Component
@Scope("singleton")
public class PaymentService {
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	public PaymentService() {
		System.out.println("Payment Service Created");
		
}
	@PostConstruct
		public void initializeService() {
		System.out.println("Payment Service Initialized");
}

	@PreDestroy
		public void terminateService() {
		System.out.println("Payment Service Terminated");
		

}
	@Transactional
	public Payment assignOrderToPayment(int Orderid, int Paymentid) {
		Order order = orderDAO.findById(Orderid).get();
		Payment payment = paymentDAO.findById(Paymentid).get();
		
		order.setPaymentAssigned(payment);
		payment.setOrderAssigned(order);
		
		orderDAO.save(order);
		paymentDAO.save(payment);
		return payment;

	}
	}




	

