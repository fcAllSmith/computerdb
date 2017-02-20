package com.excilys.formation.fconsigny.computerdb.presentation.modele;

public class CompanyEntity {
	int id; 
	String name;

	public CompanyEntity(int id, String name){
		this.id = id;
		this.name = name; 
	}
	
	@Override
	public String toString(){
		return "Id : " + id + " Name : " + name;
	}
}
