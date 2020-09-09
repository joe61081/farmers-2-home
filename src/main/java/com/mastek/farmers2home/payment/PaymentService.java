package com.mastek.farmers2home.payment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PaymentService {
	
	String exampleProperty;
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	public PaymentService() {
		System.out.println("Payment Service Created");
	}
	@PostConstruct
	public void initializeService() {
		System.out.println("Payment Service Initialized");
	}
	@PreDestroy
	public void terminateService() {
		System.out.println("Payment Service Terminated");
	}
	public void exampleMethod() {
		System.out.println("Connect to:"+getExampleProperty()+"for business data");
	}
	private String getExampleProperty() {
		return exampleProperty;
	}
	@Value("Spring Example Data Source")
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set:"+exampleProperty);
		this.exampleProperty=exampleProperty;
	}

}
