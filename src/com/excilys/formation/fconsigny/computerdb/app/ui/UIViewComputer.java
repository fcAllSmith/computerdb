package com.excilys.formation.fconsigny.computerdb.app.ui;

import java.io.IOException;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.IApp;
import com.excilys.formation.fconsigny.computerdb.app.controller.ComputerController;
import com.excilys.formation.fconsigny.computerdb.app.entity.ComputerEntity;

public class UIViewComputer extends AppView implements IApp{

	AppView appParentView ;
	private static ComputerController computerController;

	@Override
	public void CreateView(AppView appParentView) {
		if(this.appParentView == null && computerController == null){
			this.appParentView = appParentView;
			UIViewComputer.computerController = new ComputerController();
		}
		
		showTitle(UIViewComputer.class); 
		RefreshUi();
	}	

	@Override
	public void RefreshUi() {
		// TODO Auto-generated method stub
		showText("test -- menu");
		showText("1 - Show list of computers") ;
		showText("2 - Select a computer for info") ;
		showText("3 - Remove a computer from the data base ");
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
		((IApp) appParentView).RefreshUi();
	}

	public void onInputKey(String str_input) throws IOException{
		int cmd = Integer.parseInt(str_input);
		
		switch(cmd){

		case 0: 
			RefreshUi();
			break;
		case 1:
			loadListComputer();
			break ;
		case 2:
			showText("Computer id  : ");
			String str_computId = readInputText();
			loadComputerById(Integer.parseInt(str_computId));
			break;
		case 3:
			showText("Computer id : ");
			String str_compId = readInputText();
			deleteComputer(Integer.parseInt(str_compId));
			break;
		default:
			this.DestroyView();
			break;
		}

		RefreshUi();
	}

	/** Computers **/ 

	private void loadComputerById(int id){
		ComputerEntity ce = UIViewComputer.computerController.loadComputer(id);
		if(ce!= null ){
			showText(ce.toString());	
		}else{
			showText("No data");
		}
	}

	private void deleteComputer(int id){

		if(UIViewComputer.computerController.removeComputer(id)){
			showText("the computer has been removed");
		}else{
			showText("this computer doesn't exist");
		}
	}

	private void loadListComputer(){
		List<ComputerEntity> lComputers = UIViewComputer.computerController.loadComputers();
		for(ComputerEntity computer : lComputers){
			showText(computer.toString());
		}
	}
}
