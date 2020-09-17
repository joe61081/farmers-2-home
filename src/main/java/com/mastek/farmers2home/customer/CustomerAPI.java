package com.mastek.farmers2home.customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer/")
public interface CustomerAPI {

    // POST http://localhost:8080/farmers2home/customer/register
    @POST
    @Path("/register")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer addCustomer(@BeanParam Customer newCustomer);

    // POST http://localhost:8080/farmers2home/customer/login
    @POST
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer getCustomerLogin(@FormParam("email") String email, @FormParam("pass") String password);

}
