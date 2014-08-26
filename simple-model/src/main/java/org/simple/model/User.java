package org.simple.model;

import java.util.ArrayList;
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
	private List<Manager> managers;
	private String experience;
	private List<Language> languages;
	private boolean admin;
	
	public User(String email,String name,String company,String jobTitle){
		this.email=email;
		this.name=name;
		this.company=company;
		this.jobTitle=jobTitle;
		this.languages=new ArrayList<Language>();
		this.managers=new ArrayList<Manager>();
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

	public List<Manager>getManager() {
		return managers;
	}

	public void setManager(List<Manager> managers) {
		this.managers = managers;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public List<Language> getLanguage() {
		return languages;
	}

	public void setLanguage(List<Language> languages) {
		this.languages = languages;
	}
	
	public void addLanguage(Language language){
		this.languages.add(language);
	}
	
	public void addManager(Manager manager){
		this.managers.add(manager);
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
}
