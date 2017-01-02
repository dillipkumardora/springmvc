package com.niit.ecommerce.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.model.Product;

public class ProductTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");

		context.refresh();

		
		 ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		 
		 Product product = (Product) context.getBean("product");
		  
		 product.setId("PR004");
		 
		  product.setName("Samsung");
		  
		  product.setCategory_id("CG006");
		  
		  product.setSupplier_id("SUP24");
		  
		 product.setDescription("This is Samsung S4");
		  
		  
		  
		  System.out.println(product.getId());
		 
		  productDAO.saveOrUpdate(product);
		
		  System.out.println("Product saved successfully");
		 

		
	}

}