package com.mastek.farmers2home.customer;

import com.mastek.farmers2home.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Component
@Path("/customer")
public class CustomerService {

    @Autowired
    CustomerJPADAO customerDao;


    public Customer addCustomer(Customer newCustomer) {
        customerDao.save(newCustomer);
        return newCustomer;
    }
    
//    Customer customer = customerDao.findCustomerLogin(email, password);
//        return customer;
        
    public Customer getCustomerLogin(String email, String password){
         return customerDao.findCustomerLogin(email, password);
    }

    public Set<Order> getCustomerOrders(int custId){
        Customer customer = customerDao.findById(custId).get();
        return customer.getOrders();

    }

}