package com.excilys.formation.fconsigny.computerdb.app.entity;

public class CompanyEntity {
	
	private int id; 
	private String name;

	public CompanyEntity(int id, String name){
		this.id = id;
		this.name = name; 
	}
	
	@Override
	public String toString(){
		return "Id : " + id + " Name : " + name;
	}
}
