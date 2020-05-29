package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.ScrumMasterEntity;

public interface ScrumMasterService {

		//Get All emails
		List<ScrumMasterEntity> getScrumMasterEmails();
		
		//add email
		ScrumMasterEntity addScrumMasterEmail(ScrumMasterEntity scrumMasterEntity);
}
