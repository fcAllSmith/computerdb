package com.excilys.formation.fconsigny.computerdb.utils;

public abstract class AppDebug {

	public static void log(Class<?> c , String errorMessage){
		StringBuilder sb = new StringBuilder();
		sb.append(c.getName().toString() + ".Class");
		sb.append(" | "); 
		sb.append( "Message : ");
		sb.append(errorMessage);
		System.out.println(sb.toString());
	}
}
