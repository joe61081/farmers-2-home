package com.mastek.farmers2home.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "payment")
public interface PaymentJPADAO extends CrudRepository<Payment, Integer> {

}
