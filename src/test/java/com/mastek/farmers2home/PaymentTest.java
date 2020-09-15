package com.mastek.farmers2home;


import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.order.OrderItemService;
import com.mastek.farmers2home.order.OrderJPADAO;
import com.mastek.farmers2home.order.OrderService;
import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;
import com.mastek.farmers2home.payment.PaymentService;
import com.mastek.farmers2home.payment.PaymentType;

@RunWith(SpringRunner.class) //added this because it was throwing a NullPointerException at Line 49
@SpringBootTest
public class PaymentTest {
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	PaymentService paymentservice;
	
	@Autowired
	OrderJPADAO orderDAO;
	
	@Autowired
	OrderService orderservice;
	
	@Test
	public void testpaymentDAOAdd() {
		Payment payment = new Payment();
		
			payment.setAccountNumber(456782345);
			payment.setCardNumber(234517854);
			payment.setPaymentDate("2020/08/13");
			payment.setPaymentId(1);
			payment.setPaymentType(PaymentType.CREDIT);
			payment.setSortCode(1564768956);
			payment.setTotalPaid(78.90);

			payment = paymentDAO.save(payment);
			
			System.out.println(payment);
			assertNotNull("Payment Not Added", payment);

		}
	@Test
	public void testUpdatePayment() {
		Payment payment=paymentDAO.findById(2).get();
		System.out.println("Payment Fetched"+payment);
		
		payment.setAccountNumber(486982445);
		payment.setCardNumber(277767801);
		payment.setPaymentDate("2020/05/13");
		payment.setPaymentId(2);
		payment.setPaymentType(PaymentType.DEBIT);
		payment.setSortCode(256436895);
		payment.setTotalPaid(50.00);
		
		payment = paymentDAO.save(payment);
		
		System.out.println(payment);
		assertNotNull("Payment Updated", payment);
	}
	@Test
	public void testAssignPaymentToOrder() {
		Payment payment=paymentservice.assignPaymentToOrder(2, 3);
		assertNotNull("Payment Not Assigned", payment);
	}
	}

	
		
	

		
	
	
	


