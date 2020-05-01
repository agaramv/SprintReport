package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.SprintReportEntity;

public interface SprintReportDao {
	
	//Get Sprint Report by Team and Sprint Number 
	List<SprintReportEntity> getSprintReport();

}
