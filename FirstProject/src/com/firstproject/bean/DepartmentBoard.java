package com.firstproject.bean;

public class DepartmentBoard {
	private String departmentName;
	private int memberNumber;
	private int postNumber;
	private String postName;
	private String postDate;
	private String content;
	private String postPassword;
	private String postCreater;
	private int postLookup;
	private int departmentnum;

	public DepartmentBoard(int postNumber, String departmentName, String postName, String postDate, String content,
			String postPassword, String postCreater, int postLookup) {
		this.departmentName = departmentName;
		this.postNumber = postNumber;
		this.postName = postName;
		this.postDate = postDate;
		this.content = content;
		this.postPassword = postPassword;
		this.postCreater = postCreater;
		this.postLookup = postLookup;
	}
	public DepartmentBoard(String postName, int memberNumber, int departmentnum, String content,String postPassword){
		this.postName = postName;
		this.memberNumber = memberNumber;
		this.departmentnum = departmentnum;
		this.content = content;
		this.postPassword = postPassword;
	}

	public DepartmentBoard(int postNumber, int departmentnum) {
		this.postNumber = postNumber;
		this.departmentnum = departmentnum;
	}
	
	public DepartmentBoard(int postNumber) {
		this.postNumber = postNumber;
	}
	
	public int getDepartmentnum() {
		return departmentnum;
	}

	public void setDepartmentnum(int departmentnum) {
		this.departmentnum = departmentnum;
	}

	public int getPostLookup() {
		return postLookup;
	}

	public void setPostLookup(int postLookup) {
		this.postLookup = postLookup;
	}

	public String getPostCreater() {
		return postCreater;
	}

	public void setPostCreater(String postCreater) {
		this.postCreater = postCreater;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostPassword() {
		return postPassword;
	}

	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
}
