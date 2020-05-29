package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.ScrumMasterDao;
import com.tax.sprintreport.entity.ScrumMasterEntity;

@Service
public class ScrumMasterServiceImpl implements ScrumMasterService{
	
	@Autowired
	ScrumMasterDao scrumMasterDao;

	@Override
	public List<ScrumMasterEntity> getScrumMasterEmails() {
		return scrumMasterDao.getScrumMasterEmails();
	}

	@Override
	public ScrumMasterEntity addScrumMasterEmail(ScrumMasterEntity scrumMasterEntity) {
		return scrumMasterDao.addScrumMasterEmail(scrumMasterEntity);
	}

}
