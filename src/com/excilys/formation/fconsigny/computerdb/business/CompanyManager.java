package com.excilys.formation.fconsigny.computerdb.business;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.model.Company;
import com.excilys.formation.fconsigny.computerdb.storage.AppStorage;
import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;

public class CompanyManager implements ICompany{	

	public List<Company> getRemoteCompanies(){

		CompanyRemote[] companyRemoteArray =  AppStorage.getAllCompanies();
		List<Company> companyList = null;
		if(companyRemoteArray != null){
			companyList =  new ArrayList<Company>();

			for (int i = 0; i < companyRemoteArray.length; i++){
				companyList.add(new Company(companyRemoteArray[i].getId(),companyRemoteArray[i].getName()));
			}
		}
		return companyList;

	}
	public Company getRemoteCompany(){
		return null; 
	}
}
