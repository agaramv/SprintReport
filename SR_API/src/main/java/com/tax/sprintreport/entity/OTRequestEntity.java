package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_ot_request")
public class OTRequestEntity {

	@Id
	long entry_id;
	
	@Column(name="category")
	private String category;
	
	@Column(name="req_id")
	private String req_id;
	
	@Column(name="req_desc")
	private String req_desc;
	
	@Column(name="outcome")
	private String outcome;
	
	@Column(name="status")
	private String status;
	
	public OTRequestEntity() {
		// TODO Auto-generated constructor stub
	}

	public OTRequestEntity(long entry_id, String category, String req_id, String req_desc, String outcome,
			String status) {
		super();
		this.entry_id = entry_id;
		this.category = category;
		this.req_id = req_id;
		this.req_desc = req_desc;
		this.outcome = outcome;
		this.status = status;
	}

	public long getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(long entry_id) {
		this.entry_id = entry_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReq_id() {
		return req_id;
	}

	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}

	public String getReq_desc() {
		return req_desc;
	}

	public void setReq_desc(String req_desc) {
		this.req_desc = req_desc;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
