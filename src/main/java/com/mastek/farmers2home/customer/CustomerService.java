package com.mastek.farmers2home.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
public class CustomerService implements CustomerAPI {

    @Autowired
    CustomerJPADAO customerDao;

    public Customer addCustomer(@BeanParam Customer newCustomer) {
        customerDao.save(newCustomer);
        return newCustomer;
    }

    public Customer getCustomerLogin(@QueryParam("email") String email, @QueryParam("pass") String password){
        Customer customer = customerDao.findCustomerLogin(email, password);
        return customer;
    }

}