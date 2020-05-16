package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.AgileTeamDao;
import com.tax.sprintreport.entity.AgileTeamEntity;

@Service
public class AgileTeamServiceImpl implements AgileTeamService{

	
	@Autowired
	AgileTeamDao agileTeamDao;

	@Override
	public List<AgileTeamEntity> getAgileTeams() {
		return agileTeamDao.getAgileTeams();
	}

	@Override
	public AgileTeamEntity addAgileTeam(AgileTeamEntity agileTeamEntity) {
		return agileTeamDao.addAgileTeam(agileTeamEntity);
	}

}
