package com.firstproject.visitant;

public class QueryManager_V {
	
	String strSQLException = "SQLException : ";
	
	String insertVisitant_InsertQuery =  "INSERT INTO VISITANT(VISITNUMBER, INTIME, PASSNUM,"
			+ " VISITANTNAME, COMPANY, PHONE, STATE) "
			+ "VALUES(SECURITYVISTANT_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	String insertVisitant_SelectSql = "select * from visitant where passnum = ?";

	String insertVisitant_Exception = strSQLException + "insertVisitant";

	String outVisitant_SelectSql = "select * from visitant where passnum = ? and state = 1";
	
	String outVisitant_DeleteSql = "DELETE FROM VISITANT WHERE passnum = ?";
	
	String outVisitant_InsertSql = "INSERT INTO VISITANT_out(VISITNUMBER, INTIME, PASSNUM, "
			+ "VISITANTNAME, COMPANY, PHONE, outtime , STATE) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	String outVisitant_Exception = strSQLException + "outVisitant";

	String getCount_SelectSql = "select count(*) from visitant";

	String getCount_Exception = strSQLException + "getCount";

	String getvisitantList_SelectSql = "select * from(select "
			+ "rownum num, VISITNUMBER, INTIME, PASSNUM, VISITANTNAME, COMPANY, "
			+ "PHONE, OUTTIME, STATE from VISITANT ) where"
			+ " num >=? and num <=?";

	String getvisitantList_Exception = strSQLException + "getvisitantList";
	
	String getAllvisitantList_SelectSql = "select * from"
			+ 	"(select rownum num, b.* from ("
			+	"	select a.* from"
			+ 	"		(select * from visitant"
			+	"			union all"
			+	"	select * from visitant_out) a"
			+	"		order by visitnumber desc) b)"
			+	"where  num >=? and num <=?";
	
	String getAllvisitantList_Exception = strSQLException + "getAllvisitantList";
	
	String getAllCount_SelectSql = "select count(*) from visitant_out";
	
	String getAllCount_Exception = strSQLException + "getAllCount";

	

	}
		





















