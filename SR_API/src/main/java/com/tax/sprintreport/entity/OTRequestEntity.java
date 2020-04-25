package com.tax.sprintreport.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="r_ot_request")
public class OTRequestEntity {

		
	@EmbeddedId
	OTRequestEntityKey OTRequestEntityKey;
	
	@Column(name="request_desc")
	private String requestDesc;
	
	@Column(name="outcome")
	private String outcome;
	
	@Column(name="status")
	private String status;
	
	public OTRequestEntity() {
		// TODO Auto-generated constructor stub
	}

	

	public OTRequestEntity(com.tax.sprintreport.entity.OTRequestEntityKey oTRequestEntityKey, String requestDesc,
			String outcome, String status) {
		super();
		OTRequestEntityKey = oTRequestEntityKey;
		this.requestDesc = requestDesc;
		this.outcome = outcome;
		this.status = status;
	}



	public OTRequestEntityKey getOTRequestEntityKey() {
		return OTRequestEntityKey;
	}

	public void setOTRequestKey(OTRequestEntityKey oTRequestKey) {
		OTRequestEntityKey = oTRequestKey;
	}

	public String getRequestDesc() {
		return requestDesc;
	}

	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
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

