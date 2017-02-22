package com.excilys.formation.fconsigny.computerdb.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.excilys.formation.fconsigny.computerdb.app.ui.UIViewComponents;

/**
 * Global method used by the UIViews 
 * @author franc
 *
 */
public abstract class AppView {

	UIViewComponents ui_components;
	
	public String readInputText() throws IOException {
		String inputText = null; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputText = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inputText;
	}

	public void showText(String text){
		if(text != null)
			System.out.println(text);
		else 
			throw new IllegalArgumentException();  
	}
	
	public void showTitle(Class<?> c){
		System.out.println(UIViewComponents.LEFT_TEXT_MARGIN + c.getSimpleName());
	}


}
