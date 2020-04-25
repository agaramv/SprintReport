package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_agile_team")
public class AgileTeamEntity {

	@Id
	String team_id;
	
	@Column(name="team_desc")
	private String teamDesc;

	@Column(name="parent_team_id")
	private String parentTeamId;
	
	@Column(name="Project_ind")
	private String projectInd;
	
	@Column(name="scrum_master_email")
	private String scrumMasterEmail;

	public AgileTeamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgileTeamEntity(String team_id, String teamDesc, String parentTeamId, String projectInd,
			String scrumMasterEmail) {
		super();
		this.team_id = team_id;
		this.teamDesc = teamDesc;
		this.parentTeamId = parentTeamId;
		this.projectInd = projectInd;
		this.scrumMasterEmail = scrumMasterEmail;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeamDesc() {
		return teamDesc;
	}

	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}

	public String getParentTeamId() {
		return parentTeamId;
	}

	public void setParentTeamId(String parentTeamId) {
		this.parentTeamId = parentTeamId;
	}

	public String getProjectInd() {
		return projectInd;
	}

	public void setProjectInd(String projectInd) {
		this.projectInd = projectInd;
	}

	public String getScrumMasterEmail() {
		return scrumMasterEmail;
	}

	public void setScrumMasterEmail(String scrumMasterEmail) {
		this.scrumMasterEmail = scrumMasterEmail;
	}
	
}
