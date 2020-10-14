package com.mastek.farmers2home.payment;


import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.customer.CustomerJPADAO;
import com.mastek.farmers2home.order.Order;
import com.mastek.farmers2home.order.OrderJPADAO;



@Component
@Scope("singleton")
public class PaymentService implements PaymentAPI {
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	CustomerJPADAO custDAO;

	@Override
	public Payment registerNewPayment(Payment newPayment) {
		newPayment = paymentDAO.save(newPayment);
		return newPayment;
	}

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


	@Override
	public Iterable<Payment> listAllPayments() {
		System.out.println("Listing all Payment");
		return paymentDAO.findAll();

	}

	@Override
	public Payment findByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return paymentDAO.findById(paymentId).get();
	}

	@Override
	public Payment registerPaymentForOrder(int paymentId, Order neworder) {
		// TODO Auto-generated method stub
		return null;
	}


	}
	





	

