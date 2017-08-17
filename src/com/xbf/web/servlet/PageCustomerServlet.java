package com.xbf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbf.domain.PageCustomer;
import com.xbf.util.ObjectFactory;

public class PageCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");

		// 先设置一些默认值
		int pageSize = 10;
		int pageIndex = 1;

		// 获取两个必要参数
		String pageIndexString = request.getParameter("pageIndex");
		String pageSizeString = request.getParameter("pageSize");

		// 为了程序的健壮性，容错性
		try {
			pageIndex = Integer.parseInt(pageIndexString);
		} catch (Exception e) {
		}

		try {
			pageSize = Integer.parseInt(pageSizeString);
		} catch (Exception e) {
		}

		try {
			// 调用service的方法进行物理分页查询，同时将相关分页信息（封装在PageCustomer中）传入
			PageCustomer pageCustomer = new PageCustomer(pageSize, pageIndex);
			pageCustomer = ObjectFactory.getCustomerService()
					.page(pageCustomer);
			// 成功之后将返回的PageCustomer和customerList放入web域中，并跳转到相关展示页面
			request.setAttribute("pageCustomer", pageCustomer);
			request
					.setAttribute("customerList", pageCustomer
							.getCustomerList());
			request.getRequestDispatcher("/pageCustomer.jsp").forward(request,
					response);
		} catch (SQLException e) {
			response.getWriter().print("查询分页出错" + e.getMessage());
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
