package com.xbf.domain;

import java.util.List;

public class PageCustomer {
	// 存储关于分页的所有数据
	// 每页客户数量
	private int pageSize;
	// 全部客户数量
	private int totalSize;
	// 当前页面索引
	private int pageIndex;
	// 全部页面数量
	private int totalPage;

	// 物理分页查询到的结果
	private List<Customer> customerList;

	public synchronized List<Customer> getCustomerList() {
		return customerList;
	}

	public synchronized void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public PageCustomer(int pageSize, int pageIndex) {
		if (pageIndex < 1) {
			this.pageIndex = 1;
		}
		this.pageIndex = pageIndex;
		if (pageSize < 1) {
			this.pageSize = 1;
		}
		this.pageSize = pageSize;

	}

	public synchronized int getPageSize() {
		return pageSize;
	}

	public synchronized void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public synchronized int getTotalSize() {
		return totalSize;
	}

	public synchronized void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public synchronized int getPageIndex() {
		return pageIndex;
	}

	public synchronized void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public synchronized int getTotalPage() {
		return totalPage;
	}

	public synchronized void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
