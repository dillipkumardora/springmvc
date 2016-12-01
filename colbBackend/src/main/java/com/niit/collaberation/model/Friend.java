package com.niit.collaberation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="FRIEND")
@Component
public class Friend  extends BaseDomain{

@Id
private int id; //primary
@Column(name="user_id")
private String userId;
@Column(name="friend_id")
private String friendId; 

private String status;

@Column(name="isonline")
private char isonline;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getFriendId() {
	return friendId;
}

public void setFriendId(String friendId) {
	this.friendId = friendId;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public char getIsonline() {
	return isonline;
}

public void setIsonline(char isonline) {
	this.isonline = isonline;
}
	
}
