package com.tax.sprintreport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.sprintreport.entity.ReasonsEntity;
import com.tax.sprintreport.repository.ReasonsRepository;

@Service
public class ReasonsDaoImpl implements ReasonsDao{

	@Autowired
	ReasonsRepository reasonsRepo;
	
	public ReasonsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReasonsEntity> getReasons() {
		return reasonsRepo.getReasons();
	}

	@Override
	public ReasonsEntity addReason(ReasonsEntity reasonsEntity) {
		ReasonsEntity newEntity = reasonsRepo.saveAndFlush(reasonsEntity);
		return newEntity;
	}

}
