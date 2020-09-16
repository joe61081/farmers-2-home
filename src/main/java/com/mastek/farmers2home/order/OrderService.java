package com.mastek.farmers2home.order;

import javax.transaction.Transactional;

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
	

	@Transactional
	public Order assignOrdertoPayment(int orderId, int paymentId) {
		Order order = orderDAO.findById(orderId).get();
		Payment payment = paymentDAO.findById(paymentId).get();
		
		order.getPaymentAssigned();
		orderDAO.save(order);
		return order;
}
}
