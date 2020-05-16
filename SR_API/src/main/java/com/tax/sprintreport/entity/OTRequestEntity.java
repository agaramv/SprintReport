package com.tax.sprintreport.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="r_ot_request")
public class OTRequestEntity {

		
	@EmbeddedId
	OTRequestEntityKey OTRequestEntityKey;
	
	@Column(name="request_short_desc")
	private String requestShortDesc;
	
	@Column(name="request_desc")
	private String requestDesc;
	
	@Column(name="date_started")
	private LocalDate dateStarted;
	
	@Column(name="date_completed")
	private LocalDate dateCompleted;
	
	@Column(name="date_implemented")
	private LocalDate dateImplemeted;
	
	@Column(name="outcome")
	private String outcome;
	
	@Column(name="status")
	private String status;
	
	public OTRequestEntity() {
		// TODO Auto-generated constructor stub
	}

	public OTRequestEntity(com.tax.sprintreport.entity.OTRequestEntityKey oTRequestEntityKey, String requestShortDesc,
			String requestDesc, LocalDate dateStarted, LocalDate dateCompleted, LocalDate dateImplemeted,
			String outcome, String status) {
		super();
		OTRequestEntityKey = oTRequestEntityKey;
		this.requestShortDesc = requestShortDesc;
		this.requestDesc = requestDesc;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
		this.dateImplemeted = dateImplemeted;
		this.outcome = outcome;
		this.status = status;
	}

	public OTRequestEntityKey getOTRequestEntityKey() {
		return OTRequestEntityKey;
	}

	public void setOTRequestEntityKey(OTRequestEntityKey oTRequestEntityKey) {
		OTRequestEntityKey = oTRequestEntityKey;
	}

	public String getRequestShortDesc() {
		return requestShortDesc;
	}

	public void setRequestShortDesc(String requestShortDesc) {
		this.requestShortDesc = requestShortDesc;
	}

	public String getRequestDesc() {
		return requestDesc;
	}

	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}

	public LocalDate getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public LocalDate getDateImplemeted() {
		return dateImplemeted;
	}

	public void setDateImplemeted(LocalDate dateImplemeted) {
		this.dateImplemeted = dateImplemeted;
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

