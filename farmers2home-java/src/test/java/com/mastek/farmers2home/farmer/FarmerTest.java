package com.mastek.farmers2home.farmer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.product.ProductJPADAO;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
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
		newFarmer.setEmail("john.smith@outlook.com");
		newFarmer.setPassword("Password123");
		
		newFarmer = farmerDAO.save(newFarmer);
		
		System.out.println(newFarmer);
		
		assertNotNull("Error", newFarmer);
	}
	
	//@Test
	public void listAllFarmers() {
		System.out.println("Print all Farmers");
		for (Farmer farmer : farmerDAO.findAll()) {
			System.out.println(farmer);
			
		}
	}
	
	@Test
	public void assignFarmerToProduct() {
		Farmer farmer = farmerSVC.assignFarmerToProduct(3, 4);

		assertTrue(farmer.getProductAssigned().size()>0);
		System.out.println("Farmer assigned to Products" + farmer);
	}
}
