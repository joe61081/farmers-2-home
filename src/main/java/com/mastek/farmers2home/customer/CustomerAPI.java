package com.mastek.farmers2home.customer;

import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer/")
public interface CustomerAPI {

    @POST
    @Path("/register")
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer addCustomer(@BeanParam Customer newCustomer);

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer getCustomerLogin(@QueryParam("email") String email, @QueryParam("pass") String password);

}
