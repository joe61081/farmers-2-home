package com.mastek.farmers2home.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer")
public interface CustomerJPADAO extends CrudRepository<Customer, Integer> {

}