package com.niit.ecommerce.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.model.Category;
import com.niit.ecommerce.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		Supplier supplier = (Supplier) context.getBean("supplier");

		supplier.setId("SUP24");

		supplier.setName("SUPName24");
		supplier.setAddress("Kolkata");
		System.out.println(supplier.getId());

		supplierDAO.saveOrUpdate(supplier);
		System.out.println("s3");

		System.out.println("Supllier saved successfully");

	}

}