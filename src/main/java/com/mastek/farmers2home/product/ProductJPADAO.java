package com.mastek.farmers2home.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPADAO extends CrudRepository<Product, Integer> {

}
