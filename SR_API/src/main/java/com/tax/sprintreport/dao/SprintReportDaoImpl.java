package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.repository.SprintReportRepository;

public class SprintReportDaoImpl implements SprintReportDao{

	
	SprintReportRepository sprintReportRepo;
	
	@Override
	public List<SprintReportEntity> getSprintReport() {
		  return sprintReportRepo.getSprintReport();
	
	}

}
