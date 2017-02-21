package com.excilys.formation.fconsigny.computerdb.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.CompanyManager;
import com.excilys.formation.fconsigny.computerdb.business.model.Company;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.CompanyEntity;

public class CompanyController {

	public List<CompanyEntity> loadCompanies(){

		List<Company> lCompanies = CompanyManager.getRemoteCompanies();
		
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
		Company company =  CompanyManager.getRemoteCompany(id);
		if(company != null){
			return new CompanyEntity( company.getId(),company.getName());
		}
		return null; 
	}
}
