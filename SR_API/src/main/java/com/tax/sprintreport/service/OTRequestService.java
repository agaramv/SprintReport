package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.param.OTRequestResponse;

public interface OTRequestService {

	//Get OT Requests that are Active
	public List<OTRequestResponse> getOTRequestsAll();
	
	//Get OTRs 
	public List<OTRequestResponse> getOTRequestsOTR();

	//Get ITRs 
	public List<OTRequestResponse> getOTRequestsITR();
	
	//Add ot request
	public OTRequestEntity addOTRequest(OTRequestResponse otRequestResponse);
}
