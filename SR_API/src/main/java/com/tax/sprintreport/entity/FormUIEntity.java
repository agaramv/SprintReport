/**
 * 
 */
package com.tax.sprintreport.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="r_form_ui")
public class FormUIEntity {
	
	@EmbeddedId
	FormUIEntityKey formUiEntityKey;  
	
	@Column(name="active_ind")
	private String activeInd; 
	
	@Column(name="work_code")
	private String workCode; 
	
	@Column(name="work_desc")
	private String workDesc; 
	
	@Column(name="info_type")
	private String infoType; 
	
	@Column(name="support_ind")
	private String supportInd;
	
	@Column(name="value_ind")
	private String valueInd;
	
	@Column(name="new_value_ind")
	private String newValueInd;
	
	@Column(name="run_ind")
	private String runInd;
	
	@Column(name="grow_ind")
	private String growInd;
	
	@Column(name="transform_ind")
	private String transformInd;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="last_upd_date")
	private LocalDateTime lastUpdDate;
	
	public FormUIEntity() {
		super();
	}


	public FormUIEntity(FormUIEntityKey formUiEntityKey, String activeInd, String workCode, String workDesc,
			String infoType, String supportInd, String valueInd, String newValueInd, String runInd, String growInd,
			String transformInd, LocalDateTime createDate, LocalDateTime lastUpdDate) {
		super();
		this.formUiEntityKey = formUiEntityKey;
		this.activeInd = activeInd;
		this.workCode = workCode;
		this.workDesc = workDesc;
		this.infoType = infoType;
		this.supportInd = supportInd;
		this.valueInd = valueInd;
		this.newValueInd = newValueInd;
		this.runInd = runInd;
		this.growInd = growInd;
		this.transformInd = transformInd;
		this.createDate = createDate;
		this.lastUpdDate = lastUpdDate;
	}



	public FormUIEntityKey getFormUiEntityKey() {
		return formUiEntityKey;
	}

	public void setFormUiEntityKey(FormUIEntityKey formUiEntityKey) {
		this.formUiEntityKey = formUiEntityKey;
	}

	public String getActiveInd() {
		return activeInd;
	}


	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}


	public String getWorkCode() {
		return workCode;
	}


	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}


	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getSupportInd() {
		return supportInd;
	}

	public void setSupportInd(String supportInd) {
		this.supportInd = supportInd;
	}

	public String getValueInd() {
		return valueInd;
	}

	public void setValueInd(String valueInd) {
		this.valueInd = valueInd;
	}

	public String getNewValueInd() {
		return newValueInd;
	}

	public void setNewValueInd(String newValueInd) {
		this.newValueInd = newValueInd;
	}

	public String getRunInd() {
		return runInd;
	}

	public void setRunInd(String runInd) {
		this.runInd = runInd;
	}

	public String getGrowInd() {
		return growInd;
	}

	public void setGrowInd(String growInd) {
		this.growInd = growInd;
	}

	public String getTransformInd() {
		return transformInd;
	}

	public void setTransformInd(String transformInd) {
		this.transformInd = transformInd;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(LocalDateTime lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

		
}
