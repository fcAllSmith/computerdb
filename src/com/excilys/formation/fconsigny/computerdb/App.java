package com.excilys.formation.fconsigny.computerdb;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.ui.UIViewLauncher;

public class App extends AppView {

	public static App mainContext; 
	/**
	 * Launch main View with menu 
	 * @param args
	 */
	private App (){
		if(mainContext == null){
			System.out.println("INSTANCE APP");
			App.mainContext = new App();
		}
	}
	
	public static void main(String[] args) {
		UIViewLauncher mainUi = new UIViewLauncher();
		mainUi.CreateView(mainContext);
	}
}
