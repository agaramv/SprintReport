/**
 * 
 */
package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="r_form_ui")
public class FormUIEntity {
	
	@EmbeddedId
	FormUIEntityKey formUiEntityKey; 
	
	@Column(name="work_desc")
	private String workDesc; 
	
	public FormUIEntity() {
		super();
	}

	public FormUIEntity(String workDesc) {
		super();
		this.workDesc = workDesc;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}
	
	
}
