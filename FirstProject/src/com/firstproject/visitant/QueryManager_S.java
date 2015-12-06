package com.firstproject.visitant;

public class QueryManager_S {

	String strSQLException = "SQLException : ";
	
	String checkMemberNum_SelectSql = "select membernumber from member";
	
	String checkMemberNum_Execption = strSQLException + "checkMemberNum";
	
	String checkSecurityPass_SelectSql = "select SECURITYPASS from SECURITYVISTANT";
	
	String checkSecurityPass_Execption = strSQLException + "checkSecurityPass";
	
	String getVisitNumber_SelectSql = "select VISITNUMBER from VISITANT where passnum = ?";
	
	String getVisitNumber_Execption = strSQLException + "getVisitNumber";
	
	String checkSecurityKey_SelectSql = "select VISITNUMBER from SECURITYVISTANT where visitNumber = ?";
	
	String checkSecurityKey_Execption = strSQLException + "checkSecurityKey";
	
	String insertSecurity_InsertSql = "INSERT INTO SECURITYVISTANT(SECURITYPASS, VISITNUMBER, SECURITYINTIME,"
			+ " SECURITYSTATE, WORK, MEMBERNUMBER) VALUES "
			+ "(?, ?, ?, ?, ?, ?)";

	String insertSecurity_InsertSql_2 ="UPDATE visitant SET state = 2 where VISITNUMBER = ?";
			
	String insertSecurity_Execption = strSQLException + "insertSecurity";
	
	String outSecurityVistant_SelectSql = "select * from SECURITYVISTANT where SECURITYPASS = ? and SECURITYSTATE = 1";
	
	String outSecurityVistant_DeleteSql = "DELETE FROM SECURITYVISTANT WHERE SECURITYPASS = ?";
	
	String outSecurityVistant_InsertSql = "INSERT INTO SECURITYVISTANT_out(SECURITYPASS, VISITNUMBER, "
			+ "SECURITYINTIME, SECURITYOUTTIME, SECURITYSTATE, WORK, MEMBERNUMBER) "
			+ "VALUES(?,?,?,?,?,?,?)";
	
	String outSecurityVistant_UpdateSql = "UPDATE VISITANT SET state = 1 where VISITNUMBER = ?";
	
	String outSecurityVistant_Execption = strSQLException + "outSecurityVistant";
	
	String getCount_SelectSql = "select count(*) from SECURITYVISTANT";		
	
	String getCount_Exception = strSQLException + "getCount";
	
	String getListSecurity_SelectSql = "select * from (select rownum num, "
			+ "s.SECURITYINTIME as SECURITYINTIME, s.SECURITYPASS as SECURITYPASS,"
			+ " v.VISITANTNAME as VISITANTNAME, v.COMPANY as COMPANY,"
			+ " v.PHONE as PHONE, s.WORK as WORK, "
			+ "s.MEMBERNUMBER as MEMBERNUMBER, s.SECURITYSTATE as SECURITYSTATE "
			+ "from SECURITYVISTANT s, VISITANT v "
			+ "where s.VISITNUMBER = v.VISITNUMBER) "
			+ "where num >=? and num <=?";
	
	String getListSecurity_Exception = strSQLException + "getListSecurity";
	
	String getAllCount_SelectSql = "SELECT count(*) FROM SECURITYVISTANT_OUT";		
	
	String getAllCount_Exception = strSQLException + "getAllCount";
	
	String getAllListSecurity_SelectSql = "select * from( SELECT "
			+ "rownum num, b.* FROM "
			+ "(SELECT a.* FROM "
			+ "(select s.SECURITYINTIME as SECURITYINTIME, "
			+ "s.SECURITYPASS as SECURITYPASS, v.VISITANTNAME as VISITANTNAME"
			+ ", v.COMPANY as COMPANY, v.PHONE as PHONE, s.WORK as WORK"
			+ ", s.MEMBERNUMBER as MEMBERNUMBER, s.SECURITYSTATE as SECURITYSTATE "
			+ "from SECURITYVISTANT s, VISITANT v "
			+ "where s.VISITNUMBER = v.VISITNUMBER "
			+ "UNION all "
			+ "select s.SECURITYINTIME as SECURITYINTIME, s.SECURITYPASS as SECURITYPASS, "
			+ "v.VISITANTNAME as VISITANTNAME, v.COMPANY as COMPANY, v.PHONE as PHONE, "
			+ "s.WORK as WORK, s.MEMBERNUMBER as MEMBERNUMBER, s.SECURITYSTATE as SECURITYSTATE "
			+ "from SECURITYVISTANT_out s, VISITANT v where s.VISITNUMBER = v.VISITNUMBER) a "
			+ "order by a.SECURITYINTIME desc) b) "
			+ "where  num >=? and num <=?";
	
	String getAllListSecurity_Exception = strSQLException + "getAllListSecurity";

}
