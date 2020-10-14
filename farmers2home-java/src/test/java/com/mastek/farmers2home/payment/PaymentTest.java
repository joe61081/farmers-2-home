
package com.mastek.farmers2home.payment;

import static org.junit.Assert.assertNotNull;

import java.time.Year;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.customer.CustomerJPADAO;
import com.mastek.farmers2home.customer.CustomerService;
import com.mastek.farmers2home.order.OrderJPADAO;
import com.mastek.farmers2home.order.OrderService;
import com.mastek.farmers2home.payment.Payment;
import com.mastek.farmers2home.payment.PaymentJPADAO;
import com.mastek.farmers2home.payment.PaymentService;
import com.mastek.farmers2home.payment.PaymentType;


@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class PaymentTest {
	
	@Autowired
	PaymentJPADAO paymentdao;
	@Autowired
	PaymentService paymentservice;
	@Autowired
	OrderJPADAO orderdao;
	@Autowired
	OrderService orderservice;
	@Autowired
	CustomerService customerservice;
	@Autowired
	CustomerJPADAO customerDAO;

	@Test
	public void testAddPayment() {
		Payment payment = new Payment();
		
		payment.setFirstName("Mary");
		payment.setLastName("Hubbert");
		payment.setEmail("maryhubbert@gmail.com");
		payment.setAddress("123 George Street");
		payment.setCity("Wakefield");
		payment.setCounty("WestYorkshire");
		payment.setPostCode("WF9 9AY");
		payment.setPaymentType(PaymentType.CREDIT);
		payment.setNameOnCard("Mary Hubbert");
		payment.setCardNumber(444523447);
		payment.setExpiryMonth("September");
		payment.setExpiryYear("2023");
		payment.setCvv(345);
		payment.setPaymentDate("13/10/2020");
		payment.setShippingMethod(Shippingmethod.FirstClassRecorded);
		
		payment = paymentdao.save(payment);
		
		System.out.println(payment);
		assertNotNull("Payment Not Added", payment);
		
	
}
//	@Test
//	public void testListAllPayments() {
//		System.out.println("Print all payments");
//		for (Payment payment : paymentdao.findAll()) {
//			System.out.println(payment);
//		}
//	}
//	@Test
//	public void testAssignPaymentToOrder() {
//	Payment payment = paymentservice.assignOrderToPayment(12, 30);
//	assertNotNull("Payment Not Assigned", payment.getOrderAssigned());
//	
//	}
//}
	
////	@Test
////	public void testDeletePayment() {
////		paymentdao.deleteById(1);
//	}
//	}
//
//
//
//				
//
//		
	

	



}


				

		
	

	
