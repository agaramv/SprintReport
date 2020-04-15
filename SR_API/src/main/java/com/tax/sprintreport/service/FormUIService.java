package com.tax.sprintreport.service;

import java.util.List;

import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.param.FormUIResponse;

public interface FormUIService {

	//Get Sprint Report Form-Active 
	public List<FormUIResponse> getSprintReportForm();
}
