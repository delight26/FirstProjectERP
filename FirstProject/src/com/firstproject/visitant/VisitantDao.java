package com.firstproject.visitant;

import java.sql.*;
import java.util.ArrayList;

public class VisitantDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private QueryManager_V query = new QueryManager_V();
	
	private static VisitantDao instance = new VisitantDao();
	
	public static VisitantDao getInstans() {
		
		if(instance == null){
			instance = new VisitantDao();
		}		
		return instance;
	} // static instans

	public void insertVisitant(VisitantBean visitant){
		
		String insertSql = query.insertVisitant_InsertQuery;
		
		String selectSql = query.insertVisitant_SelectSql;
		
		try {
			connection = DBManager.getConnection();
			
			preparedStatement = connection.prepareStatement(selectSql);
			
			preparedStatement.setInt(1, visitant.getPassNum());
			
			resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()){
			
			preparedStatement = connection.prepareStatement(insertSql);
			
			preparedStatement.setTimestamp(1, visitant.getInTime());
			preparedStatement.setInt(2, visitant.getPassNum());
			preparedStatement.setString(3, visitant.getVisitantName());
			preparedStatement.setString(4, visitant.getCompany());
			preparedStatement.setString(5, visitant.getPhone());
			preparedStatement.setInt(6, 1);
			
			preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(query.insertVisitant_Exception);
			e.printStackTrace();
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}		
	}//end insertVisitant
	
	public void outVisitant(VisitantBean visitant){
		String selectSql = query.outVisitant_SelectSql;
		String deleteSql = query.outVisitant_DeleteSql;
		String insertSql = query.outVisitant_InsertSql;
				
		try {
			VisitantBean tempVisitant = null;
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, visitant.getPassNum());
			resultSet = preparedStatement.executeQuery();
			DBManager.setAutoCommit(connection, false);
			if(resultSet.next()) {
				tempVisitant = new VisitantBean(resultSet);
				preparedStatement = connection.prepareStatement(insertSql);
				preparedStatement.setInt(1, tempVisitant.getVisitnumber());
				preparedStatement.setTimestamp(2, tempVisitant.getInTime());
				preparedStatement.setInt(3, tempVisitant.getPassNum());
				preparedStatement.setString(4, tempVisitant.getVisitantName());
				preparedStatement.setString(5, tempVisitant.getCompany());
				preparedStatement.setString(6, tempVisitant.getPhone());
				preparedStatement.setTimestamp(7, visitant.getOutTime());
				preparedStatement.setInt(8, 0);				
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(deleteSql);
				preparedStatement.setInt(1, visitant.getPassNum());
				preparedStatement.executeUpdate();
			}
			DBManager.endAutoCommit(connection, true);
		} catch (SQLException e) {
			DBManager.endAutoCommit(connection, false);
			System.out.println(query.outVisitant_Exception);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}
	}//outVisitant
	
	public int getCount(){
		int count = 0;
		String selectSql = query.getCount_SelectSql;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);			
			resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) count = resultSet.getInt(1);			
		} catch (SQLException e) {
			System.out.println(query.getCount_Exception);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}		
		return count;
	}// end getCount()
	
	public ArrayList<VisitantBean> getvisitantList(int startRow, int endRow){
		ArrayList<VisitantBean> visitantList = new ArrayList<VisitantBean>();
		VisitantBean visitant = null;
		
		String selectSql = query.getvisitantList_SelectSql;
		
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				visitant = new VisitantBean(resultSet);
				visitantList.add(visitant);
			}
			
		} catch (SQLException e) {
			System.out.println(query.getvisitantList_Exception);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}				
		return visitantList;
	}//end getvisitantList

	public ArrayList<VisitantBean> getAllvisitantList(int startRow, int endRow){
		ArrayList<VisitantBean> visitantList = new ArrayList<VisitantBean>();
		VisitantBean visitant = null;
		
		String selectSql = query.getAllvisitantList_SelectSql;
		
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				visitant = new VisitantBean(resultSet);
				visitantList.add(visitant);
			}
			
		} catch (SQLException e) {
			System.out.println(query.getAllvisitantList_Exception);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}				
		return visitantList;
	}// end getAllvisitantList
	
	public int getAllCount() {
		int count = getCount();
		String selectSql = query.getAllCount_SelectSql;
			
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) count += resultSet.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(query.getAllCount_Exception);
		}
		
		return count;		
	}// end getAllCount();
	
	
}





















