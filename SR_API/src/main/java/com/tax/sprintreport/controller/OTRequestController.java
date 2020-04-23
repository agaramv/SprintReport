package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.service.OTRequestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OTRequestController {

	@Autowired
	OTRequestService otRequestService;
	
	@GetMapping("/otrequests/all")
	public List<OTRequestEntity> getOTRequestsAll(){
		return otRequestService.getOTRequestsAll();
	}

}
