package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_scrum_master")
public class ScrumMasterEntity {

	@Id
	private String email;
	
	@Column(name="display_name")
	private String displayName;
	
	public ScrumMasterEntity() {
		// TODO Auto-generated constructor stub
	}

	public ScrumMasterEntity(String email, String displayName) {
		super();
		this.email = email;
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
