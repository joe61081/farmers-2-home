package com.mastek.farmers2home.order;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/farmers2home")
public interface OrderAPI {
	
	@GET
	@Path("/Order/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Order>listAllOrders();
	
	@GET
	@Path("/Order/find/{OrderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Order findByOrderId(@PathParam("orderId") int orderId);
	

	@POST
	@Path("/Order/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Order registerNewOrder(@BeanParam Order newOrder);
	
	

}
