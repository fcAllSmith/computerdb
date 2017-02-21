package com.excilys.formation.fconsigny.computerdb.presentation.modele;

public class ComputerEntity {
	
	private int id; 
	private String name; 
	private int company_id;
	
	public ComputerEntity(int id, String name, int company_id){
		this.id = id; 
		this.name = name ; 
		this.company_id = company_id; 
	}
	
	@Override
	public String toString(){
		if(this.id != -1){
			return "Id : " + id + " Name : " + name + " company_id : " + company_id ;	
		}else{
			return "no data";
		}
	}
}
