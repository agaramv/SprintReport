package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.ScrumMasterEntity;
import com.tax.sprintreport.repository.ScrumMasterRepository;

@Service
public class ScrumMasterDaoImpl implements ScrumMasterDao{

	public ScrumMasterDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	ScrumMasterRepository scrumMasterRepo;

	@Override
	public List<ScrumMasterEntity> getScrumMasterEmails() {
		return scrumMasterRepo.findAll();
	}

	@Override
	public ScrumMasterEntity addScrumMasterEmail(ScrumMasterEntity scrumMasterEntity) {
		ScrumMasterEntity newEntity = scrumMasterRepo.saveAndFlush(scrumMasterEntity);
		return newEntity;
	}

}
