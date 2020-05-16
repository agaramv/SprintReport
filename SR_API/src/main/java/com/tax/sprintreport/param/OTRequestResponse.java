package com.tax.sprintreport.param;

import java.time.LocalDate;

public class OTRequestResponse {
	
	private String Category;
	private String request_id; 
	private String requestShortDesc;
	private String requestDesc;
	private LocalDate dateStarted;
	private LocalDate dateCompleted;
	private LocalDate dataImplemented;
	private String outcome;
	private String status;
	
	
	public OTRequestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OTRequestResponse(String category, String request_id, String requestShortDesc, String requestDesc,
			LocalDate dateStarted, LocalDate dateCompleted, LocalDate dataImplemented, String outcome, String status) {
		super();
		Category = category;
		this.request_id = request_id;
		this.requestShortDesc = requestShortDesc;
		this.requestDesc = requestDesc;
		this.dateStarted = dateStarted;
		this.dateCompleted = dateCompleted;
		this.dataImplemented = dataImplemented;
		this.outcome = outcome;
		this.status = status;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
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


	public LocalDate getDataImplemented() {
		return dataImplemented;
	}


	public void setDataImplemented(LocalDate dataImplemented) {
		this.dataImplemented = dataImplemented;
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
