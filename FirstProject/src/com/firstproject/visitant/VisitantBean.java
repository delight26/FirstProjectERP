package com.firstproject.visitant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VisitantBean {

	private int visitnumber;    
	private Timestamp inTime;     
	private int passNum;
	private String visitantName;
	private String company;
	private String phone;
	private Timestamp outTime;
	private int state;
	
	public VisitantBean() {
		// TODO Auto-generated constructor stub
	}
	
	public VisitantBean(ResultSet resultSet) throws SQLException {
		this.visitnumber = resultSet.getInt("VISITNUMBER");
		this.inTime = resultSet.getTimestamp("INTIME");
		this.passNum = resultSet.getInt("PASSNUM");
		this.visitantName = resultSet.getString("VISITANTNAME");
		this.company = resultSet.getString("COMPANY");
		this.phone = resultSet.getString("PHONE");
		this.outTime = resultSet.getTimestamp("OUTTIME");
		this.state = resultSet.getInt("STATE");
	}

	public VisitantBean(int visitnumber, Timestamp inTime, int passNum, String visitantName, String company,
			String phone, Timestamp outTime, int state) {
		super();
		this.visitnumber = visitnumber;
		this.inTime = inTime;
		this.passNum = passNum;
		this.visitantName = visitantName;
		this.company = company;
		this.phone = phone;
		this.outTime = outTime;
		this.state = state;
	}

	public int getVisitnumber() {
		return visitnumber;
	}

	public void setVisitnumber(int visitnumber) {
		this.visitnumber = visitnumber;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public int getPassNum() {
		return passNum;
	}

	public void setPassNum(int passNum) {
		this.passNum = passNum;
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

	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
