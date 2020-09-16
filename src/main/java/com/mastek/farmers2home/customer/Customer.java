package com.mastek.farmers2home.customer;

import com.mastek.farmers2home.order.Order;

import javax.persistence.*;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {

    private int customerId;

    @QueryParam("email")
    private String emailAddress;
    @QueryParam("pass")
    private String password;
    @QueryParam("name")
    private String customerName;
    @QueryParam("address")
    private String customerAddress;
    @QueryParam("contact")
    private String customerContact;

    private Set<Order> orders = new HashSet<>();

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerAssigned")
    @XmlTransient
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", emailAddress='" + emailAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", orders=" + orders +
                '}';
    }
}
