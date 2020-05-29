package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.param.OTRequestResponse;
import com.tax.sprintreport.service.OTRequestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OTRequestController {

	@Autowired
	OTRequestService otRequestService;
	
	//********************
	// Get Active Requests
	//********************	
	@GetMapping("/otrequest/all")
	public List<OTRequestResponse> getOTRequestsAll(){
		return otRequestService.getOTRequestsAll();
	}
	
	//********************
	// Get OT Requests
	//********************	
	@GetMapping("/otrequest/otr")
	public List<OTRequestResponse> getOTRequestsOTR(){
		return otRequestService.getOTRequestsOTR();
	}
	
	//********************
	// Get IT Requests
	//********************	
	@GetMapping("/otrequest/itr")
	public List<OTRequestResponse> getOTRequestsITR(){
		return otRequestService.getOTRequestsITR();
	}
	
	//********************
	// Add Request
	//*******************
	@PostMapping("/otrequest/add")
	public OTRequestEntity addOTRequest(@RequestBody OTRequestResponse otRequestResponse) {
		return otRequestService.addOTRequest(otRequestResponse);
	}
	
	//********************
	// Update Request
	//*******************
	@PutMapping("/otrequest/update")
	public OTRequestEntity updateOTRequest(@RequestBody OTRequestResponse otRequestResponse) {
		//Call the same add request function to update the information	
		//the difference is using put request
		return otRequestService.addOTRequest(otRequestResponse);
	}

}
