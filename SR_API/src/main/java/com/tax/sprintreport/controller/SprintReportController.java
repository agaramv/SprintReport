package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.tax.sprintreport.entity.SprintReportEntity;
import com.tax.sprintreport.service.SprintReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SprintReportController {

	@Autowired
	SprintReportService sprintReportService;
	
	/*************************************************
	 * Get Sprint Report by Team ID and Sprint Number
	 * 
	 * @param teamID
	 * @param sprintNum
	 * @return SprintReportEntity
	 **************************************************/
	
	@GetMapping("/sprintreport/byteam/{teamID}/sprintnum/{sprintNum}")
	public List<SprintReportEntity> getSprintReport(@PathVariable("teamID") String teamID, @PathVariable("sprintNum") int sprintNum ) {
		return sprintReportService.getSprintReport(teamID,sprintNum);
	}
	
	
	/**************************************
	 * Get Last Sprint Report by TeamID
	 * @param teamID
	 * @return SprintReportEntity
	 *****************************************/

	@GetMapping("/lastsprintreport/byteamID/{teamID}")
	public List<SprintReportEntity> getLastSprintReportByTeamID(@PathVariable("teamID") String teamID) {
		return sprintReportService.getLastSprintReportByTeamID(teamID);
	
    }
}
