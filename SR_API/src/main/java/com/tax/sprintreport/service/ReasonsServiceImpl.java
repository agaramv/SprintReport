package com.tax.sprintreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.dao.ReasonsDao;
import com.tax.sprintreport.entity.ReasonsEntity;

@Service
public class ReasonsServiceImpl implements ReasonsService{

	@Autowired
	ReasonsDao reasonsDao;

	@Override
	public List<ReasonsEntity> getReasons() {
		return reasonsDao.getReasons();
	}

	@Override
	public ReasonsEntity addReason(ReasonsEntity reasonsEntity) {
		return reasonsDao.addReason(reasonsEntity);
	}

}
