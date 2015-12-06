package com.firstproject.bean;

public class DocumentApproval {
	private int documentNumber;
	private String documentName;
	private String documentCreater;
	private String documentContent;
	private String managerName;
	private int managerNumber;
	private int memberNumber;
	private int state;
	private String createDate;
	private String password;
	private String filePath;

	public DocumentApproval() {

	}

	public DocumentApproval(int documentNumber, String documentName, String documentCreater, String documentContent 
			 , String managerName, int state, String createDate, String password) {
		this.documentNumber = documentNumber;
		this.documentName = documentName;
		this.documentCreater = documentCreater;
		this.managerName = managerName;
		this.state = state;
		this.createDate = createDate;
		this.password = password;
		this.documentContent = documentContent;
	}
	public DocumentApproval(String documentName, int managerNumber, int memberNumber, String documentContent
			,String password, String filePath){
		this.documentName = documentName;
		this.managerNumber = managerNumber;
		this.memberNumber = memberNumber;
		this.documentContent = documentContent;
		this.password = password;
		this.filePath = filePath;
	}
	
	
	
	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentCreater() {
		return documentCreater;
	}

	public void setDocumentCreater(String documentCreater) {
		this.documentCreater = documentCreater;
	}

	public String getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(String documentContent) {
		this.documentContent = documentContent;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
}
