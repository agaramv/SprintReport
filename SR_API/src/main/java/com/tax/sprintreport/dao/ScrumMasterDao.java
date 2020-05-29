package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.ScrumMasterEntity;

public interface ScrumMasterDao {

	//Get All emails
	List<ScrumMasterEntity> getScrumMasterEmails();
	
	//add email
	ScrumMasterEntity addScrumMasterEmail(ScrumMasterEntity scrumMasterEntity);
}
