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


@Path("/")
public interface ProductAPI {
	
		// GET  http://localhost:8080/farmers2home/products
		@GET	
		@Path("/products")	//URL Path to access this method
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Iterable<Product> listAllProducts();
		
		// GET http://localhost:8080/farmers2home/products{farmerId}
		@GET 
		@Path("/products/{productId}")
		@Produces({MediaType.APPLICATION_JSON})
		public Product findByProductId(@PathParam("productId")int productId);
		
		// POST http://localhost:8080/farmers2home/products/register
		@POST 
		@Path("/products/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Product registerNewProduct(@BeanParam Product newProduct);
		
		// GET http://localhost:8080/farmers2home/products/orderItem/{productId}
		@GET
		@Path("/products/orderItem/{productId}")
		@Produces({MediaType.APPLICATION_JSON})
		public Set<OrderItem> getProductsOrderItem(@PathParam("productId") int productId);
		
		// POST http://localhost:8080/farmers2home/products/orderItem/register
		@POST
		@Path("/products/orderItem/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public OrderItem registerOrderItemForProduct(@FormParam("productId")int productId, @BeanParam OrderItem newOrderItem);
		
	}
