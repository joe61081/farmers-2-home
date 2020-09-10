package com.mastek.farmers2home.farmer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.farmers2home.product.Product;
import com.mastek.farmers2home.product.ProductJPADAO;

public class FarmerServices {

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
}
