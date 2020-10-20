package com.mastek.farmers2home.apis;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.customer.CustomerService;
import com.mastek.farmers2home.farmer.FarmerServices;
import com.mastek.farmers2home.order.OrderService;
import com.mastek.farmers2home.payment.PaymentService;
import com.mastek.farmers2home.product.ProductServices;


@Component //declare it as spring component
@ApplicationPath("/farmers2home/")
public class APIConfig extends ResourceConfig {
	//configure the service classes using ResourceConfig
	
	public APIConfig() {
		//enable the CORS filter for UI applications to access the service
		register(CORSFilter.class);
		// register each service class to enable services as API
		register(CustomerService.class);
		register(FarmerServices.class);
		register(PaymentService.class);
		register(OrderService.class);
		register(OrderService.class);
		register(ProductServices.class);
	}

}

