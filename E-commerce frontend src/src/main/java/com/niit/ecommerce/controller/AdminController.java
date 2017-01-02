package com.niit.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/categories")
	public ModelAndView showcategorypage(){
		
		ModelAndView mv=new ModelAndView("helloAdmin");
		mv.addObject("InCategoryPage" , true);
		return mv;
	}
	@RequestMapping("/suppliers")
	public ModelAndView showsupplierspage(){
		
		ModelAndView mv=new ModelAndView("helloAdmin");
		mv.addObject("InSupplierPage" , true);
		return mv;
	}
	
	@RequestMapping("/products")
	public ModelAndView showproductspage(){
		
		ModelAndView mv=new ModelAndView("helloAdmin");
		mv.addObject("InProductPage" , true);
		return mv;
	}
	
}
