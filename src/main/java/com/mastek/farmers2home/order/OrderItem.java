package com.mastek.farmers2home.order;

import com.mastek.farmers2home.product.Product;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

@Entity
@Table(name="ProductOrderJoin")
public class OrderItem {

    private int orderItemId;
    private Order assignedOrder;
    private Product assignedProduct;
    private int quantity;

    @Id
    @Column(name="order_item_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    @ManyToOne
    @JoinColumn(name="fk_orderId")
    @XmlTransient
    public Order getAssignedOrder() {
        return assignedOrder;
    }

    public void setAssignedOrder(Order assignedOrder) {
        this.assignedOrder = assignedOrder;
    }

    @ManyToOne
    @JoinColumn(name="fk_productId")
    @XmlTransient
    public Product getAssignedProduct() {
        return assignedProduct;
    }

    public void setAssignedProduct(Product assignedProduct) {
        this.assignedProduct = assignedProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
                Objects.equals(assignedOrder, orderItem.assignedOrder) &&
                Objects.equals(assignedProduct, orderItem.assignedProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignedOrder, assignedProduct, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "assignedOrder=" + assignedOrder +
                ", assignedProduct=" + assignedProduct +
                ", quantity=" + quantity +
                '}';
    }
}
