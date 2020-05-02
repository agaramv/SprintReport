package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.OTRequestEntity;
import com.tax.sprintreport.repository.OTRequestRepository;

@Service
public class OTRequestDaoImpl implements OTRequestDao{

	@Autowired
	private OTRequestRepository otRequestRepo;
	
	public OTRequestDaoImpl() {
		
	}
	
	@Override
	public List<OTRequestEntity> getOTRequestsAll(){
		return otRequestRepo.getOTRequestsAll();
	}

	@Override
	public OTRequestEntity addOTRequest(OTRequestEntity otRequestEntity) {
		OTRequestEntity newEntity = otRequestRepo.saveAndFlush(otRequestEntity);
		return newEntity;
	}

}
