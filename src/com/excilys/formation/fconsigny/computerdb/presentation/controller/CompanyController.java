package com.excilys.formation.fconsigny.computerdb.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.CompanyManager;
import com.excilys.formation.fconsigny.computerdb.business.model.Company;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.CompanyEntity;
import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;

public class CompanyController {
	
	public List<CompanyEntity> loadCompanies(){

		CompanyManager cm  = new CompanyManager();
		List<Company> companiesList = cm.getRemoteCompanies();
		List<CompanyEntity> companiesEntityList = new ArrayList<CompanyEntity>();

		for(int i = 0; i < companiesList.size(); i++){
			CompanyEntity ce = new CompanyEntity(companiesList.get(i).getId(),companiesList.get(i).getName());
			companiesEntityList.add(ce);
		}

		return companiesEntityList;
	}

	public CompanyEntity loadCompany(int id){
		CompanyManager cm = new CompanyManager(); 
		CompanyRemote cr = cm.getRemoteCompany(id); 

		if(cr != null){
			return new CompanyEntity( cr.getId(),cr.getName());
		}
		return null; 
	}
}
