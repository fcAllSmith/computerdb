package com.excilys.formation.fconsigny.computerdb.business;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.storage.AppStorage;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;

public class ComputerManager {
	
	public List<Computer> getRemoteComputers(){

		List<ComputerRemote> computerRemoteList =  AppStorage.getAllComputers();
		List<Computer> computerList = null;
		if(computerRemoteList != null){
			computerList =  new ArrayList<Computer>();

			for (int i = 0; i < computerRemoteList.size(); i++){
				computerList.add(new Computer(computerRemoteList.get(i).getId(),computerRemoteList.get(i).getName(),computerRemoteList.get(i).getCompanyId()));
			}
		}
		return computerList;

	}
	
	public ComputerRemote getRemoteComputer(){
		return null; 
	}
}
