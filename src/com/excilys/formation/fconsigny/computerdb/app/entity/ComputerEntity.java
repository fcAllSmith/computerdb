package com.excilys.formation.fconsigny.computerdb.app.entity;

public class ComputerEntity {
	
	private int id; 
	private String name; 
	private int company_id;
	
	public ComputerEntity(int id){
		this.id = id;
	}
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
}
