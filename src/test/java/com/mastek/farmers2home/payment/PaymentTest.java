package com.mastek.farmers2home.payment;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.order.OrderJPADAO;
import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;
import com.mastek.farmers2home.payment.PaymentService;
import com.mastek.farmers2home.payment.PaymentType;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class PaymentTest {
	
	@Autowired
	PaymentJPADAO paymentdao;
	@Autowired
	PaymentService paymentservice;
	@Autowired
	OrderJPADAO orderdao;
	
	@Test
	public void testAddPayment() {
		Payment payment = new Payment();
		
		payment.setAccountNumber(234567180);
		payment.setCardNumber(34557290);
		payment.setPaymentDate("2019-06-13");
		payment.setPaymentId(1);
		payment.setPaymentType(PaymentType.CREDIT);
		payment.setSortCode(2345678);
		payment.setTotalPaid(80.00);
		
		payment = paymentdao.save(payment);
		assertNotNull("Payment Not Added", payment);
	}
	@Test
	public void testListAllPayments() {
		System.out.println("Print all payments");
		for (Payment payment : paymentdao.findAll()) {
			System.out.println(payment);
	}
	}
	@Test
	public void testAssignPaymentToOrder() {
		Payment payment = paymentservice.assignPaymentToOrder(1, 1);
		assertNotNull("Payment Not Assigned", payment.getOrderAssigned());
		
	}
				
	}

		
	

	


