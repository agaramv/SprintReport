package com.tax.sprintreport.param;

import java.time.LocalDate;

public class OTRequestResponse {
	
	private String category;
	private String request_id; 
	private String requestShortDesc;
	private String requestDesc;
	private LocalDate dateStarted;
	private LocalDate dateCompleted;
	private LocalDate dateImplemented;
	private String outcome;
	private String status;
	
	
	public OTRequestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OTRequestResponse(String category, String request_id, String requestShortDesc, String requestDesc,
			LocalDate dateStarted, LocalDate dateCompleted, LocalDate dateImplemented, String outcome, String status) {
		super();
		this.category = category;
		this.request_id = request_id;
		this.requestShortDesc = requestShortDesc;
		this.requestDesc = requestDesc;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
		this.dateImplemented = dateImplemented;
		this.outcome = outcome;
		this.status = status;
	}


	public String getCategory() {
		return this.category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getRequest_id() {
		return request_id;
	}


	public void setRequest_id(String request_id) {
		this.request_id = request_id;
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


	public LocalDate getDateImplemented() {
		return dateImplemented;
	}


	public void setDateImplemented(LocalDate dateImplemented) {
		this.dateImplemented = dateImplemented;
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
