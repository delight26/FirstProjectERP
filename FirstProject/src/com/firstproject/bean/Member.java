package com.firstproject.bean;

public class Member {

	private int membernumber;
	private String name;
	private String birthday;
	private String hiredate;
	private String password;
	private String adress;
	private String phonenumber;
	private int departmentnumber;
	private int managernumber;
	private int jobnumber;
	private String dname;
	private String jobname;
	private String photo;
	
	
	public Member() { }
	
	public Member(String name, String phonenumber, String dname, String jobname, String photo) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.dname = dname;
		this.jobname = jobname;
		this.photo = photo;
	}
	
	public Member(int membernumber, String name, String password, String phonenumber, String birthday, String hiredate, String adress, int departmentnumber, int managernumber, int jobnumber, String photo) {
		
		this.membernumber = membernumber;
		this.name = name;
		this.birthday = birthday;
		this.hiredate = hiredate;
		this.password = password;
		this.adress = adress;
		this.phonenumber = phonenumber;
		this.departmentnumber = departmentnumber;
		this.managernumber = managernumber;
		this.jobnumber = jobnumber;
		this.photo = photo;
	}
	
	public Member(String name, String password, String phonenumber, String birthday, String hiredate, String adress, int departmentnumber, int managernumber, int jobnumber,String photo) {
		
		this.name = name;
		this.birthday = birthday;
		this.hiredate = hiredate;
		this.password = password;
		this.adress = adress;
		this.phonenumber = phonenumber;
		this.departmentnumber = departmentnumber;
		this.managernumber = managernumber;
		this.jobnumber = jobnumber;
		this.photo = photo;
	}
	
	public Member(int membernumber, String name, String dname, String jobname, String phonenumber, String adress) {
		this.membernumber = membernumber;
		this.name = name;
		this.dname = dname;
		this.jobname = jobname;
		this.phonenumber = phonenumber;
		this.adress = adress;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public int getMembernumber() {
		return membernumber;
	}

	public void setMembernumber(int membernumber) {
		this.membernumber = membernumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getDepartmentnumber() {
		return departmentnumber;
	}

	public void setDepartmentnumber(int departmentnumber) {
		this.departmentnumber = departmentnumber;
	}

	public int getManagernumber() {
		return managernumber;
	}

	public void setManagernumber(int managernumber) {
		this.managernumber = managernumber;
	}

	public int getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(int jobnumber) {
		this.jobnumber = jobnumber;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
}
