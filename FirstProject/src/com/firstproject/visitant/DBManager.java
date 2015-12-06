package com.firstproject.visitant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	private static DataSource DS;
	private static Connection CONN;
	
	private DBManager() {
		// TODO Auto-generated constructor stub
	}
	
	static{
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			DS = (DataSource) envContext.lookup("jdbc/bbsDBPool");
			
		} catch (NamingException e) {
			
			System.out.println("NamingException" + "\n" +e.getMessage());
		}
	} // end static
	
	public static Connection getConnection() {
		
		try {
			CONN = DS.getConnection();
		} catch (SQLException e) {			
			System.out.println("SQLException" +" :  getConnection()");
			e.printStackTrace();
		}		
		return CONN;
	} //end getConnection
	
	public static void close(Connection connection, PreparedStatement preparedStatement){
		
		try {
			if(connection !=null) connection.close();
			if(preparedStatement !=null) preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("SQLException" +" :  close(conn,statement)");
			e.printStackTrace();
		}		
	} // end close(conn, statement)
	
	public static void close(ResultSet resultSet,Connection connection, PreparedStatement preparedStatement){
		
		try {
			if(resultSet !=null) resultSet.close();
			if(connection !=null) connection.close();
			if(preparedStatement !=null) preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("SQLException" +" :  close(resultset,conn,statement)");
			e.printStackTrace();
		}		
	} // end close(set, conn, statement)
	
	public static void setAutoCommit(Connection connection, boolean isAutoCommit) {
		
			try {
				if(connection !=null) connection.setAutoCommit(isAutoCommit);
			} catch (SQLException e) {
				System.out.println("SQLException" +" :  setAutoCommit()");
				e.printStackTrace();
			}
	}// end setautocommit
	
	public static void endAutoCommit(Connection connection, boolean commit){
		
			try {
				if(connection !=null){
					if(commit){
						connection.commit();
					}else{
						connection.rollback();
					}					
				}
			} catch (SQLException e) {
				System.out.println("SQLException" +" :  endAutoCommit()");
				e.printStackTrace();
			} 
	}//end endautocommit
	
}//end class







