package com.mastek.farmers2home.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class OrderTest {
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	OrderService orderS;
	
	@Test
	public void testOrderAdd() {
		Order order = new Order();
		order.setSubscription(false);
		order.setOrderDate(null);
		order.setOrderPrice(17.50);
		order.setOrderStatus(orderStatus.RECEIVED);
		
		order = orderDAO.save(order);
	}

}
