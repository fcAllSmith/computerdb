package com.excilys.formation.fconsigny.computerdb.storage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Singleton pattern 
 * Only one instance of the database is allowed 
 * @author excilys
 *
 */
public class Database {

	/* DB Constant  **/
	private static final String DB_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME ="computer-database-db2";
	private static final String JDB_DRIVER = "com.mysql.jdbc.Driver"; 

	/* Unique DB instance  */
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
		try {
			Statement stmt = this.prepareQuery();		
			stmt = getConnection().createStatement();
			return this.execQuery(stmt,"SELECT * FROM " + tableName + ";");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 	
		return null;
	}

	public ResultSet querySelectById(String tableName , int id){
		try {
			Statement stmt = this.prepareQuery();
			return this.execQuery(stmt, "SELECT * FROM " + tableName + " WHERE ID =  " + id +";");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return null;
	}

	public ResultSet doQuery(String query) throws SQLException{
		Statement stmt = this.prepareQuery();		
		return this.execQuery(stmt,query);
	}
	
	public int modifyData(String query) throws SQLException{
		Statement stmt = this.prepareQuery();
		return stmt.executeUpdate(query);
	}
	
	private Statement prepareQuery() throws SQLException{
		return getConnection().createStatement(); 
	}

	private ResultSet execQuery(Statement stmt ,String str_query) throws SQLException{
		return stmt.executeQuery(str_query);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
