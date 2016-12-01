package com.niit.collaberation.restfullControllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import com.niit.collaberation.dao.UserDAO;
import com.niit.collaberation.daoImpl.UserDAOImpl;
import com.niit.collaberation.model.User;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/tusers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers()
	{
		
		log.debug("Starting of method getAllUsers ");
		List<User> users = userDAO.list();
		if (users.isEmpty()) 
		{
			user.setErrorCode("404");
			user.setErrorMessage("No User are Available");

		}
		log.debug("Ending of method getAllUsers ");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/tuser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserDetails(@PathVariable("id") String id) 
	{
		
		log.debug("Starting of method getUserDetails");
		
		user=userDAO.get(id);
		if (user == null)
		{
			 user=new User();
			user.setErrorCode("404");
			user.setErrorMessage("user doesnt exist with this id:" + id);

		}

		log.debug("ending of method getUserDetails");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/validate/", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
		
		log.debug("Starting of method login ");
		user=userDAO.isValidUser(user.getId(), user.getPassword());
		if (user == null) 
		{
			user=new User();
			user.setErrorCode("404");
			user.setErrorMessage("user doesnt exist with this id:" + user.getId());

		}

		else
		{
			user.setIsonline('Y');
			userDAO.update(user);
			session.setAttribute("loggedInUserID", user.getId());
		}

		log.debug("Ending of method login ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public ResponseEntity<User> logout(HttpSession session) 
	{
		log.debug("Starting of method logout ");
		user.setIsonline('N');
		
		session.invalidate();

		if (userDAO.update(user))
		{
			user.setErrorCode("200");
			user.setErrorMessage("you have logge out successfully");
		}
		else 
		{
			user.setErrorCode("404");
			user.setErrorMessage("you couldnot logge out successfully plz contact admin");

		}
		
		log.debug("Ending of method logout ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		log.debug("Starting of method register ");
		if (userDAO.get(user.getId()) != null) 
		{
			user.setErrorCode("404");
			user.setErrorMessage("with this id, the record is already exist, plz choose another id");
		} 
		else 
		{
			if (userDAO.save(user)) 
			{
				user.setErrorCode("200");
				user.setErrorMessage("Registered Successfully");
			}
			else
			{
				user.setErrorCode("404");
				user.setErrorMessage("Unable to process Your Registration pllz contact  admin");
			}
		}
		
		log.debug("Ending of method register ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accept/{Id}", method = RequestMethod.GET)
	public ResponseEntity<User> accept(@PathParam("Id") String Id)
	{
		log.debug("Starting of method accept ");
		
		user=updateStatus(Id,'A',"");
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/reject/{Id}/{reason}", method = RequestMethod.GET)
	public ResponseEntity<User> reject(@PathParam("Id") String Id,@PathParam("reason") String reason)
	{
		user=updateStatus(Id,'R',reason);
		return new ResponseEntity<User>(user, HttpStatus.OK);

		
	}
	
	private User updateStatus(String Id, char status, String reason)
	{

		user=userDAO.get(Id);
		
		if(user==null)
		{
			user=new User();
			user.setErrorCode("404");
			user.setErrorMessage("Couldnot Update The Status");
		}
		else
		{
			user.setStatus(status);
			user.setReason(reason);
		}
		return user;
	}
}
