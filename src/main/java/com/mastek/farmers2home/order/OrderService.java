package com.mastek.farmers2home.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;


public class OrderService {
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Transactional
	public Order assignOrderToPayment(int OrderId, int paymentId) {
		Order order = orderDAO.findById(OrderId).get();
		Payment payment = paymentDAO.findById(paymentId).get();
		
		order.getpaymentAssigned();
		orderDAO.save(order);
		return order;

}
}
