package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.AgileTeamEntity;
import com.tax.sprintreport.repository.AgileTeamRepository;

@Service
public class AgileTeamDaoImpl implements AgileTeamDao{

	@Autowired
	AgileTeamRepository agileTeamRepo;
	
	public AgileTeamDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AgileTeamEntity> getAgileTeams() {
		return agileTeamRepo.findAll();
	}

	@Override
	public AgileTeamEntity addAgileTeam(AgileTeamEntity agileTeamEntity) {
		AgileTeamEntity newEntity = agileTeamRepo.saveAndFlush(agileTeamEntity);
		return newEntity;
	}

}
