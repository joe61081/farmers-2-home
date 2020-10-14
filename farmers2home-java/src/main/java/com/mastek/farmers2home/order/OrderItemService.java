//package com.mastek.farmers2home.order;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.mastek.farmers2home.product.Product;
//import com.mastek.farmers2home.product.ProductJPADAO;
//
//@Component
//public class OrderItemService implements OrderAPI {
//
//    @Autowired
//    OrderItemJPADAO orderItemJPADAO;
//
//    @Autowired
//    OrderJPADAO orderJPADAO;
//
//    @Autowired
//    ProductJPADAO productJPADAO;
//
//    public OrderItem addProductToOrder(Order assignedOrder, Product assignedProduct, int quantity) {
//        Order order = orderJPADAO.findById(assignedOrder.getOrderId()).get();
//        Product product = productJPADAO.findById(assignedProduct.getProductId()).get();
//
//        OrderItem orderItem = new OrderItem();
//        orderItem.setAssignedOrder(order);
//        orderItem.setAssignedProduct(product);
//        orderItem.setQuantity(quantity);
//
//        orderItemJPADAO.save(orderItem);
//        return orderItem;
//    }
//
//	@Override
//	public Iterable<Order> listAllOrders() {
//		// TODO Auto-generated method stub
//		return orderJPADAO.findAll();
//	}
//
//	@Override
//	public Order findByOrderId(int orderId) {
//		// TODO Auto-generated method stub
//		return orderJPADAO.findById(orderId).get();
//	}
//
//	@Override
//	public Order registerNewOrder(Order newOrder) {
//		newOrder = orderJPADAO.save(newOrder);
//		return newOrder;
//	}
//}
