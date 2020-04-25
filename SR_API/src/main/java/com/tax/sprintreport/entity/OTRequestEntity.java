package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="r_ot_request")
public class OTRequestEntity {

		
	@EmbeddedId
	OTRequestEntityKey OTRequestKey;
	
	@Column(name="request_desc")
	private String req_desc;
	
	@Column(name="outcome")
	private String outcome;
	
	@Column(name="status")
	private String status;
	
	public OTRequestEntity() {
		// TODO Auto-generated constructor stub
	}

	
	public OTRequestEntity(OTRequestEntityKey oTRequestKey, String req_desc, String outcome, String status) {
		super();
		OTRequestKey = oTRequestKey;
		this.req_desc = req_desc;
		this.outcome = outcome;
		this.status = status;
	}


	public OTRequestEntityKey getOTRequestKey() {
		return OTRequestKey;
	}


	public void setOTRequestKey(OTRequestEntityKey oTRequestKey) {
		OTRequestKey = oTRequestKey;
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
