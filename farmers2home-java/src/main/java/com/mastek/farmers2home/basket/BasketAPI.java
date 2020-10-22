package com.mastek.farmers2home.basket;

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

@Path("/basket")
public interface BasketAPI {

	@GET
	@Path("/basket/list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }) // formats which the method supports
	public Iterable<Basket> listAllBaskets();

	@GET // http method
	@Path("/basket/find/{basketId}") // url with parameter format
	@Produces({ MediaType.APPLICATION_JSON })
	public Basket findBasketId(@PathParam("basketId") int basketId);

	@POST // http method Post used to send data in requests
	@Path("/basket/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Basket registerNewBasket(@BeanParam Basket newBasket);

	@GET
	@Path("/basket/basketItems/{basketID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<Product> getBasketProducts(@PathParam("basketId") int basketId);

	@POST // http method Post used to send data in requests
	@Path("/basket/basketItems/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	Basket assignBasketsToProducts(@FormParam("basketId") int basketId, @FormParam("productId") int productId);

}
