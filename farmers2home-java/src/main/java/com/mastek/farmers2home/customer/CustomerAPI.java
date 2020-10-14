package com.mastek.farmers2home.customer;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.farmers2home.order.Order;

@Path("/customer")
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


	@GET //http method
	@Path("/find/{customerId}") // url with parameter format
	@Produces({MediaType.APPLICATION_JSON})
	public Customer findCustomerId(@PathParam("customerId") int customerId);
}
