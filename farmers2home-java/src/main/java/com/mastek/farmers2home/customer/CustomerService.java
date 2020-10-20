
package com.mastek.farmers2home.customer;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.farmers2home.order.Order;

@Component
public class CustomerService implements CustomerAPI {

    @Autowired
    CustomerJPADAO customerDao;

    @Override
	public Customer addCustomer(Customer newCustomer) {
        customerDao.save(newCustomer);
        return newCustomer;
    }

    @Override
	public Customer getCustomerLogin(String email, String password) {
		return customerDao.findCustomerLogin(email, password);
    }

    @Override
	public Set<Order> getCustomerOrders(int custId){
        Customer customer = customerDao.findById(custId).get();
        return customer.getOrders();
    }

	@Override
	public Customer findCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.findById(customerId).get();
	}

}

