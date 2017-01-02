package com.niit.ecommerce.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.model.Category;
import com.niit.ecommerce.model.Product;
import com.niit.ecommerce.model.Supplier;



@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Product product;
	
	private Path path;
	
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("isProductPage", true);
		return "helloAdmin";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,HttpSession session) {

		Category category = categoryDAO.getByName(product.getCategory().getName());
		categoryDAO.saveOrUpdate(category);

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
		supplierDAO.saveOrUpdate(supplier);

		product.setCategory(category);
		product.setSupplier(supplier);

		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());

	

		productDAO.saveOrUpdate(product);

		return "redirect:/products";

	}

	@RequestMapping("product/remove/{ProductId}")
	public String removeProduct(@PathVariable("ProductId") String ProductId, ModelMap model) throws Exception {

		try {
			productDAO.delete(ProductId);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/products";
	}

	@RequestMapping("product/edit/{ProductId}")
	public String editProduct(@PathVariable("ProductId") String ProductId, Model model) {
		System.out.println("editproduct");
		model.addAttribute("product", this.productDAO.get(ProductId));
		model.addAttribute("listProducts", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("isProductClicked", true);
		return "helloAdmin";
	}

	@RequestMapping("product/get/{ProductId}")
	public String getSelectedProduct(@PathVariable("ProductId") String productId, Principal principal, Model model) {
		String name = principal.getName();
		model.addAttribute("username", name);
		product = productDAO.get(productId);
		return "redirect:/helloUser";
	}

	

	
	
}
