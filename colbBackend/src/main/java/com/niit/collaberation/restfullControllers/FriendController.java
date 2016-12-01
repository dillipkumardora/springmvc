package com.niit.collaberation.restfullControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaberation.dao.FriendDAO;
import com.niit.collaberation.model.Friend;


@RestController
public class FriendController {

	private static final Logger log =LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	Friend friend;
	
	@RequestMapping(value="/myfriends" , method=RequestMethod.GET)
	public ResponseEntity<List <Friend> > getMyFriends(HttpSession session)
	{
		log.debug("calling the method getMyfriends");
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		
		log.debug("get the friends of:" +loggedInUserId);
		List<Friend> myfriends =friendDAO.getMyFriends(loggedInUserId);
		if(myfriends.isEmpty())
		{
			log.debug("Friends doesnot exist for this user:" +loggedInUserId);
			friend.setErrorCode("404");
			friend.setErrorMessage("I have no friends");
			myfriends.add(friend);
			
		}
		log.debug("Send The Friend List");
		
		return new ResponseEntity<List<Friend>>(myfriends , HttpStatus.OK);
	}
	
	@RequestMapping(value="/addfriend/{friendId}" , method=RequestMethod.GET)
	public ResponseEntity<Friend>  sendFriendRequest(@PathVariable("friendId") String friendId ,HttpSession session)
	{
		log.debug("call the method sendfriendrequest");
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserId);
		friend.setFriendId(friendId);
		friend.setStatus("N");
		friendDAO.save(friend);
		
		
		return new ResponseEntity<Friend>(friend , HttpStatus.OK);
		
	}
	
	private void updateRequest(String friendId, String status, HttpSession session)
	{
		String loggedInUserId =(String) session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserId);
		friend.setFriendId(friendId);
		friend.setStatus("R");
		friendDAO.update(friend);
	}
	
	@RequestMapping(value="/unfriend/{friendId}" , method=RequestMethod.GET)
	public ResponseEntity<Friend>  unFriend(@PathVariable("friendId") String friendId ,HttpSession session)
	{
		log.debug("call the method unfriend");
		updateRequest(friendId, "U", session);
		
		return new ResponseEntity<Friend>(friend ,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/rejectfriend/{friendId}" , method=RequestMethod.GET)
	public ResponseEntity<Friend>  rejectFriend(@PathVariable("friendId") String friendId ,HttpSession session)
	{
		log.debug("call the method rejectfriend");
		updateRequest(friendId, "R", session);
		
		return new ResponseEntity<Friend>(friend ,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/accepctfriend/{friendId}" , method=RequestMethod.GET)
	public ResponseEntity<Friend>  acceptFriend(@PathVariable("friendId") String friendId ,HttpSession session)
	{
		log.debug("call the method acceptfriend");
		updateRequest(friendId, "A", session);
		
		return new ResponseEntity<Friend>(friend ,HttpStatus.OK);
		
	}
	 
	@RequestMapping(value="/friendrequest/{friendId}" , method=RequestMethod.GET)
	public ResponseEntity<List<Friend>>  getFriendRequest(HttpSession session)
	{
		log.debug("call the method friendrequest");
		String loggedInUserId =(String) session.getAttribute("loggedInUserId");
		List<Friend> friendRequest =friendDAO.getNewFriendRequest(loggedInUserId);
		
		return new ResponseEntity<List <Friend> >(friendRequest ,HttpStatus.OK);

	}
	
}

