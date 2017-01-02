package com.niit.ecommerce.test;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.model.Category;

public class CategoryTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");

		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		Category category = (Category) context.getBean("category");

		category.setId("CG006");

		category.setName("CGName005");

		category.setDescription("This is Category5");
		System.out.println(category.getId());

		categoryDAO.saveOrUpdate(category);
		System.out.println("c9");
		System.out.println("Category saved successfully");

	

	}

}
