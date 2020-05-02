package com.tax.sprintreport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.SprintReportDao;
import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.param.SprintReportResponse;

@Service
public class SprintReportServiceImpl implements SprintReportService{

	@Autowired
	SprintReportDao sprintReportDao;
	
private List<SprintReportResponse> buildSprintReportResponse(List<SprintReportEntity> sprintReportEntity){
		
		List<SprintReportResponse> SprintReportResponse = new ArrayList<SprintReportResponse>();
		
		//Build a flat Json object to send to client (avoid sending composite json object to client)
		SprintReportResponse = sprintReportEntity.stream().map(
				sprintReport -> new SprintReportResponse(
						sprintReport.getSprintReportEntitykey().getTeamID(),
						sprintReport.getSprintReportEntitykey().getSprintNum(),
						sprintReport.getSprintStartdate(),
						sprintReport.getSprintEnddate(),
						sprintReport.getPlanned_PBI_Completed(),
						sprintReport.getPlanned_PBI_NotCompleted(),
						sprintReport.getPlannedBugCompleted(),
						sprintReport.getPlannedBugNotCompleted(),
						sprintReport.getAddon_PBI_completed(),
						sprintReport.getAddonBugCompleted(),
						sprintReport.getReason1(),
						sprintReport.getReason2(),
						sprintReport.getReason3(),
						sprintReport.getReason4(),
						sprintReport.getReason5(),
						sprintReport.getReasonOther(),
						sprintReport.getSupportInd(),
						sprintReport.getValueInd(),
						sprintReport.getNewValueInd(),
						sprintReport.getRunInd(),
						sprintReport.getGrowInd(),
						sprintReport.getSprintCapacity(),
						sprintReport.getPlanned_capacity(),
						sprintReport.getActualCapacity(),
						sprintReport.getEstimatedHours(),
						sprintReport.getCompletedHours(),
						sprintReport.getCreateDate(),
						sprintReport.getLastUpdDate()
						)
				).collect(Collectors.toList());
		System.out.println(SprintReportResponse);
		return SprintReportResponse;
	}
	
	
	
	
	@Override
	public List<SprintReportResponse> getSprintReport(String teamID, int sprintNum) {
		return buildSprintReportResponse(sprintReportDao.getSprintReport(teamID,sprintNum));
		
	}

	@Override
	public List<SprintReportResponse> getLastSprintReportByTeamID(String teamID) {
		return buildSprintReportResponse(sprintReportDao.getLastSprintReportByTeamID(teamID));

		
	}

}
