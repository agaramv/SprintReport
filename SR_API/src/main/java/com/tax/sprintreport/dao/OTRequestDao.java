package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.OTRequestEntity;

public interface OTRequestDao {

	//Get All OT Requests that are Active
	public List<OTRequestEntity> getOTRequestsAll();
	
	//Add OT Request
	public OTRequestEntity addOTRequest(OTRequestEntity otRequestEntity);
	
}
