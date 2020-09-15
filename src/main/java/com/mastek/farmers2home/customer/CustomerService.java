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
    CustomerJPADAO customerRepo;

    @POST
    @Path("/register")
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer addCustomer(@BeanParam Customer newCustomer) {
        customerRepo.save(newCustomer);
        return newCustomer;
    }

}