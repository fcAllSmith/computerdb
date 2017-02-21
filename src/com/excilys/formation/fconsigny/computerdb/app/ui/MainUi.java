package com.excilys.formation.fconsigny.computerdb.app.ui;

import java.io.IOException;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.IApp;
import com.excilys.formation.fconsigny.computerdb.app.controller.CompanyController;
import com.excilys.formation.fconsigny.computerdb.app.controller.ComputerController;
import com.excilys.formation.fconsigny.computerdb.app.entity.CompanyEntity;
import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;

public class MainUi extends AppView implements IApp{

	@Override
	public void RefreshUi() {
		//showText(" _________________________________________________");
		 //showText("|					Welcom in main ui				|");
		showText("|					------- Menu -------			|");
		showText("|		1 - Show list of computers					|");
		showText("|		2 - Show list of companies					|");
		showText("|		3 - Select a computer for info				|");
		showText("|		4 - Select a company for info				|"); 
		showText("|		5 - Remove a computer from the data base 	|");
		showText("|													|");
		showText("|	What do you want to do ? :						|");	
	//	showText(" _________________________________________________");
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
			case 5:
				showText("Computer id : ");
				String str_compId = readInputText();
				deleteComputer(Integer.parseInt(str_compId));
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
	
	private void deleteComputer(int id){
		if(new ComputerController().removeComputer(id)){
			showText("the computer has been removed");
		}else{
			showText("this computer doesn't exist");
		}
	}
}
