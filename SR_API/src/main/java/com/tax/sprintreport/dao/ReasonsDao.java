package com.tax.sprintreport.dao;

import java.util.List;

import com.tax.sprintreport.entity.ReasonsEntity;

public interface ReasonsDao {

	//Get All Current Reasons
	List<ReasonsEntity> getReasons();
	
	//Add Reason
	ReasonsEntity addReason(ReasonsEntity reasonsEntity);
}
