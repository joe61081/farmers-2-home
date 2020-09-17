package com.mastek.farmers2home.customer;

import com.mastek.farmers2home.order.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

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


    // GET http://localhost:8080/farmers2home/customer/orders/{customerId}
    @GET
    @Path("/orders/{customerId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Set<Order> getCustomerOrders(@PathParam("customerId")int custId);

}
