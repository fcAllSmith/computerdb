package com.excilys.formation.fconsigny.computerdb.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.entity.CompanyEntity;
import com.excilys.formation.fconsigny.computerdb.business.CompanyApi;
import com.excilys.formation.fconsigny.computerdb.business.model.Company;

public class CompanyController {

	public List<CompanyEntity> loadCompanies(){

		List<Company> lCompanies = CompanyApi.getRemoteCompanies();
		
		List<CompanyEntity> companiesEntityList = null;
		
		if(lCompanies != null){
			companiesEntityList = new ArrayList<CompanyEntity>();
		
			for(Company company : lCompanies){
				companiesEntityList.add( new CompanyEntity(
						company.getId(),
						company.getName()));
			}
		}
		
		return companiesEntityList;
	}
	
	public CompanyEntity loadCompany(int id){
		Company company =  CompanyApi.getRemoteCompany(id);
		if(company != null){
			return new CompanyEntity( company.getId(),company.getName());
		}
		return null; 
	}
}
