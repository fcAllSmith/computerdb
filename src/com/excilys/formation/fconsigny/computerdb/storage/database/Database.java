package com.excilys.formation.fconsigny.computerdb.storage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private static final String DB_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME ="computer-database-db2";
	private static final String JDB_DRIVER = "com.mysql.jdbc.Driver"; 
	
	private static Database _instance;
	private Connection conn = null; 
	
	private Database(){}

	private void openDataBase(){
		try {
			Class.forName(JDB_DRIVER);
			String customPDO = "jdbc:mysql://localhost:3306/computer-database-db2";
			try{
				this.conn = DriverManager.getConnection(customPDO);
			}catch(SQLException error){
				System.out.println(error.toString());
			}finally{
				//System.out.println("Connected");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection(){return this.conn; }

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
			return stmt.executeQuery("SELECT * FROM " + tableName + ";");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return null;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
