package com.mastek.farmers2home.farmer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerJPADAO extends CrudRepository<Farmer, Integer> {

}
