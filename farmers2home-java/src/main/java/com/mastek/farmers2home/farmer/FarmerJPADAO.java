
package com.mastek.farmers2home.farmer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "farmer")
public interface FarmerJPADAO extends CrudRepository<Farmer, Integer> {

	@Query("select a from Farmer a where a.email=:email and a.password=:password")
    public Farmer findFarmerLogin(@Param("email")String email, @Param("password")String password);
	
	@Query("select user from Farmer user where user.email=:email")
	public Farmer emailCheck(@Param("email")String email);
}