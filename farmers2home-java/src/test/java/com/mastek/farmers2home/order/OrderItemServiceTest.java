//
//package com.mastek.farmers2home.order;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.mastek.farmers2home.product.Product;
//import com.mastek.farmers2home.product.ProductJPADAO;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Sql({"/data.sql"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//public class OrderItemServiceTest {
//
////    @Autowired
////    OrderItemService orderItemService;
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
//    @Test
//    public void testAddProductToOrder(){
//        Order order = orderJPADAO.findById(1).get();
//        Product product = productJPADAO.findById(1).get();
//
//        OrderItem orderItem = orderItemService.addProductToOrder(order, product, 1);
//
//		orderItemJPADAO.save(orderItem);
//
//        Assert.assertNotNull(orderJPADAO.findById(orderItem.getOrderItemId()));
//
//        OrderItem persistedOrderItem = orderItemJPADAO.findById(orderItem.getOrderItemId()).get();
//
//        Assert.assertEquals(persistedOrderItem.getAssignedOrder().getOrderId(), 1);
//        Assert.assertEquals(persistedOrderItem.getAssignedProduct().getProductId(), 1);
//        Assert.assertEquals(persistedOrderItem.getQuantity(), 1);
//    }
//}