package com.mastek.farmers2home.payment;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.farmers2home.order.Order;


@Path("/farmers2home/")
public interface PaymentAPI {


	@GET
	@Path("/payment/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Payment>listAllPayments();
	
	@GET
	@Path("/payment/find/{paymentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Payment findByPaymentId(@PathParam("paymentid")int paymentid);
	

	@POST
	@Path("/payment/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment registerNewPayment(@BeanParam Payment newPayment);
	
	

	@POST
	@Path("/payment/order/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment registerPaymentForOrder(@FormParam("paymentId")int paymentId, @BeanParam Order neworder);
	

}
