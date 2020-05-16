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
	// Add Request
	//*******************
	@PostMapping("/otrequest/add")
	public OTRequestEntity addOTRequest(@RequestBody OTRequestEntity otRequestEntity) {
		return otRequestService.addOTRequest(otRequestEntity);
	}
	
	//********************
	// Update Request
	//*******************
	@PutMapping("/otrequest/update")
	public OTRequestEntity updateOTRequest(@RequestBody OTRequestEntity otRequestEntity) {
		//Call the same add request function to update the information	
		//the difference is using put request
		return otRequestService.addOTRequest(otRequestEntity);
	}

}
