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

import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.model.Supplier;



@Controller
public class SupplierController {


	@Autowired
	 SupplierDAO supplierDAO;
	
	

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public ModelAndView listSuppliers()
	{
		ModelAndView mav=new ModelAndView("helloAdmin");
		mav.addObject("supplier", new Supplier());
		mav.addObject("supplierList", this.supplierDAO.list());
		mav.addObject("isSupplierPage", true);
		return mav;
		

	}
	
	//For add and update product both
		@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
		public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {

			/*Util util = new Util();
			String id=  util.replace(category.getId(), ",", "");
			category.setName(id);*/
			
			supplierDAO.saveOrUpdate(supplier);

			return "redirect:/suppliers";
			//return "categories";

		}
		
		@RequestMapping("supplier/remove/{SupplierId}")
		public String removeSupplier(@PathVariable("SupplierId") String SupplierId, ModelMap model) throws Exception {

			try {
				supplierDAO.delete(SupplierId);
				model.addAttribute("message", "Successfully Added");
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				e.printStackTrace();
			}
			// redirectAttrs.addFlashAttribute(arg0, arg1)
			return "redirect:/suppliers";
		}

		@RequestMapping("supplier/edit/{SupplierId}")
		public String editCategory(@PathVariable("SupplierId") String SupplierId, Model model) {
			System.out.println("editSupplier");
			model.addAttribute("supplier", this.supplierDAO.get(SupplierId));
			model.addAttribute("listSuppliers", this.supplierDAO.list());
			  model.addAttribute("isSupplierClicked", true);
			return "helloAdmin";
			//return "redirect:/suppliers";
		}
	
}
