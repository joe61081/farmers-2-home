package com.mastek.farmers2home.basket;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.farmers2home.product.Product;
import com.mastek.farmers2home.product.ProductJPADAO;

@Component
public class BasketService implements BasketAPI {

	@Autowired
	BasketJPADAO basketDAO;

	@Autowired
	ProductJPADAO productDAO;

	@Override
	public Iterable<Basket> listAllBaskets() {
		// TODO Auto-generated method stub
		return basketDAO.findAll();
	}

	@Override
	public Basket findBasketId(int basketId) {
		return basketDAO.findById(basketId).get();
	}

	@Override
	public Basket registerNewBasket(Basket newBasket) {
		newBasket = basketDAO.save(newBasket);
		return newBasket;
	}

	@Override
	@Transactional
	public Set<Product> getBasketProducts(int basketId) {
		Basket currentBasket = basketDAO.findById(basketId).get();
		int count = currentBasket.getProductAssigned().size();
		System.out.println("Basket found: " + currentBasket.getBasketId() + " Products in Basket = " + count);


		Set<Product> Product = currentBasket.getProductAssigned();
		return Product;
	}

	@Override
	public Basket assignBasketsToProducts(int basketID, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
