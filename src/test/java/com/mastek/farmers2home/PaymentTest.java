package com.mastek.farmers2home;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;

import com.mastek.farmers2home.payment.PaymentType;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Payment.class,loader=AnnotationConfigContextLoader.class)//Failed to load application content error
@SpringBootTest

public class PaymentTest {
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	
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
		
		payment = paymentDAO.save(payment);
		
		System.out.println(payment); 
		
		assertNotNull("Payment Not Added", payment);
		

	}
	

}
