package com.excilys.formation.fconsigny.computerdb.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.business.ComputerManager;
import com.excilys.formation.fconsigny.computerdb.business.model.Computer;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.ComputerEntity;

public class ComputerController {

	public List<ComputerEntity> loadComputers(){

		List<Computer> lcomputer =  ComputerManager.getRemoteComputers();
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
		Computer cr = ComputerManager.getRemoteComputer(id); 
	
		if(cr != null){
			return new ComputerEntity( cr.getId(),cr.getName(),cr.getCompanyId());
		}
		return null; 
	}
}
