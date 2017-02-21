package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.storage.database.Database;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;

public class ComputerDao implements IDao<ComputerRemote> {

	public static String TABLE_NAME = "computer";

	@Override
	public List<ComputerRemote> getItems() {
		Database db = Database.getDatabase();
		ResultSet res = db.querySelect(TABLE_NAME);
		return initManyResultIntoArrayItem(res);
	}

	@Override
	public ComputerRemote getItemById(int id) {
		return null;
	}
	
	private ComputerRemote initResultIntoItem(int id, String name,int companyId){
		ComputerRemote computerRemote = null; 
		if(id != -1  && name != null){
			computerRemote = new ComputerRemote(id);
			computerRemote.setName(name);
			computerRemote.setCompanyId(companyId);
		}

		return computerRemote; 
	}

	private List<ComputerRemote> initManyResultIntoArrayItem(ResultSet res){
		List<ComputerRemote> computerRemoteList = new ArrayList<ComputerRemote>(); 
		try {
			while(res.next()){
				computerRemoteList.add(initResultIntoItem(res.getInt(1),res.getString(2),res.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerRemoteList;
	}
	

}