package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.param.SprintReportResponse;

public interface SprintReportService {
	
	//Get Service by Team and Sprint Number 
	List<SprintReportResponse>getSprintReport(String teamID, int sprintNum);
	
	//Get last sprint report by Team ID 
	List<SprintReportResponse>getLastSprintReportByTeamID(String teamID);
	
	//New Sprint Report
	SprintReportEntity newSprintReport(SprintReportResponse sprintReportResponse);

}
