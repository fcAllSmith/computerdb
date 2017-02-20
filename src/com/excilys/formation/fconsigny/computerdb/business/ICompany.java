package com.excilys.formation.fconsigny.computerdb.business;

import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.model.Company;

public interface ICompany {

	public List<Company> getRemoteCompanies();
	public Company getRemoteCompany();

}
