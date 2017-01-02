package com.niit.ecommerce.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.model.Category;
import com.niit.ecommerce.model.Product;
import com.niit.ecommerce.model.Supplier;
import com.niit.ecommerce.model.User;

@Controller
public class UserController {

	@Autowired
		UserDAO UserDAO;

	@Autowired
	User User;

	private Object categoryDAO;

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView printWelcome(Principal principal, HttpServletRequest request) {
	ModelAndView mv;
	String name = principal.getName();
	System.out.println(name);
	if (request.isUserInRole("ROLE_ADMIN")) {
	System.out.println(request.isUserInRole("ROLE_ADMIN"));
	System.out.println("Admin page");
	mv=new ModelAndView("helloAdmin");
	mv.addObject("isAdminpage", true);
	mv.addObject("username", name);
	return mv;
	}
	else {
	System.out.println(request.isUserInRole("ROLE_USER"));
	System.out.println("user page");
	mv=new ModelAndView("helloUser");
	mv.addObject("username", name);
	//mv.addObject("category", new Category());
	//mv.addObject("categoryList", ((CategoryDAO) this.categoryDAO).list());
	//mv.addObject("isUserHome", true);
	return mv;
	}
	}

	@RequestMapping("/registeruser")
		public ModelAndView registerUser(@RequestParam("password") String password,
				@RequestParam("repassword") String repassword, @RequestParam("name") String name,
				@RequestParam("id") String id, @RequestParam("email") String email,
				@RequestParam("mobile") String mobile) {
			ModelAndView mv;
			String message = null;
			if (password.equals(repassword)) {
				
				User.setId(id);
				User.setPassword(password);
				User.setName(name);
				User.setEmail(email);
				User.setMobile(mobile);
				if (id.contains("bharat23")) {
					User.setEnabled(true);
					User.setRole("ROLE_ADMIN");
				} else {
					User.setEnabled(true);
					User.setRole("ROLE_USER");
				}
				UserDAO.saveOrUpdate(User);
				message="Login to continue";
				mv = new ModelAndView("login");
			} else {
				message = "Passwords does not match";
				mv = new ModelAndView("login");
			}
			mv.addObject("message", message);
			return mv;
		}


}
