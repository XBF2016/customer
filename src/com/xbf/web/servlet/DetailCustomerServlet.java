package com.xbf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbf.domain.Customer;
import com.xbf.util.ObjectFactory;

public class DetailCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");

		try {
			// 获取id，调用service的方法查询客户信息
			int id = Integer.parseInt(request.getParameter("id"));
			Customer customer;
			customer = ObjectFactory.getCustomerService().findById(id);
			// 查询成功，将Customer对象放入web域中，并跳转
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/detailCustomer.jsp").forward(
					request, response);
		} catch (SQLException e) {
			response.getWriter().print("获取客户信息失败" + e.getMessage());
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
