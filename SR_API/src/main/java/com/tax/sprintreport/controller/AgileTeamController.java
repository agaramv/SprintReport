package com.tax.sprintreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.sprintreport.entity.AgileTeamEntity;
import com.tax.sprintreport.service.AgileTeamService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AgileTeamController {

	@Autowired
	AgileTeamService agileTeamService;

	@GetMapping("/agileteam/all")
	public List<AgileTeamEntity> getAgileTeam(){
		return agileTeamService.getAgileTeams();
	}
}
