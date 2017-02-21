package com.excilys.formation.fconsigny.computerdb.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;
import com.excilys.formation.fconsigny.computerdb.business.ComputerApi;
import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.utils.AppDebug;

public class ComputerController {

	public List<ComputerEntity> loadComputers(){

		List<Computer> lcomputer =  ComputerApi.getRemoteComputers();
		List<ComputerEntity> computerEntityList = null; 
		if(lcomputer != null){
			computerEntityList = new ArrayList<ComputerEntity>();
			
			for (Computer computer : lcomputer){
				ComputerEntity ce = new ComputerEntity(computer.getId(),computer.getName(),computer.getCompanyId());
				computerEntityList.add(ce);
			}
		}
		
		return computerEntityList;
	}
	
	public ComputerEntity loadComputer(int id){
		Computer cr = ComputerApi.getRemoteComputer(id); 
	
		if(cr != null){
			return new ComputerEntity( cr.getId(),cr.getName(),cr.getCompanyId());
		}
		
		return null; 
	}
	
	public boolean removeComputer(int id){
		AppDebug.log(ComputerController.class, " We pass here");
		return ComputerApi.deleteComputer(new ComputerEntity(id));
	}
}
