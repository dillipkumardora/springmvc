package com.niit.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.model.Category;




@Controller
public class CategoryController {


	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ModelAndView listCategories() {
		ModelAndView modelAndView = new ModelAndView("helloAdmin");
		modelAndView.addObject("category", new Category());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		modelAndView.addObject("isCategoryPage", true);
		return modelAndView;
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {

		categoryDAO.saveOrUpdate(category);

		return "redirect:/categories";

	}

	@RequestMapping("category/remove/{categoryId}")
	public String removeCategory(@PathVariable("categoryId") String categoryId, ModelMap model) throws Exception {
		try {
			categoryDAO.delete(categoryId);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/Categories";
	}

	@RequestMapping("category/edit/{categoryId}")
    public String editCategory(@PathVariable("categoryId") String categoryId, Model model){
    	System.out.println("editCategory");
        model.addAttribute("category", this.categoryDAO.get(categoryId));
        model.addAttribute("listCategorys", this.categoryDAO.list());
        model.addAttribute("isCategoryClicked", true);
        return "helloAdmin";
    }
	
	@RequestMapping("/onLoad")
	public String getCategoryMenu(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "home";
	}
	
}
