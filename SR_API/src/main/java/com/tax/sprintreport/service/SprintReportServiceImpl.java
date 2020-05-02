package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.SprintReportDao;
import com.tax.sprintreport.entity.SprintReportEntity;

@Service
public class SprintReportServiceImpl implements SprintReportService{

	@Autowired
	SprintReportDao sprintReportDao;
	
	@Override
	public List<SprintReportEntity> getSprintReport(String teamID, int sprintNum) {
		return sprintReportDao.getSprintReport(teamID,sprintNum);
		
	}

	@Override
	public List<SprintReportEntity> getLastSprintReportByTeamID(String teamID) {
		return sprintReportDao.getLastSprintReportByTeamID(teamID);

		
	}

}
