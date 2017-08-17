package com.xbf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbf.domain.Customer;
import com.xbf.util.ObjectFactory;

public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// 调用service的方法，返回List对象
			List<Customer> customerList = ObjectFactory.getCustomerService()
					.list();
			// 将List对象存入web域中
			request.setAttribute("customerList", customerList);
			// 跳转到listCustomer页面
			request.getRequestDispatcher("/listCustomer.jsp").forward(request,
					response);

		} catch (SQLException e) {
			response.getWriter().print("查询出错" + e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
