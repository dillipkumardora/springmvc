package com.niit.collaberation.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.collaberation.dao.FriendDAO;
import com.niit.collaberation.model.Friend;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO {

	private static final Logger log =LoggerFactory.getLogger(FriendDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
public FriendDAOImpl(SessionFactory sessionFactory) {
		
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
	
private Integer getMaxId()
{
	log.debug("Starting The Method of GetMAXId");
	String hql ="select max(Id} from friend";
	Query query =sessionFactory.openSession().createQuery(hql);
	Integer maxId=(Integer) query.uniqueResult();
	log.debug("Max id:" +maxId);
	return maxId;
}

@Transactional
	public List<Friend> getMyFriends(String userId)
	{
	  String hql ="from Friend where userId=" + "'" +userId+ "' and status='" + " A '";
	  Query query =sessionFactory.openSession().createQuery(hql);
	  
	  List<Friend> list =(List<Friend>) query.list();
	  
	  return list;
	
	}

@Transactional
public List<Friend> getNewFriendRequest(String userId)
{
	 String hql ="from Friend where userId=" + "'" +userId+ "' and status='" + " N '";
	  Query query =sessionFactory.openSession().createQuery(hql);
	  
	  List<Friend> list =(List<Friend>) query.list();
	  
	  return list;
	
}


@Transactional
	public Friend get(String userId, String friendId)
	{
	String hql ="from Friend where userId=" + "'" +userId+ "' and FriendId='" +friendId+ "'";
	log.debug("hql:" +hql);
	Query query=sessionFactory.openSession().createQuery(hql);
	
	return (Friend) query.uniqueResult();
		
	}



@Transactional
	public boolean save(Friend friend)
	{
		try
		{
			log.debug("past id" +getMaxId());
			friend.setId(getMaxId()+1);
			log.debug("present id" +getMaxId());
			sessionFactory.openSession().save(friend);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public boolean update(Friend friend) {
		
	try
	{
		sessionFactory.openSession().update(friend);
		return true;
	}
	catch(HibernateException e)
	{
		e.printStackTrace();
		return false;
	}
	
	}

@Transactional
public void delete(String userId, String friendId)
{

	Friend friend =new Friend();
	friend.setFriendId(friendId);
	friend.setUserId(userId);
	sessionFactory.openSession().delete(friend);
}

@Transactional
	public void setOnline(String userId)
	{
		log.debug("Statrting the method setonline");
		String hql="UPDATE Friend SET isOnline ='Y' where friendId'" +userId+ "'";
		log.debug("hql:" +hql);
		Query query=sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		
		
		log.debug("ending the method setonline");
	}

@Transactional
	public void setOffline(String userId)
	{
	log.debug("Statrting the method setonline");
	String hql="UPDATE Friend SET isOnline ='N' where friendId'" +userId+ "'";
	log.debug("hql:" +hql);
	Query query=sessionFactory.openSession().createQuery(hql);
	query.executeUpdate();
	
	
	log.debug("ending the method setonline");
		
	}

}
