package com.mastek.farmers2home.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer")
public interface CustomerJPADAO extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE LOWER(c.emailAddress) = LOWER(:email) AND c.password = :pass")
    public Customer findCustomerLogin(@Param("email") String email, @Param("pass") String pass);

}