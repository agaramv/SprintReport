package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.ReasonsEntity;
import com.tax.sprintreport.service.ReasonsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReasonsController {

	@Autowired
	ReasonsService reasonsService;
	
	@GetMapping("/reasons/current")
	public List<ReasonsEntity> getReasons() {
		return reasonsService.getReasons();
	}
	
	@PostMapping("/reasons/add")
	public ReasonsEntity addReason(@RequestBody ReasonsEntity reasonsEntity) {
		return reasonsService.addReason(reasonsEntity);
	}
	
	

}
