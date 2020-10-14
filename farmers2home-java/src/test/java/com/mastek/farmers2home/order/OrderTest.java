package com.mastek.farmers2home.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.payment.PaymentJPADAO;
import com.mastek.farmers2home.payment.PaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	PaymentService paymentservice;

	@Test
	public void testAddOrder() {
		Order order = new Order ();
		
		order.setOrderDate("2019-06-20");
		order.setOrderId(9);
		order.setOrderPrice(70.00);
		order.setOrderStatus(orderStatus.RECEIVED);
		order.setSubscription(true);

		orderDAO.save(order);
	}
//	public void testDeleteOrder() {
//		orderDAO.deleteById(3);
//	}
		
}
		
	
	

