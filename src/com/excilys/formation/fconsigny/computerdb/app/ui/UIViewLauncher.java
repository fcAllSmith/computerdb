package com.excilys.formation.fconsigny.computerdb.app.ui;

import java.io.IOException;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.IApp;
import com.excilys.formation.fconsigny.computerdb.app.controller.CompanyController;
import com.excilys.formation.fconsigny.computerdb.app.controller.ComputerController;
import com.excilys.formation.fconsigny.computerdb.app.entity.CompanyEntity;
import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;

public class UIViewLauncher extends AppView implements IApp{

	@Override
	public void CreateView(AppView appParentView) {
		// TODO Auto-generated method stub
		this.RefreshUi();
	}

	@Override
	public void RefreshUi() {
		showTitle(UIViewLauncher.class); 

		showText("------- Menu -------");
		showText("1 - Computers") ;
		showText("2 - Companies");
		showText( "What do you want to do ? :");

		String str_input;

		try {
			str_input = readInputText();
			onInputKey(str_input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DestroyView() {
		// TODO Auto-generated method stub
	}

	public void onInputKey(String str_input){

		try{
			int cmd = Integer.parseInt(str_input);
			switch(cmd){
			case 0: 
				//TODO : exit
				break;
			case 1: 
				UIViewComputer uiViewComputer = new UIViewComputer();
				uiViewComputer.CreateView(this);
				break; 
			case 2:
				UIViewCompany uiViewCompany = new UIViewCompany();
				uiViewCompany.CreateView(this);
				break;
			default:
				showText("command not found");
				break; 
			}

		}catch(NumberFormatException err){
			showText("This input cannot be used. Use numbers instead :" + err);
		}

		RefreshUi();
	}
}
