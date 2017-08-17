package com.xbf.service;

import java.sql.SQLException;
import java.util.List;

import com.xbf.domain.Customer;
import com.xbf.domain.PageCustomer;
import com.xbf.util.ObjectFactory;

public class CustomerService {

	public void add(Customer customer) throws SQLException {
		ObjectFactory.getCustomerDao().add(customer);

	}

	public List<Customer> list() throws SQLException {
		return ObjectFactory.getCustomerDao().list();
	}

	public void deleteById(int id) throws SQLException {
		ObjectFactory.getCustomerDao().deleteById(id);
	}

	public Customer findById(int id) throws SQLException {
		return ObjectFactory.getCustomerDao().findById(id);
	}

	public void update(Customer customer) throws SQLException {
		ObjectFactory.getCustomerDao().update(customer);
	}

	public PageCustomer page(PageCustomer pageCustomer) throws SQLException {

		return ObjectFactory.getCustomerDao().page(pageCustomer);
	}

}
