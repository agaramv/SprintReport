package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.AgileTeamEntity;

public interface AgileTeamDao {

	List<AgileTeamEntity> getAgileTeams();
	
	AgileTeamEntity addAgileTeam(AgileTeamEntity agileTeamEntity);
}
