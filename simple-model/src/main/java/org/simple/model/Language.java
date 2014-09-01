package org.simple.model;
/**
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com)
 *
 */
public class Language {
	private String name;
	private long id;
	
	public Language(){
		
	}
	public Language(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
