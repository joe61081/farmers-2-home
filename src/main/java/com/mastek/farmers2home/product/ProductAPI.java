package com.mastek.farmers2home.product;

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

import com.mastek.farmers2home.order.OrderItem;

@Path("/farmers2home")
public interface ProductAPI {
	
	// http://localhost:7777/farmers2home/product/list
		@GET	
		@Path("/product/list")	//URL Path to access this method
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Iterable<Product> listAllProducts();
		
		// http://localhost:7777/farmers2home/product/find/{farmerId}
		@GET 
		@Path("/product/find/{productId}")
		@Produces({MediaType.APPLICATION_JSON})
		public Product findByProductId(@PathParam("productId")int productId);
		
		// http://localhost:7777/farmers2home/product/register
		@POST 
		@Path("/product/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Product registerNewProduct(@BeanParam Product newProduct);
		
		// http://localhost:7777/farmers2home/product/orderItem/{productId}
		@GET
		@Path("/product/orderItem/{productId}")
		@Produces({MediaType.APPLICATION_JSON})
		public Set<OrderItem> getProductsOrderItem(@PathParam("productId") int productId);
		
		// http://localhost:7777/farmers2home/product/orderItem/register
		@POST
		@Path("/product/orderItem/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public OrderItem registerOrderItemForProduct(@FormParam("productId")int productId, @BeanParam OrderItem newOrderItem);
		
	}
