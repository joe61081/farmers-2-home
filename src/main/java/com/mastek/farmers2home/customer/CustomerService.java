package com.mastek.farmers2home.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RestController
@Path("/customer/")
public class CustomerService {

    CustomerJPARepository customerRepo;

    @Autowired
    public void setParticipantRepo(CustomerJPARepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerJPARepository getRepository() {
        return customerRepo;
    }

    @POST
    @Path("/register")
    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Customer addCustomer(@BeanParam Customer newCustomer) {
        getRepository().save(newCustomer);
        return newCustomer;
    }

}