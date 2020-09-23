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

@Path("/")
public interface FarmerAPI {

	// GET http://localhost:8080/farmers2home/farmers/
	@GET
	@Path("/farmers")    //URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Farmer> listAllFarmers();

	// GET http://localhost:8080/farmers2home/farmers/{farmerId}
	@GET
	@Path("/farmers/{farmerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Farmer findByFarmerId(@PathParam("farmerId") int farmerId);

	// POST http://localhost:8080/farmers2home/farmers/register
	@POST
	@Path("farmers/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Farmer registerNewFarmer(@BeanParam Farmer newFarmer);

	// GET http://localhost:8080/farmers2home/farmers/products/{farmerId}
	@GET
	@Path("farmers/products/{farmerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Product> getFarmerProducts(@PathParam("farmerId") int farmerId);

	// POST http://localhost:8080/farmers2home/farmers/products/register
	@POST
	@Path("farmers/products/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerProductForFarmer(@FormParam("farmerId") int farmerId, @BeanParam Product newProduct);

	// GET http://localhost:8080/farmers2home/farmers/login/{email}/{password}
	@GET
	@Path("/farmers/login/{email}/{password}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Farmer> findByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password);
}