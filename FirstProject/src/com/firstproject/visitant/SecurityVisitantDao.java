package com.firstproject.visitant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SecurityVisitantDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private static SecurityVisitantDao instance = new SecurityVisitantDao();
	private QueryManager_S query = new QueryManager_S();
	public static SecurityVisitantDao getInstans() {
		
		if(instance == null){
			instance = new SecurityVisitantDao();
		}		
		return instance;
	} // static instans
	
	public boolean checkMemberNum(int memberNumber){
		boolean checkPri1 = false;
		String selectSql = query.checkMemberNum_SelectSql;
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if(resultSet.getInt(1) == memberNumber) checkPri1 = true;				
			}
			}catch (SQLException e) {
				System.out.println(query.checkMemberNum_Execption);
			}finally {
				DBManager.close(resultSet, connection, preparedStatement);
			}	
		return checkPri1;
	}//end checkMemberNum
	
	public boolean checkSecurityPass(int securityPass){
		boolean checkPri2 = true;
		String SelectSql = query.checkSecurityPass_SelectSql;
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SelectSql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if(resultSet.getInt(1) == securityPass) checkPri2 = false;				
			}
			}catch (SQLException e) {
				System.out.println(query.checkSecurityKey_Execption);
			}finally {
				DBManager.close(resultSet, connection, preparedStatement);
			}	
		return checkPri2;
	}//end checkSecurityPass
	
	
	
	public int getVisitNumber(int passNumber){
		int resultVisitNumber=0;
		String selectSql = query.getVisitNumber_SelectSql;
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, passNumber);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) resultVisitNumber = resultSet.getInt(1);
			
			}catch (SQLException e) {
				System.out.println(query.getVisitNumber_Execption);
			}finally {
				DBManager.close(resultSet, connection, preparedStatement);
			}	
		return resultVisitNumber;
	}//end getVisitNumber
	
	public boolean checkSecurityKey(int visitNumber){
		boolean checkPri3 = false;
		String selectSql = query.checkSecurityKey_SelectSql;
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, visitNumber);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) checkPri3 = true;			
			}catch (SQLException e) {
				System.out.println(query.checkSecurityKey_Execption);
			}finally {
				DBManager.close(resultSet, connection, preparedStatement);
			}			
		return checkPri3;
	}

	public void insertSecurity(SecurityVistantBean security){
		String insertSql = query.insertSecurity_InsertSql;
		try {
			connection = DBManager.getConnection();
			DBManager.setAutoCommit(connection, false);	
			preparedStatement = connection.prepareStatement(insertSql);
	
			preparedStatement.setInt(1, security.getSecurityPass());
			preparedStatement.setInt(2, security.getVisitNumber());
			preparedStatement.setTimestamp(3, security.getSecurityInTime());
			preparedStatement.setInt(4, 1);
			preparedStatement.setString(5, security.getWork());
			preparedStatement.setInt(6, security.getMemberNumber());
			
			preparedStatement.executeUpdate();
			
			insertSql = query.insertSecurity_InsertSql_2;
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setInt(1, security.getVisitNumber());
			
			preparedStatement.executeUpdate();
			DBManager.endAutoCommit(connection, true);	
		} catch (SQLException e) {
			DBManager.endAutoCommit(connection, false);
			System.out.println(query.insertSecurity_Execption);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}
	}//end checkSequrity
	
	public void outSecurityVistant(SecurityVistantBean security){
		String selectSql = query.outSecurityVistant_SelectSql;
		String deleteSql =query.outSecurityVistant_DeleteSql;
		String insertSql = query.outSecurityVistant_InsertSql;
		String updateSql = query.outSecurityVistant_UpdateSql;
		
		try {
			SecurityVistantBean tempSecurity = null;
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, security.getSecurityPass());
			resultSet = preparedStatement.executeQuery();
			DBManager.setAutoCommit(connection, false);
			if(resultSet.next()) {
				tempSecurity = new SecurityVistantBean(resultSet);
				preparedStatement = connection.prepareStatement(insertSql);
				preparedStatement.setInt(1, tempSecurity.getSecurityPass());
				preparedStatement.setInt(2, tempSecurity.getVisitNumber());
				preparedStatement.setTimestamp(3, tempSecurity.getSecurityInTime());
				preparedStatement.setTimestamp(4, security.getSecurityOutTime());
				preparedStatement.setInt(5, 0);
				preparedStatement.setString(6, tempSecurity.getWork());
				preparedStatement.setInt(7, tempSecurity.getMemberNumber());
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(deleteSql);
				preparedStatement.setInt(1, security.getSecurityPass());
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(updateSql);
				preparedStatement.setInt(1, tempSecurity.getVisitNumber());
				preparedStatement.executeUpdate();
			}
			DBManager.endAutoCommit(connection, true);
		} catch (SQLException e) {
			DBManager.endAutoCommit(connection, false);
			System.out.println(query.outSecurityVistant_Execption);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}		
	}//end outSecurityVistant
	public int getCount(){
		int count=0;
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
	}//end getCount
	
	public ArrayList<ListSecurityBean> getListSecurity(int startRow,int endRow){
		ArrayList<ListSecurityBean> listSecurity = new ArrayList<ListSecurityBean>();
		ListSecurityBean listJoinSecurity = null;
		
		String selectSql = query.getListSecurity_SelectSql;
					
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				listJoinSecurity = new ListSecurityBean();
				listJoinSecurity.setSecurityInTime(resultSet.getTimestamp(2));
				listJoinSecurity.setSecurityPass(resultSet.getInt(3));
				listJoinSecurity.setVisitantName(resultSet.getString(4));
				listJoinSecurity.setCompany(resultSet.getString(5));
				listJoinSecurity.setPhone(resultSet.getString(6));
				listJoinSecurity.setWork(resultSet.getString(7));
				listJoinSecurity.setMemberNumber(resultSet.getInt(8));
				listJoinSecurity.setSecurityState(resultSet.getInt(9));
				
			//	listJoinSecurity = new ListSecurityBean(resultSet);
				listSecurity.add(listJoinSecurity);
			}			
		} catch (SQLException e) {
			System.out.println(query.getListSecurity_Exception);
			e.printStackTrace();
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}				
		return listSecurity;
	}//end getListSecurity
	
	public int getAllCount(){		
		int count=getCount();
		String selectSql = query.getAllCount_SelectSql;
		
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) count += resultSet.getInt(1);
		} catch (SQLException e) {
			System.out.println(query.getAllCount_Exception);
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}
		return count;
	}//end getAllcount
	
	public ArrayList<ListSecurityBean> getAllListSecurity(int startRow,int endRow){
		ArrayList<ListSecurityBean> listSecurity = new ArrayList<ListSecurityBean>();
		ListSecurityBean listJoinSecurity = null;
		
		String selectSql = query.getAllListSecurity_SelectSql;
					
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				listJoinSecurity = new ListSecurityBean();
				listJoinSecurity.setSecurityInTime(resultSet.getTimestamp(2));
				listJoinSecurity.setSecurityPass(resultSet.getInt(3));
				listJoinSecurity.setVisitantName(resultSet.getString(4));
				listJoinSecurity.setCompany(resultSet.getString(5));
				listJoinSecurity.setPhone(resultSet.getString(6));
				listJoinSecurity.setWork(resultSet.getString(7));
				listJoinSecurity.setMemberNumber(resultSet.getInt(8));
				listJoinSecurity.setSecurityState(resultSet.getInt(9));
				
			//	listJoinSecurity = new ListSecurityBean(resultSet);
				listSecurity.add(listJoinSecurity);
			}			
		} catch (SQLException e) {
			System.out.println(query.getAllListSecurity_Exception);
			e.printStackTrace();
		} finally {
			DBManager.close(resultSet, connection, preparedStatement);
		}				
		return listSecurity;
	}//end getListSecurity
	
	
	
	
	
	
	
	
	
}
