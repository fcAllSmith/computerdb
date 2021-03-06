package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;
import com.excilys.formation.fconsigny.computerdb.storage.database.Database;;

public class CompanyDaoImpl implements IDao<CompanyRemote>{

	public static String TABLE_NAME = "company";

	public List<CompanyRemote> getItems(){
		Database db = Database.getDatabase();
		ResultSet res = db.querySelect(TABLE_NAME);
		return initManyResultIntoArrayItem(res);
	}
	
	@Override
	public CompanyRemote getItemById(int id){
		Database db = Database.getDatabase();
		ResultSet res = db.querySelectById(TABLE_NAME, id);
		if(res != null){
			try {
				if(res.next()){
					return initResultIntoItem(res.getInt(1),res.getString(2));	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

	private CompanyRemote initResultIntoItem(int id, String name){
		CompanyRemote companyRemote = null; 
		if(id != -1  && name != null){
			companyRemote = new CompanyRemote(id);
			companyRemote.setName(name);
		}

		return companyRemote; 
	}

	private List<CompanyRemote> initManyResultIntoArrayItem(ResultSet res){
		List<CompanyRemote> companyList = new ArrayList<CompanyRemote>();
		try {
			while(res.next()){
				companyList.add( initResultIntoItem(res.getInt(1),res.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companyList;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO NOTHING
		return false;
	}

	@Override
	public boolean updateItem(CompanyRemote object) {
		// TODO NOTHING
		return false;
	}
}
