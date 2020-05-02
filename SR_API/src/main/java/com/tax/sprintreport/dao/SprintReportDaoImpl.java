package com.tax.sprintreport.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.repository.SprintReportRepository;

@Service
public class SprintReportDaoImpl implements SprintReportDao{

	@Autowired
	SprintReportRepository sprintReportRepo;
	
	@Override
	public List<SprintReportEntity> getSprintReport(String teamID, int sprintNum) {
		  return sprintReportRepo.getSprintReport(teamID, sprintNum);
	
	}

}
