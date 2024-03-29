package com.fashion.controller.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.model.Cart;
import com.fashion.model.CartItem;
import com.fashion.model.User;
import com.fashion.service.CartItemService;
import com.fashion.service.CartService;
import com.fashion.service.UserService;
import com.fashion.service.impl.CartItemServiceImpl;
import com.fashion.service.impl.CartServiceImpl;
import com.fashion.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/addOrder" })
public class AddOrderController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();
	long time = System.currentTimeMillis();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");

		User buyer = (User) obj;
		//tao don hang cho nguoi mua
		Cart cart = new Cart();
		cart.setBuyer(buyer);
		cart.setBuyDate(new java.sql.Date(time));
		// luu xuong database
		cartService.insert(cart);

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
		Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

		for(Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem cartItem = entry.getValue();	
			List<Cart> listc = cartService.getAll();
			Cart cart1= new Cart();
			cart1= listc.get(listc.size()-1);
			cartItem.setCart(cart1);
			cartItemService.insert(cartItem);
		}

		}
		session.removeAttribute("cart");
		//super.dispatcher(req, resp, "/admin/user/dashboard");
		resp.sendRedirect("/Fashion/home");
		
	}
	
}
