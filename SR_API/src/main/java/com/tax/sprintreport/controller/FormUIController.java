package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.service.FormUIService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FormUIController {
	
	@Autowired
	FormUIService formUiService;

	@GetMapping("/sprintreport/form")
	public List<FormUIEntity> getSprintReportForm(){
		return formUiService.getSprintReportForm();
	}

}
