package com.xbf.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xbf.dao.CustomerDao;
import com.xbf.dao.CustomerDaoImpl;
import com.xbf.service.CustomerService;

//对象工厂类，用于统一创建所需对象
public class ObjectFactory {
	// 数据库连接池
	private static DataSource dataSource;
	// 业务处理
	private static CustomerService customerService;
	// 数据处理
	private static CustomerDao customerDao;

	// 静态代码块，在类被加载时就执行此部分代码
	static {
		// 使用c3p0创建数据库连接池
		dataSource = new ComboPooledDataSource();
		customerService = new CustomerService();
		customerDao = new CustomerDaoImpl();

	}

	public static synchronized CustomerService getCustomerService() {
		return customerService;
	}

	public static synchronized CustomerDao getCustomerDao() {
		return customerDao;
	}

	public static synchronized DataSource getDataSource() {
		return dataSource;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(dataSource.getConnection());

	}
}
