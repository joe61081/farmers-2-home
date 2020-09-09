package com.mastek.farmers2home.customer;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    int customerId;
    String customerName;
    String customerAddress;
    String customerContact;
 
   
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                '}';
    }
}
