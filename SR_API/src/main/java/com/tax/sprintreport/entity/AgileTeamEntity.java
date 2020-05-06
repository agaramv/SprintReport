package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_agile_team")
public class AgileTeamEntity {

	@Id
	private String team_id;
	
	@Column(name="team_desc")
	private String team_desc;

	@Column(name="parent_team_id")
	private String parent_team_id;
	
	@Column(name="Project_ind")
	private String Project_nd;
	
	@Column(name="scrum_master_email")
	private String scrum_master_email;

	public AgileTeamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgileTeamEntity(String team_id, String team_desc, String parent_team_id, String project_nd,
			String scrum_master_email) {
		super();
		this.team_id = team_id;
		this.team_desc = team_desc;
		this.parent_team_id = parent_team_id;
		this.Project_nd = project_nd;
		this.scrum_master_email = scrum_master_email;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_desc() {
		return team_desc;
	}

	public void setTeam_desc(String team_desc) {
		this.team_desc = team_desc;
	}

	public String getParent_team_id() {
		return parent_team_id;
	}

	public void setParent_team_id(String parent_team_id) {
		this.parent_team_id = parent_team_id;
	}

	public String getProject_nd() {
		return Project_nd;
	}

	public void setProject_nd(String project_nd) {
		Project_nd = project_nd;
	}

	public String getScrum_master_email() {
		return scrum_master_email;
	}

	public void setScrum_master_email(String scrum_master_email) {
		this.scrum_master_email = scrum_master_email;
	}

}
