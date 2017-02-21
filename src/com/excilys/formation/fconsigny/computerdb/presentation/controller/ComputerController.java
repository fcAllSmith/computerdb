package com.excilys.formation.fconsigny.computerdb.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.ComputerManager;
import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.ComputerEntity;
import com.excilys.formation.fconsigny.computerdb.storage.model.ComputerRemote;

public class ComputerController {

	public List<ComputerEntity> loadComputers(){

		ComputerManager cm  = new ComputerManager();
		List<Computer> computerList = cm.getRemoteComputers();
		List<ComputerEntity> computerEntityList = new ArrayList<ComputerEntity>();
		if(computerList != null){
			for (Computer computer : computerList){
				ComputerEntity ce = new ComputerEntity(computer.getId(),computer.getName(),computer.getCompanyId());
				computerEntityList.add(ce);
			}
		}
		return computerEntityList;
	}
	
	public ComputerEntity loadComputer(int id){
		ComputerManager cm = new ComputerManager(); 
		ComputerRemote cr = cm.getRemoteComputer(id); 

		if(cr != null){
			return new ComputerEntity( cr.getId(),cr.getName(),cr.getCompanyId());
		}
		return null; 
	}
}
