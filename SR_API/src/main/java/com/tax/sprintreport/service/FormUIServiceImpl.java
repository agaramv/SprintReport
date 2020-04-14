package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.FormUIDao;
import com.tax.sprintreport.entity.FormUIEntity;

@Service
public class FormUIServiceImpl implements FormUIService{

	@Autowired
	FormUIDao formUiDao;
	
	public FormUIServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FormUIEntity> getSprintReportForm() {
		return formUiDao.getSprintReportForm();
	}
	

}
