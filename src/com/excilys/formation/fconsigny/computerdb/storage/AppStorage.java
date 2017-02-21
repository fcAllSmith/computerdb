package com.excilys.formation.fconsigny.computerdb.storage;

import java.util.List;

import com.excilys.formation.fconsigny.computerdb.storage.dao.CompanyDao;
import com.excilys.formation.fconsigny.computerdb.storage.dao.ComputerDao;
import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;

/**
 *  List every possible Query on entities
 *  Only this method is public
 * @author excilys
 *
 */
public abstract class AppStorage implements IStorage{

	public static List<CompanyRemote> getAllCompanies(){
		CompanyDao companyDao = new CompanyDao();
		return companyDao.getItems();
	}

	public static List<ComputerRemote> getAllComputers(){
		ComputerDao computerDao = new ComputerDao();
		return computerDao.getItems();
	}

	public static final ComputerRemote getComputer(int id){
		ComputerDao computerDao = new ComputerDao();
		return computerDao.getItemById(id);
	}
	
	public static final CompanyRemote getCompany(int id){
		CompanyDao companyDao = new CompanyDao();
		return companyDao.getItemById(id);
	}
}
