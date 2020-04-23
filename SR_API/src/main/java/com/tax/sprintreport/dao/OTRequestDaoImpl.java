package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.FormUIEntity;
import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.repository.OTRequestRepository;

@Service
public class OTRequestDaoImpl implements OTRequestDao{

	@Autowired
	private OTRequestRepository otRequestRespository;
	
	public OTRequestDaoImpl() {
		
	}
	
	@Override
	public List<OTRequestEntity> getOTRequestsAll(){
		return otRequestRespository.getOTRequestsAll();
	}

}
