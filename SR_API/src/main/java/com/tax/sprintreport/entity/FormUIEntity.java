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
	
	@Column(name="active_ind")
	private char activeInd; 
	
	@Column(name="work_code")
	private String workCode; 
	
	@Column(name="work_desc")
	private String workDesc; 
	
	@Column(name="info_type")
	private char infoType; 
	
	@Column(name="support_ind")
	private char supportInd;
	
	@Column(name="value_ind")
	private char valueInd;
	
	@Column(name="new_value_ind")
	private char newValueInd;
	
	@Column(name="run_ind")
	private char runInd;
	
	@Column(name="grow_ind")
	private char growInd;
	
	@Column(name="transform_ind")
	private char transfromInd;
	
	@Column(name="create_date")
	private char createDate;
	
	@Column(name="last_upd_date")
	private char lastUpdDate;
	
	public FormUIEntity() {
		super();
	}

	public FormUIEntity(FormUIEntityKey formUiEntityKey, char activeInd, String workCode, String workDesc,
			char infoType, char supportInd, char valueInd, char newValueInd, char runInd, char growInd,
			char transfromInd, char createDate, char lastUpdDate) {
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
		this.transfromInd = transfromInd;
		this.createDate = createDate;
		this.lastUpdDate = lastUpdDate;
	}

	public FormUIEntityKey getFormUiEntityKey() {
		return formUiEntityKey;
	}

	public void setFormUiEntityKey(FormUIEntityKey formUiEntityKey) {
		this.formUiEntityKey = formUiEntityKey;
	}

	public char getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(char activeInd) {
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

	public char getInfoType() {
		return infoType;
	}

	public void setInfoType(char infoType) {
		this.infoType = infoType;
	}

	public char getSupportInd() {
		return supportInd;
	}

	public void setSupportInd(char supportInd) {
		this.supportInd = supportInd;
	}

	public char getValueInd() {
		return valueInd;
	}

	public void setValueInd(char valueInd) {
		this.valueInd = valueInd;
	}

	public char getNewValueInd() {
		return newValueInd;
	}

	public void setNewValueInd(char newValueInd) {
		this.newValueInd = newValueInd;
	}

	public char getRunInd() {
		return runInd;
	}

	public void setRunInd(char runInd) {
		this.runInd = runInd;
	}

	public char getGrowInd() {
		return growInd;
	}

	public void setGrowInd(char growInd) {
		this.growInd = growInd;
	}

	public char getTransfromInd() {
		return transfromInd;
	}

	public void setTransfromInd(char transfromInd) {
		this.transfromInd = transfromInd;
	}

	public char getCreateDate() {
		return createDate;
	}

	public void setCreateDate(char createDate) {
		this.createDate = createDate;
	}

	public char getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(char lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

		
}
