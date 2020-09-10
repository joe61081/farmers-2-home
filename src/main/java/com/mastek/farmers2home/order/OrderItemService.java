package com.mastek.farmers2home.order;

import com.mastek.farmers2home.customer.Customer;
import com.mastek.farmers2home.product.Product;
import com.mastek.farmers2home.product.ProductJPADAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemService {

    @Autowired
    OrderItemJPADAO orderItemJPADAO;

    @Autowired
    OrderJPADAO orderJPADAO;

    @Autowired
    ProductJPADAO productJPADAO;

    public OrderItem addProductToOrder(Order assignedOrder, Product assignedProduct, int quantity) {
        Order order = orderJPADAO.findById(assignedOrder.getOrderId()).get();
        Product product = productJPADAO.findById(assignedProduct.getProductId()).get();

        OrderItem orderItem = new OrderItem();
        orderItem.setAssignedOrder(order);
        orderItem.setAssignedProduct(product);
        orderItem.setQuantity(quantity);

        orderItemJPADAO.save(orderItem);
        return orderItem;
    }
}
