package com.excilys.formation.fconsigny.computerdb.storage;

import com.excilys.formation.fconsigny.computerdb.storage.dao.CompanyDao;
import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;

public class AppStorage implements IStorage{

	public static CompanyRemote[] getAllCompanies(){
		CompanyDao companyDao = new CompanyDao();
		return companyDao.getItems();
	}
}
