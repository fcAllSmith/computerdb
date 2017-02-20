package com.excilys.formation.fconsigny.computerdb.storage.model;

public class CompanyRemote {
	
	private int id; 
	private String name; 
	
	public CompanyRemote(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		if(name == null){
			new IllegalArgumentException("Parmam *name* can't be null");
		}else{
			this.name = name; 
		}
	}
	
	public String getName(){
		return this.name; 
	}
}
