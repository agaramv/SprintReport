package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.service.SprintReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SprintReportController {

	@Autowired
	SprintReportService sprintReportService;
	
	@GetMapping("/sprintreport/last")
	public List<SprintReportEntity> getSprintReport() {
		return sprintReportService.getSprintReport();
	}
}
