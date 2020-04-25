package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.OTRequestEntity;
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
	public List<OTRequestEntity> getOTRequestsAll(){
		return otRequestService.getOTRequestsAll();
	}
	
	//********************
	// Add Request
	//*******************
	@PostMapping("/otrequest/add")
	public OTRequestEntity addOTRequest(@RequestBody OTRequestEntity otRequestEntity) {
		return otRequestService.addOTRequest(otRequestEntity);
	}

}
