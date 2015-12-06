package com.firstproject.bean;

public class NoticeBoard {
	private int noticeNumber;
	private String noticeName;
	private String noticeContent;
	private String noticePassword;
	private String noticeCreater;
	private String noticeDate;
	private int noticeLookup;

	public NoticeBoard(){
		
	}
	
	public NoticeBoard(String noticeName, String noticeContent, int noticeNumber){
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.noticeNumber = noticeNumber;
	}
	
	public NoticeBoard(String noticeName, String noticeContent, String noticePassword){
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.noticePassword = noticePassword;
	}
	
	public NoticeBoard(int noticeNumber, String noticeName, String noticeContent, String noticePassword
			, String noticeCreater, String noticeDate, int noticeLookup){
		this.noticeNumber = noticeNumber;
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.noticePassword = noticePassword;
		this.noticeCreater = noticeCreater;
		this.noticeDate = noticeDate;
		this.noticeLookup = noticeLookup;
	}
	
	public NoticeBoard(int noticeNumber, String noticeName, String noticeCreator,String noticeDate,
			int noticeLookup) {
		this.noticeNumber = noticeNumber;
		this.noticeName = noticeName;
		this.noticeDate = noticeDate;
		this.noticeCreater = noticeCreator;
		this.noticeLookup = noticeLookup;
	}

	public NoticeBoard(int noticeNumber){
		this.noticeNumber = noticeNumber;
	}
	
	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticePassword() {
		return noticePassword;
	}

	public void setNoticePassword(String noticePassword) {
		this.noticePassword = noticePassword;
	}

	public String getNoticeCreater() {
		return noticeCreater;
	}

	public void setNoticeCreater(String noticeCreater) {
		this.noticeCreater = noticeCreater;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeLookup() {
		return noticeLookup;
	}

	public void setNoticeLookup(int noticeLookup) {
		this.noticeLookup = noticeLookup;
	}
}
