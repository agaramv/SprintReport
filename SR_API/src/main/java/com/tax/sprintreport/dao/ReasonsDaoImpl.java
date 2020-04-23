package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.ReasonsEntity;

@Service
public class ReasonsDaoImpl implements ReasonsDao{

	@Autowired
	ReasonsDao reasonsDao;
	
	public ReasonsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReasonsEntity> getReasons() {
		return reasonsDao.getReasons();
	}

}
