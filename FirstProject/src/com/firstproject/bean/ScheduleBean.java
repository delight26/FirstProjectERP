package com.firstproject.bean;

public class ScheduleBean {
	
	private String scheduleNumber;
	private String scheduleDate;
	private String scheduleTitle;
	private String scheduleContent;
	private String scheduleCreaotr;
	private int memberNumber;
	
	public ScheduleBean() {}
	
	public ScheduleBean(String scheduleNumber, String scheduleDate, String noticeCreator,
			String scheduleTitle, String scheduleContent, String scheduleCreaotr){
		this.scheduleNumber = scheduleNumber;
		this.scheduleDate = scheduleDate;
		this.scheduleTitle = scheduleTitle;
		this.scheduleContent = scheduleContent;
		this.scheduleCreaotr = scheduleCreaotr;
	}
	
	public String getScheduleNumber() {
		return scheduleNumber;
	}
	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTitle() {
		return scheduleTitle;
	}
	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}
	public String getScheduleContent() {
		return scheduleContent;
	}
	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public String getScheduleCreaotr() {
		return scheduleCreaotr;
	}
	public void setScheduleCreaotr(String scheduleCreaotr) {
		this.scheduleCreaotr = scheduleCreaotr;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
}
