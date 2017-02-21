package com.excilys.formation.fconsigny.computerdb.app.ui;

import java.io.IOException;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.IApp;

public class UIViewComputer extends AppView implements IApp{

	AppView appParentView ;

	@Override
	public void CreateView(AppView appParentView) {
		// TODO Auto-generated method stub
		this.appParentView = appParentView;
		showTitle(UIViewComputer.class); 
		RefreshUi();
	}	

	@Override
	public void RefreshUi() {
		// TODO Auto-generated method stub
		showText("test -- menu");
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

	public void onInputKey(String str_input){
		int cmd = Integer.parseInt(str_input);
		switch(cmd){
		case 0: 
			RefreshUi();
			//TODO : exit
			break;
		default:
			this.DestroyView();
			break;
		}
	}
}
