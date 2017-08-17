package com.xbf.dao;

import java.sql.SQLException;
import java.util.List;

import com.xbf.domain.Customer;
import com.xbf.domain.PageCustomer;

public interface CustomerDao {

	void add(Customer customer) throws SQLException;

	List<Customer> list() throws SQLException;

	void deleteById(int id) throws SQLException;

	Customer findById(int id) throws SQLException;

	void update(Customer customer) throws SQLException;

	PageCustomer page(PageCustomer pageCustomer) throws SQLException;

}
