package org.simple.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com)
 *
 */
public class Manager {
	private String name;
	private List<User> users;
	public Manager(String name) {
		super();
		this.name = name;
		this.users = new ArrayList<User>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void addUser(User user){
		this.users.add(user);
	}
	
}
