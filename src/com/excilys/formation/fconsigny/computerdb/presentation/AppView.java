package com.excilys.formation.fconsigny.computerdb.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AppView {

	public String readInputText(){
		String inputText = null; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			inputText = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inputText = null;
		}

		return inputText;
	}

	public void showText(String text){
		System.out.println(text);
	}
}
