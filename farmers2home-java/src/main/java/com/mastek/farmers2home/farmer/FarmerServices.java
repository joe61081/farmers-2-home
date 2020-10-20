package com.mastek.farmers2home.farmer;


import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.product.Product;
import com.mastek.farmers2home.product.ProductJPADAO;

@Component
public class FarmerServices implements FarmerAPI {

	@Autowired
	FarmerJPADAO farmerDAO;

	@Autowired
	ProductJPADAO productDAO;

	@Transactional
	public Farmer assignFarmerToProduct(int farmerId, int productId) {

		Farmer farmer = farmerDAO.findById(farmerId).get();

		Product product = productDAO.findById(productId).get();



		farmer.getProductAssigned().add(product);

		farmerDAO.save(farmer);

		return farmer;

	}



	@Override
	@Transactional
	public Product registerProductForFarmer(int farmerId, Product newProduct) {
		
		newProduct = productDAO.save(newProduct);

		assignFarmerToProduct(farmerId, newProduct.getProductId());

		return newProduct;

		

	}

	@Override
	public Iterable<Farmer> listAllFarmers() {
		System.out.println("Listing all farmers");
		return farmerDAO.findAll();
	}

	@Override
	public Farmer findByFarmerId(int farmerId) {
		return farmerDAO.findById(farmerId).get();
	}

	@Override
	public Farmer registerNewFarmer(Farmer newFarmer) {
		newFarmer = farmerDAO.save(newFarmer);
		return newFarmer;
	}

	@Override
	public Set<Product> getFarmerProducts(int farmerId) {
		Farmer currentFarmer = farmerDAO.findById(farmerId).get();
		int count = currentFarmer.getProductAssigned().size();
		System.out.println(count+ "Products found");
		Set<Product> products = currentFarmer.getProductAssigned();
		return products;
	}


	@Override
	public Farmer getFarmerLogin(String email, String password) {
		return farmerDAO.findFarmerLogin(email, password);
	}

	@Override
	public boolean isEmailInUse(String email) {
		Farmer user = farmerDAO.emailCheck(email);
		if(user == null) {
			return false;
		}
		return true; 
	}

	
}

	


