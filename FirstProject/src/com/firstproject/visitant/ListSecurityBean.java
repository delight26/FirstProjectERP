package com.firstproject.visitant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ListSecurityBean {
	private String visitantName;
	private String company;
	private String phone;
	private int securityPass;            
	private int visitNumber;            
	private Timestamp securityInTime;                
	private Timestamp securityOutTime;                
	private int securityState;            
	private String work; 
	private int memberNumber;
	
	public ListSecurityBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListSecurityBean(ResultSet resultSet) throws SQLException {
		this.securityPass = resultSet.getInt("SECURITYPASS");
		this.visitNumber = resultSet.getInt("VISITNUMBER");
		this.securityInTime = resultSet.getTimestamp("SECURITYINTIME");
		this.securityOutTime = resultSet.getTimestamp("SECURITYOUTTIME");
		this.securityState = resultSet.getInt("SECURITYSTATE");
		this.work = resultSet.getString("WORK");
		this.memberNumber = resultSet.getInt("MEMBERNUMBER");
		this.visitantName = resultSet.getString("VISITANTNAME");
		this.company = resultSet.getString("COMPANY");
		this.phone = resultSet.getString("PHONE");
	}
	
	
	public String getVisitantName() {
		return visitantName;
	}
	public void setVisitantName(String visitantName) {
		this.visitantName = visitantName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSecurityPass() {
		return securityPass;
	}
	public void setSecurityPass(int securityPass) {
		this.securityPass = securityPass;
	}
	public int getVisitNumber() {
		return visitNumber;
	}
	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}
	public Timestamp getSecurityInTime() {
		return securityInTime;
	}
	public void setSecurityInTime(Timestamp securityInTime) {
		this.securityInTime = securityInTime;
	}
	public Timestamp getSecurityOutTime() {
		return securityOutTime;
	}
	public void setSecurityOutTime(Timestamp securityOutTime) {
		this.securityOutTime = securityOutTime;
	}
	public int getSecurityState() {
		return securityState;
	}
	public void setSecurityState(int securityState) {
		this.securityState = securityState;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	

		
}
