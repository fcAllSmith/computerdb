package com.excilys.formation.fconsigny.computerdb.business.model;

public class Computer {
	int id;
	String name; 
	int company_id;
	
	public Computer(int id, String name, int company_id){
		this.id = id; 
		this.name = name; 
		this.company_id = company_id; 
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCompanyId(){
		return this.company_id;
	}
}
