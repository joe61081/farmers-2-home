package com.mastek.farmers2home.customer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerJPADAO customerJPADAO;

    @Test
	public void testAddNewCustomer() {
        Customer c = new Customer();
        c.setCustomerName("Mary Hubbert");
        c.setCustomerAddress("123 George Street");
        c.setCustomerContact("12345");
        c.setEmailAddress("maryhubbert@gmail.com");
       
        c = customerService.addCustomer(c);
		c = customerJPADAO.save(c);
        Assert.assertNotNull(customerJPADAO.findById(c.getCustomerId()));

        Customer persistedCustomer = customerJPADAO.findById(c.getCustomerId()).get();

        Assert.assertEquals(persistedCustomer.getCustomerName(),"Mary Hubbert");
        Assert.assertEquals(persistedCustomer.getCustomerAddress(),"123 George Street");
        Assert.assertEquals(persistedCustomer.getCustomerContact(),"12345");
    }

//    @Test
//    public void testGetCustomerLogin(){
//        Customer customer = customerService.getCustomerLogin("test@email.com", "pass");
//
//        Assert.assertEquals(customer.getCustomerId(), 1);
//        Assert.assertEquals(customer.getEmailAddress(), "test@email.com");
//        Assert.assertEquals(customer.getPassword(), "pass");
//        Assert.assertEquals(customer.getCustomerName(), "Sample Name");
//        Assert.assertEquals(customer.getCustomerAddress(), "Sample Address");
//        Assert.assertEquals(customer.getCustomerContact(), "012345");
    }
