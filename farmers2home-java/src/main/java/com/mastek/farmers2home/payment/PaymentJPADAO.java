package com.mastek.farmers2home.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJPADAO extends CrudRepository<Payment, Integer> {

}
