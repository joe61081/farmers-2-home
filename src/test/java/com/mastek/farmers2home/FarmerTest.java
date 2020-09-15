package com.mastek.farmers2home;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.farmer.Farmer;
import com.mastek.farmers2home.farmer.FarmerJPADAO;
import com.mastek.farmers2home.farmer.FarmerServices;
import com.mastek.farmers2home.product.ProductJPADAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerTest {
	
	@Autowired
	FarmerServices farmerSVC;
	
	@Autowired
	FarmerJPADAO farmerDAO;
	
	@Autowired
	ProductJPADAO productDAO;
	
	@Test
	public void addNewFarmer() {
		Farmer newFarmer = new Farmer();
		newFarmer.setFarmerFirstName("Test first name");
		newFarmer.setFarmerLastName("Test last name");
		newFarmer.setLocation("Test location");
		newFarmer.setContactNumber("123456789");
		
		newFarmer = farmerDAO.save(newFarmer);
		
		System.out.println(newFarmer);
		
		assertNotNull("Error", newFarmer);
	}
	
	@Test
	public void listAllFarmers() {
		System.out.println("Print all Farmers");
		for (Farmer farmer : farmerDAO.findAll()) {
			System.out.println(farmer);
			
		}
	}
	
	@Test
	public void assignFarmerToProduct() {
		Farmer farmer = farmerSVC.assignFarmerToProduct(2, 1);
		assertTrue(farmer.getProductAssigned().size()>0);
	}
}
