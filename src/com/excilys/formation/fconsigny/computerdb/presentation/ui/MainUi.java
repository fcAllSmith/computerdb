package com.excilys.formation.fconsigny.computerdb.presentation.ui;

import java.util.List;

import com.excilys.formation.fconsigny.computerdb.presentation.AppView;
import com.excilys.formation.fconsigny.computerdb.presentation.CompanyComponent;
import com.excilys.formation.fconsigny.computerdb.presentation.IApp;
import com.excilys.formation.fconsigny.computerdb.presentation.modele.CompanyEntity;

public class MainUi extends AppView implements IApp{

	@Override
	public void RefreshUi() {
		// TODO Auto-generated method stub
		showText("Welcom in main ui");
		showText("-- Menu --");
		showText("1 - List computers");
		showText("2 - List companies");
		showText(" What do you want to do ? :");
		String choice = readInputText();
		onInputKey(choice);
	}
	
	public void onInputKey(String inputKey){
		
		int inputChoice = -1;
		
	    try{
	        inputChoice = Integer.parseInt(inputKey);
	        switch(inputChoice){
			case 0: 
				//TODO : exit
				break;
			case 1: 
				//TODO : Show list computers
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
		//TODO write something
		List<CompanyEntity> listCompanies = new CompanyComponent().loadCompanies();
		if(listCompanies.isEmpty()){
			showText("No item found");
		}else{
			for(int i = 0; i < listCompanies.size(); i++){
				showText(listCompanies.get(i).toString());
			}
		}
	}
}
