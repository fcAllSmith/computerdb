package com.excilys.formation.fconsigny.computerdb;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.ui.UIViewLauncher;

public class App extends AppView {

	/**
	 * Launch main View with menu 
	 * @param args
	 */
	public static void main(String[] args) {
		UIViewLauncher mainUi = new UIViewLauncher();
		mainUi.RefreshUi();
		//mainUi.CreateView(this);
	}
}
