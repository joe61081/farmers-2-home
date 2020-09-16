package com.mastek.farmers2home.product;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.order.OrderItem;
import com.mastek.farmers2home.order.OrderItemJPADAO;

@Component
@Scope("singleton")
public class ProductServices implements ProductAPI {

	@Autowired
	ProductJPADAO proDAO;
	
	@Autowired
	OrderItemJPADAO orIDAO;
	
	@Transactional // To One relationship assignment
	public OrderItem assignOrderItemToProduct(int orIId, int proId) {
		OrderItem orI = orIDAO.findById(orIId).get();
		Product pro = proDAO.findById(proId).get();
		
		orI.setAssignedProduct(pro);
		pro.getOrderItemAssigned().add(orI);
		
		orIDAO.save(orI);
		proDAO.save(pro);
		
		return orI;
		
	}

	@Override
	public Iterable<Product> listAllProducts() {
		System.out.println("Listing All Products");
		return proDAO.findAll();
	}

	@Override
	public Product findByProductId(int productId) {
		 return proDAO.findById(productId).get();
	}

	@Override
	public Product registerNewProduct(Product newProduct) {
		newProduct = proDAO.save(newProduct);
		return newProduct;
	}

	@Override
	@Transactional
	public Set<OrderItem> getProductsOrderItem(int productId) {
		Product productAssigned = proDAO.findById(productId).get();
		
		int count = productAssigned.getOrderItemAssigned().size();
		System.out.println(count+" Products found");
		
		Set<OrderItem> orderItem = productAssigned.getOrderItemAssigned();
		
		return orderItem;
	}

	@Override
	@Transactional
	public OrderItem registerOrderItemForProduct(int productId, OrderItem newOrderItem) {
		newOrderItem = orIDAO.save(newOrderItem);
		assignProductToOrderItem(productId, newOrderItem.getOrderItemId());
		return newOrderItem;
	}

	@Transactional
	public Product assignProductToOrderItem(int productId, int orderItemId) {
		Product pro = proDAO.findById(productId).get();
		OrderItem orI = orIDAO.findById(orderItemId).get();
		
		pro.getOrderItemAssigned().add(orI);
		pro = proDAO.save(pro);
		return pro;
		
		
	}
}
