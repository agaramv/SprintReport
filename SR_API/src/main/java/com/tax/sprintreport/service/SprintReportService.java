package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.SprintReportEntity;

public interface SprintReportService {
	
	//Get Service by Team and Sprint Number 
	
	List<SprintReportEntity> getSprintReport(String teamID, int sprintNum);

}
