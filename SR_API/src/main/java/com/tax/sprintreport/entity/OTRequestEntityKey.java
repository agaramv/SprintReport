package com.tax.sprintreport.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OTRequestEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="category")
	String category;

	@Column(name="request_id")
	String requestID;

	public OTRequestEntityKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OTRequestEntityKey(String category, String requestID) {
		super();
		this.category = category;
		this.requestID = requestID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}



    

}
