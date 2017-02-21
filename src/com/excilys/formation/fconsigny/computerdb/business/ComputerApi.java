package com.excilys.formation.fconsigny.computerdb.business;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;
import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.storage.AppStorage;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;
import com.excilys.formation.fconsigny.computerdb.utils.AppDebug;

public abstract class ComputerApi {
	
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
	
	public static boolean deleteComputer(ComputerEntity computer){
		AppDebug.log(ComputerApi.class, "we are here");
		return AppStorage.deleteComputer(computer.getId()); 
	}
}
