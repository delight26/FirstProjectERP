package com.firstproject.bean;

public class ProjectManager {
	private int projectNumber;
	private int percent;
	private String projectName;
	private String manager;
	private String startDate;
	private String endDate;
	private String comment;

	public ProjectManager() {

	}

	public ProjectManager(int projectNumber, String projectName, String manager, String comment,String startDate,
			String endDate, int percent) {
		this.projectNumber = projectNumber;
		this.percent = percent;
		this.projectName = projectName;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
	}
	public ProjectManager(String projectName, String manager, String comment, String startDate,
			String endDate) {
		this.projectName = projectName;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
	}
	public ProjectManager(int projectNumber, String projectName, String manager, String comment,String startDate,
			String endDate) {
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
	}
	public int getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
