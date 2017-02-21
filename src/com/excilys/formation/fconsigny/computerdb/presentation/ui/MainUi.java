package com.excilys.formation.fconsigny.computerdb.presentation.ui;

import java.util.List;

import com.excilys.formation.fconsigny.computerdb.presentation.AppView;
import com.excilys.formation.fconsigny.computerdb.presentation.IApp;
import com.excilys.formation.fconsigny.computerdb.presentation.controller.CompanyController;
import com.excilys.formation.fconsigny.computerdb.presentation.controller.ComputerController;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.CompanyEntity;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.ComputerEntity;

public class MainUi extends AppView implements IApp{

	@Override
	public void RefreshUi() {
		showText("Welcom in main ui");
		showText("-- Menu --");
		showText("1 - List computers");
		showText("2 - List companies");
		showText(" What do you want to do ? :");
		String choice = readInputText();
		onInputKey(choice);
	}

	public void onInputKey(String inputKey){
	
		try{
			int inputChoice = Integer.parseInt(inputKey);
			switch(inputChoice){
			case 0: 
				//TODO : exit
				break;
			case 1: 
				//TODO : Show list computers
				loadListComputer();
				break; 
			case 2:
				loadListCompany();
				break; 
			default:
				System.out.println("command not found");
				break; 
			}
		}catch(NumberFormatException e){
			showText("This input cannot be used. Use numbers instead");
		}
		
		RefreshUi();
	}
	private void loadListCompany(){
		List<CompanyEntity> listCompanies = new CompanyController().loadCompanies();
		for(CompanyEntity company : listCompanies){
			showText(company.toString());
		}
	}
	
	private void loadListComputer(){
		List<ComputerEntity> listComputers = new ComputerController().loadComputers();
		for(ComputerEntity computer : listComputers){
			showText(computer.toString());
		}
	}
}
