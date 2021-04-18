package com.k.pojo;


public class User {
  private int ID;
  private int count;
  private String userpassword;
  private String username;
 

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(int iD, int count, String userpassword, String username) {
	super();
	ID = iD;
	this.count = count;
	this.userpassword = userpassword;
	this.username = username;
}

public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
  
  
}
