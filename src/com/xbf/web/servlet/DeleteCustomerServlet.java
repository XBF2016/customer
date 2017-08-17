package com.xbf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbf.util.ObjectFactory;

public class DeleteCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取id
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			// 调用service的删除方法
			ObjectFactory.getCustomerService().deleteById(id);
			// 删除成功则跳转到客户列表页面
			request.getRequestDispatcher("/ListCustomerServlet").forward(
					request, response);
		} catch (SQLException e) {
			response.getWriter().print("删除失败" + e.getMessage());
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
