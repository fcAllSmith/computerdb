package com.excilys.formation.fconsigny.computerdb.business.model;

public class Company {

	int id; 
	String name; 
	
	public Company(int id, String name){
		this.id = id; 
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
