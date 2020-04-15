package com.tax.sprintreport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tax.sprintreport.dao.FormUIDao;
import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.param.FormUIResponse;

@Service
public class FormUIServiceImpl implements FormUIService{

	@Autowired
	FormUIDao formUiDao;
	
	public FormUIServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private List<FormUIResponse> buildFormUIResponse(List<FormUIEntity> formUiEntity){
		
		List<FormUIResponse> FormUIResponse = new ArrayList<FormUIResponse>();
//	    FormUiResponse = FormUIEntity.
		//Build a flat Jason object to send to client (avoid sending composite json object to client)
		FormUIResponse = formUiEntity.stream().map(
				formUi -> new FormUIResponse(
						formUi.getFormUiEntityKey().getVersionNum(),
						formUi.getFormUiEntityKey().getLineNum(),
						formUi.getActiveInd(),
						formUi.getWorkCode(),
						formUi.getWorkDesc(),
						formUi.getInfoType(),
						formUi.getSupportInd(),
						formUi.getValueInd(),
						formUi.getNewValueInd(),
						formUi.getRunInd(),
						formUi.getGrowInd(),
						formUi.getTransformInd()
						)
				).collect(Collectors.toList());
		System.out.println(FormUIResponse);
		return FormUIResponse;
	}

	@Override
	public List<FormUIResponse> getSprintReportForm() {
		return buildFormUIResponse(formUiDao.getSprintReportForm());
	}
	

}
