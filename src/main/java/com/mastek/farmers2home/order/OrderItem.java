package com.mastek.farmers2home.order;

import com.mastek.farmers2home.product.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

public class OrderItem {

    private Order assignedOrder;
    private Product assignedProduct;
    private int quantity;

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
