package com.mastek.farmers2home.order;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface OrderItemAPI {

	@GET
	@Path("/orderItem/list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Iterable<OrderItem> listAllOrderItems();

	@GET
	@Path("/orderItem/{orderId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public OrderItem findByOrderItemId(@PathParam("orderItemId") int orderItemId);

	@POST
	@Path("/orderItem/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderItem registerNewOrderItem(@BeanParam OrderItem newOrderItem);

	@POST
	@Path("/orderItem/products/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	OrderItem assignProductsToOrderItems(@FormParam("productId") int productId,
			@FormParam("orderItemId") int orderItemId);

}