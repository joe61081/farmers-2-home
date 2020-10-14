package com.mastek.farmers2home.order;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.payment.PaymentJPADAO;
import com.mastek.farmers2home.payment.PaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class OrderTest {
	

	@Autowired
	OrderJPADAO orderdao;
	@Autowired
	OrderService orderservice;
	@Autowired
	PaymentJPADAO paymentdao;
	@Autowired
	PaymentService paymentservice;

	@Test
	public void testAddOrder() {
		Order order = new Order();
		

		order.setOrderId(13);
		order.setOrderDate("2019-06-13");
		order.setOrderPrice(80.00);
		order.setOrderStatus(orderStatus.SHIPPED);
		order.setSubscription(false);
		
		order = orderdao.save(order);
		assertNotNull("Order Not Added", order);
	}

//	public void testDeleteOrder() {
//		orderDAO.deleteById(3);
//	}
		
}

	

