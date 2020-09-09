package com.mastek.farmers2home.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerJPARepository extends CrudRepository<Customer, Integer> {

}