package com.mastek.farmers2home.customer;

import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.customer.CustomerJPADAO;
import com.mastek.farmers2home.customer.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerJPADAO customerJPADAO;

    @Test
    public void testAddNewCustomer(){
        Customer c = new Customer();
        c.setCustomerName("Test Customer");
        c.setCustomerAddress("Test Address");
        c.setCustomerContact("12345");

        customerService.addCustomer(c);

        Assert.assertNotNull(customerJPADAO.findById(c.getCustomerId()));

        Customer persistedCustomer = customerJPADAO.findById(c.getCustomerId()).get();

        Assert.assertEquals(persistedCustomer.getCustomerName(),"Test Customer");
        Assert.assertEquals(persistedCustomer.getCustomerAddress(),"Test Address");
        Assert.assertEquals(persistedCustomer.getCustomerContact(),"12345");
    }
}
