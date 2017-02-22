package com.excilys.formation.fconsigny.computerdb.storage.model;

public class ComputerRemote {

	int id; 
	String name; 
	int company_id; 
	
	public ComputerRemote(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name; 
	}
	
	public void setCompanyId(int id){
		this.company_id = id;
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
