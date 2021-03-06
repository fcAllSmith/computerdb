package com.excilys.formation.fconsigny.computerdb.storage;

import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;
import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.storage.dao.CompanyDaoImpl;
import com.excilys.formation.fconsigny.computerdb.storage.dao.ComputerDaoImpl;
import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;
import com.excilys.formation.fconsigny.computerdb.utils.AppDebug;

/**
 *  List every possible Query on entities
 *  Only this method is public
 * @author excilys
 *
 */
public abstract class AppStorage{

	public static List<CompanyRemote> getAllCompanies(){
		return new CompanyDaoImpl().getItems();
	}
	
	public static List<ComputerRemote> getAllComputers(){
		return new ComputerDaoImpl().getItems();
	}

	public static final ComputerRemote getComputer(int id){
		return new ComputerDaoImpl().getItemById(id);
	}
	
	public static final CompanyRemote getCompany(int id){
		return new CompanyDaoImpl().getItemById(id);
	}

	public static boolean deleteComputer(int id){
		AppDebug.log(AppStorage.class, "here");
		return new ComputerDaoImpl().deleteItemById(id);
	}
	
	public static boolean updateComputer(Computer computer ){
		if(computer != null){
			
			//return new ComputerDaoImpl().updateItem(computer)	;
		}
		
		return false;
	}
}
