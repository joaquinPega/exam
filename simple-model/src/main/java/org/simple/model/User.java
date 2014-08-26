package org.simple.model;

import java.util.List;


/**
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com)
 *
 */
public class User {
	
	private String name;
	private String company;
	private String jobTitle;
	private String email;
	private String password;
	private List<Manager> managers;
	private String experience;
	private List<Language> languages;
	private boolean admin;
	
	public User(){
		
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


	public List<Manager> getManagers() {
		return managers;
	}


	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}


	public List<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}




	
	
}
