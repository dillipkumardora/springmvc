package com.niit.collaberation.dao;

import java.util.List;

import com.niit.collaberation.model.User;

public interface UserDAO {

	 public  List<User> list() ;
		
		public  User get(String Id) ;
		
		public boolean save(User user);
		
		public boolean update(User user);

		public User isValidUser(String Id, String password);
		
}
