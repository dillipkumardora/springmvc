package com.niit.ecommerce.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.model.User;
public class UserTest {

	

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		UserDAO UserDAO = (UserDAO) context.getBean("UserDAO");

		User user = (User) context.getBean("user");

		user.setId("bharat23");
		System.out.println("u1");

		user.setName("Saroj Kumar Mallick");
		System.out.println("u2");

		user.setPassword("12345");
		System.out.println("u3");

		user.setRepassword("12345");

		user.setMobile("9040822365");
		System.out.println("u4");

		user.setEmail("bharat23@gmail.com");
		System.out.println("u5");
		
		user.setRole("ROLE_ADMIN");
		
		System.out.println(user.getId());
		System.out.println("u7");

		UserDAO.saveOrUpdate(user);
		System.out.println("u8");

		System.out.println("User saved");
	}
}
