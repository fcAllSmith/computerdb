package com.excilys.formation.fconsigny.computerdb.business;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.storage.AppStorage;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;

public abstract class ComputerManager {
	
	public static List<Computer> getRemoteComputers(){

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
	
	public static Computer getRemoteComputer(int id){
		ComputerRemote cr = AppStorage.getComputer(id);
		return new Computer(cr.getId(),cr.getName(),cr.getCompanyId());  
	}
	
	/*public boolean updateComputer(ComputerRemote computer){
		return AppStorage.updateComputer(computer);
	}*/
	
	public boolean deleteComputer(ComputerRemote computer){
		return AppStorage.deleteComputer(computer.getId()); 
	}
}
