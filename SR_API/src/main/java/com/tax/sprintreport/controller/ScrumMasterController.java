package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.ScrumMasterEntity;
import com.tax.sprintreport.service.ScrumMasterService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ScrumMasterController {

	@Autowired
	ScrumMasterService scrumMasterService;

	@GetMapping("/scrummaster/email/all")
	public List<ScrumMasterEntity> getScrumMasterEmails(){
		return scrumMasterService.getScrumMasterEmails();
	}
	
	@PostMapping("/scrummaster/email/add")
	public ScrumMasterEntity addScrumMasterEmail(@RequestBody ScrumMasterEntity scrumMasterEntity) {
		return scrumMasterService.addScrumMasterEmail(scrumMasterEntity);
	}
	
	
}
