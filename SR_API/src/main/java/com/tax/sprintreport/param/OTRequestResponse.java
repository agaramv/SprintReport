package com.tax.sprintreport.param;

import javax.persistence.Column;

public class OTRequestResponse {
	
	private String Category;
	private String request_id; 
	private String req_desc;
	private String outcome;
	private String status;
	
	
	public OTRequestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OTRequestResponse(String category, String request_id, String req_desc, String outcome, String status) {
		super();
		Category = category;
		this.request_id = request_id;
		this.req_desc = req_desc;
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
