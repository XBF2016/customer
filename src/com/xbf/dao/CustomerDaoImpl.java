package com.xbf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xbf.domain.Customer;
import com.xbf.domain.PageCustomer;
import com.xbf.util.ObjectFactory;

public class CustomerDaoImpl implements CustomerDao {

	public void add(Customer customer) throws SQLException {
		// 使用dbutils进行数据库操作，首先创建Handler,它需要操作的数据的被封装类型
		BeanHandler<Customer> handler = new BeanHandler<Customer>(
				Customer.class);
		// 然后是QueryRunner，它进行操作，需要一个数据库连接池，由工厂类创建
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		// 操作，需要有sql语句，handler和要插入的数据
		queryRunner
				.insert(
						"insert into customer (name,gender,birthday,phone,email,hobbies,type,address,description) values(?,?,?,?,?,?,?,?,?)",
						handler, customer.getName(), customer.getGender(),
						customer.getBirthday(), customer.getPhone(), customer
								.getEmail(), customer.getHobbies(), customer
								.getType(), customer.getAddress(), customer
								.getDescription());

	}

	public List<Customer> list() throws SQLException {
		// 使用dbutils进行数据库操作，首先创建Handler,它需要操作的数据的被封装类型
		BeanListHandler<Customer> handler = new BeanListHandler<Customer>(
				Customer.class);
		// 然后是QueryRunner，它进行操作，需要一个数据库连接池，由工厂类创建
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		List<Customer> customerList = queryRunner.query(
				"select * from customer", handler);
		return customerList;
	}

	public void deleteById(int id) throws SQLException {
		// 删除操作不需要Handler
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		queryRunner.update("delete from customer where id=?", id);
	}

	public Customer findById(int id) throws SQLException {
		// 使用dbutils进行数据库操作，首先创建Handler,它需要操作的数据的被封装类型
		BeanHandler<Customer> handler = new BeanHandler<Customer>(
				Customer.class);
		// 然后是QueryRunner，它进行操作，需要一个数据库连接池，由工厂类创建
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		// 查找,将数据封装为Customer对象
		Customer customer = queryRunner.query(
				"select * from customer where id=?", handler, id);
		return customer;
	}

	public void update(Customer customer) throws SQLException {
		// 使用dbutils进行数据库操作，首先创建Handler,它需要操作的数据的被封装类型
		BeanHandler<Customer> handler = new BeanHandler<Customer>(
				Customer.class);
		// 然后是QueryRunner，它进行操作，需要一个数据库连接池，由工厂类创建
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		// 操作，需要有sql语句，handler和要插入的数据
		queryRunner
				.update(
						"update customer set name=?,gender=?,birthday=?,phone=?,email=?,hobbies=?,type=?,address=?,description=? where id=?",
						customer.getName(), customer.getGender(), customer
								.getBirthday(), customer.getPhone(), customer
								.getEmail(), customer.getHobbies(), customer
								.getType(), customer.getAddress(), customer
								.getDescription(), customer.getId());
	}

	public PageCustomer page(PageCustomer pageCustomer) throws SQLException {
		// 使用dbutils进行数据库操作，首先创建Handler,它需要操作的数据的被封装类型
		BeanListHandler<Customer> handler = new BeanListHandler<Customer>(
				Customer.class);
		// 然后是QueryRunner，它进行操作，需要一个数据库连接池，由工厂类创建
		QueryRunner queryRunner = new QueryRunner(ObjectFactory.getDataSource());
		// 执行分页查询,MySQL数据库实现分页比较简单，提供了LIMIT函数。一般只需要直接写到sql语句后面就行了。
		// LIMIT子句可以用来限制由SELECT语句返回过来的数据数量，它有一个或两个参数，如果给出两个参数，
		// 第一个参数指定返回的第一行在所有数据中的位置，从0开始（注意不是1），第二个参数指定最多返回行数
		int begin = (pageCustomer.getPageIndex() - 1)
				* pageCustomer.getPageSize();
		List<Customer> customerList = queryRunner.query(
				"select * from customer limit ?,?", handler, begin,
				pageCustomer.getPageSize());
		System.out.println(customerList);
		// 将查询结果存入pageCustomer中
		pageCustomer.setCustomerList(customerList);
		// 获取总数据量
		long totalSize = queryRunner.query("select count(*) from customer ",
				new ScalarHandler<Long>());
		// 存入pageCustomer中
		pageCustomer.setTotalSize((int) totalSize);
		// 获取总页数
		int totalPage = (int) ((totalSize + (pageCustomer.getPageSize() - 1)) / pageCustomer
				.getPageSize());

		pageCustomer.setTotalPage(totalPage);

		return pageCustomer;
	}
}
