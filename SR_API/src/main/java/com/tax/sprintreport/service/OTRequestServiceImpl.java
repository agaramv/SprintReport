package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.OTRequestDao;
import com.tax.sprintreport.entity.OTRequestEntity;

@Service
public class OTRequestServiceImpl implements OTRequestService{

	@Autowired
	OTRequestDao otRequestDao;
	
	public OTRequestServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OTRequestEntity> getOTRequestsAll() {
		return otRequestDao.getOTRequestsAll();
	}

}
