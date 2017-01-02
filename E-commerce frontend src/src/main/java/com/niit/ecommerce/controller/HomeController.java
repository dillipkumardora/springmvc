package com.niit.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.model.User;





@Controller
public class HomeController {
	
	
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	
	@RequestMapping("/")
	public ModelAndView showlandingpage() {

		
		ModelAndView mv = new ModelAndView("home");
		return mv;
		
	}
	
	@RequestMapping("/login")
	public String getLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("logout", "You have been logged out successfully.");
		}
		//model.addAttribute("category", new Category());
		//model.addAttribute("categoryList", this.categoryDAO.list());
		return "login";

	}
	
	@RequestMapping("/register")
	public ModelAndView showregisterpage() {

		
		ModelAndView mv = new ModelAndView("register");
		return mv;
		
	}

	@RequestMapping("/contact")
	public ModelAndView showcontactpage() {

		
		ModelAndView mv = new ModelAndView("contact");
		return mv;
	}
	
	@RequestMapping("/shop")
	public ModelAndView showshoppage() {

		ModelAndView mv = new ModelAndView("shop");
		return mv;
	}
	@RequestMapping("/error")
	public ModelAndView showerrorpage() {

		
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}
	
	@RequestMapping("/checkout")
	public ModelAndView showcheckoutpage() {

		
		ModelAndView mv = new ModelAndView("checkout");
		return mv;
	}
	@RequestMapping("/single")
	public ModelAndView showsinglepage() {

		
		ModelAndView mv = new ModelAndView("single");
		return mv;
	}


}
