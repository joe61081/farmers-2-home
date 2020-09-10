package com.mastek.farmers2home.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/customer")
public class CustomerService {

    @Autowired
    CustomerJPADAO customerRepo;

    @POST
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer addCustomer(Customer newCustomer) {
        customerRepo.save(newCustomer);
        return newCustomer;
    }

}