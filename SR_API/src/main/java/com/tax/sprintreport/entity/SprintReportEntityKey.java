package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SprintReportEntityKey {

	private static final long serialVersionUID = 1L;

	@Column(name="team_id")
	private String teamID;
	
	@Column(name="sprint_num")
	private int sprintNum;

	public SprintReportEntityKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SprintReportEntityKey(String teamID, int sprintNum) {
		super();
		this.teamID = teamID;
		this.sprintNum = sprintNum;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public int getSprintNum() {
		return sprintNum;
	}

	public void setSprintNum(int sprintNum) {
		this.sprintNum = sprintNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
