package com.mastek.farmers2home.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/customer")
public class CustomerService {

    @Autowired
    CustomerJPADAO customerDao;

    @POST
    @Path("/register")
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer addCustomer(@BeanParam Customer newCustomer) {
        customerDao.save(newCustomer);
        return newCustomer;
    }

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer getCustomerLogin(@QueryParam("email") String email, @QueryParam("pass") String password){
        Customer customer = customerDao.findCustomerLogin(email, password);
        return customer;
    }

}