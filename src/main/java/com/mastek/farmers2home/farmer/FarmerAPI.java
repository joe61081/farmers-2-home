package com.mastek.farmers2home.farmer;

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

import com.mastek.farmers2home.product.Product;



@Path("/farmers")
public interface FarmerAPI {

	// http://localhost:8080/api/farmers/list
	@GET	
	@Path("/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Farmer> listAllFarmers();
	
	// http://localhost:8080/api/farmers/find/{farmerId}
	@GET 
	@Path("/find/{farmerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Farmer findByFarmerId(@PathParam("farmerId")int farmerId);
	
	// http://localhost:8080/api/farmers/register
	@POST 
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Farmer registerNewFarmer(@BeanParam Farmer newFarmer);
	
	// http://localhost:8080/api/farmers/products/{farmerId}
	@GET
	@Path("/products/{farmerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Product> getFarmerProducts(@PathParam("farmerId") int farmerId);
	
	// http://localhost:8080/api/farmers/products/register
	@POST
	@Path("/products/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerProductForFarmer(@FormParam("farmerId")int farmerId, @BeanParam Product newProduct);
	
	// http://localhost:8080/api/farmers/find/{email}/{password}
	@GET
    @Path("/find/{email}/{password}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Iterable<Farmer> findByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password);
	
}
