package com.mastek.farmers2home.order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;


@Component
public class OrderService implements OrderAPI {

	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	

	@Override
	public Order registerNewOrder(Order newOrder) {
		newOrder = orderDAO.save(newOrder);
		return newOrder;

	}


	@Override
	public Order findByOrderId(int orderId) {

		return orderDAO.findById(orderId).get();
	}
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
	public Payment assignPaymenttoOrder(int orderId, int PaymentId) {
		Payment payment = paymentDAO.findById(PaymentId).get();
		Order order = orderDAO.findById(orderId).get();
		
		payment.setOrderAssigned(order);
		order.setPaymentAssigned(payment);
		
		
		return payment;
		

}


	@Override
	public Iterable<Order> listAllOrders() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}


}
