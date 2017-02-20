package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.excilys.formation.fconsigny.computerdb.storage.model.CompanyRemote;
import com.excilys.formation.fconsigny.computerdb.storage.database.Database;;

public class CompanyDao implements IDao<CompanyRemote>{

	public static String TABLE_NAME = "company";

	public CompanyRemote[] getItems(){
		Database db = Database.getDatabase();
		ResultSet res = db.querySelect(TABLE_NAME);
		return initManyResultIntoArrayItem(res);
	}

	public CompanyRemote getItemById(int id){
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

	private CompanyRemote[] initManyResultIntoArrayItem(ResultSet res){

		CompanyRemote[] companyRemote = null; 

		try {
			int size = res.getRow();
			companyRemote = new CompanyRemote[size];

			for (int i = 0; i < size ; i ++, res.next()){
				companyRemote[i] = initResultIntoItem(res.getInt(1),res.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		return companyRemote;
	}

}
