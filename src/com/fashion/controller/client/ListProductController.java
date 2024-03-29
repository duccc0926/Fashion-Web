package com.fashion.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.model.Category;
import com.fashion.model.Product;
import com.fashion.model.User;
import com.fashion.service.CategoryService;
import com.fashion.service.ProductService;
import com.fashion.service.impl.CategoryServiceImpl;
import com.fashion.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/shop" })
public class ListProductController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Product> productes = productService.getAll();
		req.setAttribute("productes", productes);
		
		List<Category> categories = categoryService.getAll();
		req.setAttribute("categories", categories);		HttpSession httpSession = req.getSession();
		Object userObject = httpSession.getAttribute("user");
		if(userObject!=null) {
			User user = (User) userObject;
			req.setAttribute("user", user);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/listproduct.jsp");
		dispatcher.forward(req, resp);
	}

}
