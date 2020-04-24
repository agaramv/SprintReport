package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.OTRequestEntity;

public interface OTRequestService {

	//Get OT Requests that are Active
	public List<OTRequestEntity> getOTRequestsAll();
	
	//Add ot request
	public OTRequestEntity addOTRequest(OTRequestEntity otRequestEntity);
}
