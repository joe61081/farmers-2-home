package com.mastek.farmers2home.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.farmers2home.product.Product;
import com.mastek.farmers2home.product.ProductCat;
import com.mastek.farmers2home.product.ProductJPADAO;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ProductTest {
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Test
	public void testProductAdd() {
		Product prod = new Product();
		prod.setProductCat(ProductCat.GENERALMERCHANDISE);
		prod.setProductDesc("New Product Description");
		prod.setProductName("New Product Name");
		prod.setStockQuantity(8);
		prod.setProductPrice(13);
		
		prod = prodDAO.save(prod);
	}

}
