package com.tax.sprintreport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tax.sprintreport.dao.SprintReportDao;
import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.entity.SprintReportEntityKey;
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
						sprintReport.getScrumMasterEmail(),
						sprintReport.getPlanned_PBI_Completed(),
						sprintReport.getPlanned_PBI_NotCompleted(),
						sprintReport.getPlannedBugCompleted(),
						sprintReport.getPlannedBugNotCompleted(),
						sprintReport.getAddon_PBI_Completed(),
						sprintReport.getAddon_PBI_NotCompleted(),
						sprintReport.getAddonBugCompleted(),
						sprintReport.getAddonBugNotCompleted(),
						sprintReport.getReason1(),
						sprintReport.getReason2(),
						sprintReport.getReason3(),
						sprintReport.getReason4(),
						sprintReport.getReason5(),
						sprintReport.getReasonOther(),
						sprintReport.getSupportPBI(),
						sprintReport.getSupportBug(),
						sprintReport.getNewValuePBI(),
						sprintReport.getNewValueBug(),
						sprintReport.getImprovementPBI(),
						sprintReport.getImprovementBug(),
						sprintReport.getSprintCapacity(),
						sprintReport.getPlanned_capacity(),
						sprintReport.getActualCapacity(),
						sprintReport.getEstimatedHours(),
						sprintReport.getCompletedHours(),
						sprintReport.getCreateDate(),
						sprintReport.getLastUpdDate()
						)).collect(Collectors.toList());
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

	/*************************8
	 * Create a New Sprint Report
	 ***************************/
	@Override
	public SprintReportEntity newSprintReport(SprintReportResponse sprintReportResponse) {
		
		
		//Built primary key from response
		SprintReportEntityKey sprintReportEntityKey = new SprintReportEntityKey(
				sprintReportResponse.getTeamID(),
				sprintReportResponse.getSprintNum()
				);
		
		//Build Entity Key to save data
		SprintReportEntity sprintReportEntity = new SprintReportEntity(
				sprintReportEntityKey,
				sprintReportResponse.getSprintStartdate(),
				sprintReportResponse.getSprintEnddate(),
				sprintReportResponse.getScrumMasterEmail(),
				sprintReportResponse.getPlanned_PBI_Completed(),
				sprintReportResponse.getPlanned_PBI_NotCompleted(),
				sprintReportResponse.getPlannedBugCompleted(),
				sprintReportResponse.getPlannedBugNotCompleted(),
				sprintReportResponse.getAddon_PBI_Completed(),
				sprintReportResponse.getAddon_PBI_NotCompleted(),
				sprintReportResponse.getAddonBugCompleted(),
				sprintReportResponse.getAddonBugNotCompleted(),
				sprintReportResponse.getReason1(),
				sprintReportResponse.getReason2(),
				sprintReportResponse.getReason3(),
				sprintReportResponse.getReason4(),
				sprintReportResponse.getReason5(),
				sprintReportResponse.getReasonOther(),
				sprintReportResponse.getSupportPBI(),
				sprintReportResponse.getSupportBug(),
				sprintReportResponse.getNewValuePBI(),
				sprintReportResponse.getNewValueBug(),
				sprintReportResponse.getImprovementPBI(),
				sprintReportResponse.getImprovementBug(),
				sprintReportResponse.getSprintCapacity(),
				sprintReportResponse.getPlannedCapacity(),
				sprintReportResponse.getActualCapacity(),
				sprintReportResponse.getEstimatedHours(),
				sprintReportResponse.getCompletedHours(),
				sprintReportResponse.getCreateDate(),
				sprintReportResponse.getLastUpdDate()
				);
		
		   return sprintReportDao.newSprintReport(sprintReportEntity);
	}

}
