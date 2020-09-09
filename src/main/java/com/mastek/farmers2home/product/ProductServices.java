package com.mastek.farmers2home.product;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.order.OrderItem;
import com.mastek.farmers2home.order.OrderItemJPADAO;

@Component
@Scope("singleton")
public class ProductServices {

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
	
}
