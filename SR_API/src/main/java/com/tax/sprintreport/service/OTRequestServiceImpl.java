package com.tax.sprintreport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.OTRequestDao;
import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.entity.OTRequestEntityKey;
import com.tax.sprintreport.param.OTRequestResponse;


@Service
public class OTRequestServiceImpl implements OTRequestService{

	@Autowired
	OTRequestDao otRequestDao;
	
	public OTRequestServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*****Construct Response ******/
	
	private List<OTRequestResponse> buildOTRequestResponse(List<OTRequestEntity> OTRequestEntity){
		
		List<OTRequestResponse> OTRequestResponse = new ArrayList<OTRequestResponse>();

		//Build a flat Jason object to send to client (avoid sending composite json object to client)
		OTRequestResponse = OTRequestEntity.stream().map(
				OTRequest -> new OTRequestResponse(
						OTRequest.getOTRequestEntityKey().getCategory(),
						OTRequest.getOTRequestEntityKey().getRequestID(),
						OTRequest.getRequestShortDesc(),
						OTRequest.getRequestDesc(),
						OTRequest.getDateStarted(),
						OTRequest.getDateCompleted(),
						OTRequest.getDateImplemeted(),
						OTRequest.getOutcome(),
						OTRequest.getStatus()
						)).collect(Collectors.toList());
		System.out.println(OTRequestResponse);
		return OTRequestResponse;
	}
	
	@Override
	public OTRequestEntity addOTRequest(OTRequestResponse otRequestResponse) {
		
		OTRequestEntityKey otRequestEntityKey = new OTRequestEntityKey(
				otRequestResponse.getCategory(),
				otRequestResponse.getRequest_id()
				);
		
		OTRequestEntity otRequestEntity= new OTRequestEntity(
				otRequestEntityKey,
				otRequestResponse.getRequestShortDesc(),
				otRequestResponse.getRequestDesc(),
				otRequestResponse.getDateStarted(),
				otRequestResponse.getDateCompleted(),
				otRequestResponse.getDateImplemented(),
				otRequestResponse.getOutcome(),
				otRequestResponse.getStatus()
				);
				
		return otRequestDao.addOTRequest(otRequestEntity);
	}

	@Override
	public List<OTRequestResponse> getOTRequestsAll() {
		return buildOTRequestResponse(otRequestDao.getOTRequestsAll());
	}

	@Override
	public List<OTRequestResponse> getOTRequestsOTR() {
		return buildOTRequestResponse(otRequestDao.getOTRequestsOTR());
	}

	@Override
	public List<OTRequestResponse> getOTRequestsITR() {
		return buildOTRequestResponse(otRequestDao.getOTRequestsITR());
	}
	

}
