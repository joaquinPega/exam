package org.simple.model;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;

import java.io.Serializable;


/** Model of the class user
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
@SessionScoped
@Default
public class User implements Serializable, Comparable<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String company;
	private String jobTitle;
	private String email;
	private String password;
	private Manager manager;
	private String experience;
	private Language language;
	private boolean admin;
	private long id;
	
	public User() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int compareTo(User arg0) {
		
		return name.compareTo(arg0.name);
	}

	
}
