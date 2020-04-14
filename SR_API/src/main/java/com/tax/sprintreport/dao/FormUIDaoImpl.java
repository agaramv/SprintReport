package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.repository.FormUIRepository;

@Service
public class FormUIDaoImpl implements FormUIDao {

	@Autowired
	private FormUIRepository formUiRepository;
	
	public FormUIDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FormUIEntity> getSprintReportForm() {
		return formUiRepository.getSprintReportForm();
	}

	
	
	

}
