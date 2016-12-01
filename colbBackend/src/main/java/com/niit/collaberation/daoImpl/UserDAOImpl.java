package com.niit.collaberation.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaberation.dao.UserDAO;
import com.niit.collaberation.model.User;

@Repository(value="UserDAO")
public class UserDAOImpl implements UserDAO {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	User user;
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		try
		{
			this.sessionFactory=sessionFactory;
		}
		catch(Exception e)
		{
			 log.error("unable to connect db");
			e.printStackTrace();
		}
	}

	@Transactional
	public List<User> list() {
	log.debug("starting of message list");
	String hql ="from User";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
	
	
	@Transactional
	public boolean save(User user) {
		log.debug("Starting The Method of save");
    	try{
    		sessionFactory.getCurrentSession().save(user);
    	    return true;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
	}
	@Transactional
    public boolean update(User user) {
    	log.debug("Starting The Method Update");
    	try{
    		sessionFactory.getCurrentSession().update(user);
    	    return true;
    	}catch(HibernateException e){
    		e.printStackTrace();
    		return false;
    	}
    	
	}
	
	@Transactional
	public User get(String Id) {
		log.debug("staring the method of get with the id:"+Id);
		user= (User)sessionFactory.getCurrentSession().get(User.class,Id);
		log.debug("user:"+user);
    		return user;
    		

	}

	@Transactional
	public User isValidUser(String Id, String password) {
		log.debug("starting the method isvaliduserdetails");
		String hql="from User where Id= '"+Id+"' and "+" password= '"+password+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("endinging the method isvaliduserdetails");
		return (User)query.uniqueResult();
	
	}
	
}