package com.xbf.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xbf.domain.Customer;
import com.xbf.util.ObjectFactory;

public class UpdateCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// 2.获取jsp页面的数据，并封装成customer对象
			Customer customer = new Customer();
			// 使用BeanUtils进行简便封装
			BeanUtils.populate(customer, request.getParameterMap());
			// 获取多选框的string数组数据
			String[] temp = request.getParameterValues("hobbies");
			if (temp != null && temp.length > 0) {
				String hobbiesStr = Arrays.toString(temp);
				customer.setHobbies(hobbiesStr.substring(1,
						hobbiesStr.length() - 1));
			}

			// 3.调用service的update方法执行修改客户业务
			ObjectFactory.getCustomerService().update(customer);

			// 4.执行成功，跳转到客户列表页面
			request.getRequestDispatcher("/ListCustomerServlet").forward(
					request, response);
		} catch (Exception e) {
			response.getWriter().print("修改客户出错" + e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
