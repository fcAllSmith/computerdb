package com.excilys.formation.fconsigny.computerdb.presentation.ui;

import java.io.IOException;
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
		showText("3 - Select one computer");
		showText("What do you want to do ? :");
		String str_input;
		
		try {
			str_input = readInputText();
			onInputKey(str_input);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onInputKey(String str_input){

		try{
			int cmd = Integer.parseInt(str_input);
			switch(cmd){
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
			case 3: 
				showText("Computer id  : ");
				String str_computId = readInputText();
				loadComputerById(Integer.parseInt(str_computId));
				break;
			case 4:
				showText("Company id : "); 
				String str_companId = readInputText();
				loadCompanyById(Integer.parseInt(str_companId));
				break;
			default:
				showText("command not found");
				break; 
			}
			
		}catch(NumberFormatException | IOException err){
			showText("This input cannot be used. Use numbers instead :" + err);
		}

		RefreshUi();
	}


	/** Companies **/
	private void loadListCompany(){
		List<CompanyEntity> lCompanies = new CompanyController().loadCompanies();
		for(CompanyEntity company : lCompanies){
			showText(company.toString());
		}
	}

	private void loadCompanyById(int id){
		CompanyEntity ce = new CompanyController().loadCompany(id);		
		if(ce != null){
			showText(ce.toString());
		}else{
			showText("No data");
		}
	}

	/** Computers **/ 

	private void loadComputerById(int id){
		ComputerEntity ce = new ComputerController().loadComputer(id);
		if(ce!= null ){
			showText(ce.toString());	
		}else{
			showText("No data");
		}
	}

	private void loadListComputer(){
		List<ComputerEntity> lComputers = new ComputerController().loadComputers();
		for(ComputerEntity computer : lComputers){
			showText(computer.toString());
		}
	}
}
