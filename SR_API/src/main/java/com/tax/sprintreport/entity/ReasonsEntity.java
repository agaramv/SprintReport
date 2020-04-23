package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_reasons")
public class ReasonsEntity {

	@Id
	private String code;
	
	@Column(name="reason_desc")
	private String reason_desc;
	
	@Column(name="history_ind")
	private String history_ind;
	
	public ReasonsEntity() {
		// TODO Auto-generated constructor stub
	}

	public ReasonsEntity(String code, String reason_desc, String history_ind) {
		super();
		this.code = code;
		this.reason_desc = reason_desc;
		this.history_ind = history_ind;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public String getHistory_ind() {
		return history_ind;
	}

	public void setHistory_ind(String history_ind) {
		this.history_ind = history_ind;
	}

}
