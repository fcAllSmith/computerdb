package com.excilys.formation.fconsigny.computerdb.storage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private String dbname = null;
	private String host = null; 
	private String user = null; 
	private String passwd = null; 
	
	private Connection conn = null; 
	private static Database _instance;
	
	private Database(){
		
	}
		
	private void openDataBase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String customPDO = "jdbc:mysql://localhost:3306/computer-database-db2";
			try{
				this.conn = DriverManager.getConnection(customPDO);
				
			}catch(SQLException error){
				System.out.println(error.toString());
			}finally{
				System.out.println("Connected");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Connection getConnection(){
		
		return this.conn; 
	}
	
	public static Database getDatabase(){
		if(_instance == null){
			_instance  = new Database();
			_instance.openDataBase();
			return _instance;
		}else{
			return _instance;
		}
	}

	public ResultSet querySelect(String tableName){
		java.sql.Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			return stmt.executeQuery("SELECT * FROM " + tableName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
