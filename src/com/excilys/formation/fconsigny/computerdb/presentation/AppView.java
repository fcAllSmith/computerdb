package com.excilys.formation.fconsigny.computerdb.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AppView {

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

}
